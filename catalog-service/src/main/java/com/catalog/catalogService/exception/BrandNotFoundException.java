package com.catalog.catalogService.exception;

public class BrandNotFoundException extends RuntimeException {

  public BrandNotFoundException(String msg) {
    super(msg);
  }
}
