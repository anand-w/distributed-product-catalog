package com.catalog.catalogService.repository;

import com.catalog.catalogService.model.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserDetailsRepository extends JpaRepository<Users,Long> {

    Optional<Users> findByuserName(String userName);
}
