package com.catalog.catalogService.controller;

import com.catalog.catalogService.model.entity.Users;
import com.catalog.catalogService.repository.UserDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/register")
public class UserController {

  @Autowired private UserDetailsRepository userDetailsRepository;

  @Autowired private PasswordEncoder passwordEncoder;

  @PostMapping
  public String registerUser(@RequestBody Users user) {
    user.setPassword(passwordEncoder.encode(user.getPassword()));
    userDetailsRepository.save(user);
    return "User registered successfully";
  }
}
