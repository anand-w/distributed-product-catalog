package com.catalog.catalogService.controller;

import com.catalog.catalogService.model.entity.AuthRequest;
import com.catalog.catalogService.utility.JwtUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/authenticate")
public class AuthController {

  @Autowired private AuthenticationManager authenticationManager;

  @Autowired private JwtUtility jwtUtility;

  @PostMapping
  public String generateToken(@RequestBody AuthRequest request) {

    authenticationManager.authenticate(
        new UsernamePasswordAuthenticationToken(request.getUserName(), request.getPassword()));

    return jwtUtility.generateToken(request.getUserName());
  }
}
