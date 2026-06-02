package com.catalog.catalogService.service;

import com.catalog.catalogService.dto.request.ProductFilterRequestDTO;
import com.catalog.catalogService.dto.request.ProductRequestDto;
import com.catalog.catalogService.dto.response.ProductResponseDto;
import com.catalog.catalogService.exception.BrandNotFoundException;
import com.catalog.catalogService.exception.ProductNotFoundException;
import com.catalog.catalogService.mapper.ProductMapper;
import com.catalog.catalogService.model.entity.Brand;
import com.catalog.catalogService.model.entity.Product;
import com.catalog.catalogService.repository.BrandRepository;
import com.catalog.catalogService.repository.ProductRepository;
import com.catalog.catalogService.repository.specification.ProductSpecification;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import software.amazon.awssdk.core.sync.RequestBody;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.PutObjectRequest;

import java.io.IOException;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

  @Autowired private ProductRepository productRepository;

  @Autowired private BrandRepository brandRepository;

  @Autowired
  private S3Client s3Client;

  @Value("${cloud.aws.bucketname}")
  private String bucketName;

  @Override
  @CacheEvict(value = "product", key = "#result.id", condition = "#result != null")
  public ProductResponseDto save(ProductRequestDto productRequestDto) {

    Brand brand =
        brandRepository
            .findById(productRequestDto.getBrandId())
            .orElseThrow(
                () ->
                    new BrandNotFoundException(
                        "Brand with id " + productRequestDto.getBrandId() + " does not exist"));

    Product product = ProductMapper.toEntity(productRequestDto, brand);
    Product savedProduct = productRepository.save(product);

    return ProductMapper.toResponseDto(savedProduct);
  }

  public Page<ProductResponseDto> getAll(ProductFilterRequestDTO productFilter, Pageable pageable) {

    Specification<Product> spec = ProductSpecification.filterProduct(productFilter);
    Page<Product> productsList = productRepository.findAll(spec, pageable);
    return productsList.map(ProductMapper::toResponseDto);
  }

  @Override
  @Cacheable(value = "product", key = "#id")
  public ProductResponseDto getProductById(Long id) {

    Product product =
        productRepository
            .findById(id)
            .orElseThrow(
                () -> new ProductNotFoundException("Product with id " + id + " does not exist"));

    return ProductMapper.toResponseDto(product);
  }

  @Override
  public String uploadImageByProductId(long id, MultipartFile file) throws IOException {

        Optional<Product> productOptional=productRepository.findById(id);

        if(productOptional!=null){

         String response= uploadImageToS3(file);
          Product product=productOptional.get();
          String imageUrl="https://" + bucketName +
          ".s3.amazonaws.com/" + response;
          product.setImageUrl(imageUrl);
          productRepository.save(product);

        }else {
          throw new ProductNotFoundException("Product with this id does not exist");
        }

        return "File uploaded successfully";
  }

  private String uploadImageToS3(MultipartFile file) throws IOException {

    String fileName = UUID.randomUUID()
            + "-" + file.getOriginalFilename();
    s3Client.putObject(PutObjectRequest.builder()
            .bucket(bucketName)
            .key(fileName)
            .build(),
            RequestBody.fromBytes(file.getBytes()));

    return fileName;
  }
}
