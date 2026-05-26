package com.catalog.catalogService.security;

import com.catalog.catalogService.service.CustomUserDetailsService;
import com.catalog.catalogService.service.JwtFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfigCatalog {

  @Autowired private JwtFilter jwtFilter;

  @Autowired private CustomUserDetailsService customUserDetailsService;

  @Bean
  public SecurityFilterChain filterChain(HttpSecurity httpSecurity) {

    httpSecurity
        .csrf(t -> t.disable())
        .authorizeHttpRequests(
            requests ->
                requests
                    .requestMatchers("/authenticate", "/register")
                    .permitAll()
                    .anyRequest()
                    .authenticated());

    httpSecurity.addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);
    return httpSecurity.build();
  }

  @Bean
  public PasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
  }

  @Bean
  public AuthenticationManager authenticationManager(PasswordEncoder passwordEncoder) {

    DaoAuthenticationProvider daoAuthenticationProvider =
        new DaoAuthenticationProvider(customUserDetailsService);
    daoAuthenticationProvider.setPasswordEncoder(passwordEncoder);

    return new ProviderManager(daoAuthenticationProvider);
  }
}
