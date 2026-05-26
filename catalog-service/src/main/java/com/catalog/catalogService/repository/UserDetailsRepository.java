package com.catalog.catalogService.repository;

import com.catalog.catalogService.model.entity.Users;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDetailsRepository extends JpaRepository<Users, Long> {

  Optional<Users> findByuserName(String userName);
}
