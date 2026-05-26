package com.catalog.catalogService.service;

import com.catalog.catalogService.utility.JwtUtility;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

@Component
public class JwtFilter extends OncePerRequestFilter {
  /**
   * Same contract as for {@code doFilter}, but guaranteed to be just invoked once per request
   * within a single request thread. See {@link #shouldNotFilterAsyncDispatch()} for details.
   *
   * <p>Provides HttpServletRequest and HttpServletResponse arguments instead of the default
   * ServletRequest and ServletResponse ones.
   *
   * @param request
   * @param response
   * @param filterChain
   */
  @Autowired private JwtUtility jwtUtility;

  @Autowired private CustomUserDetailsService customUserDetailsService;

  @Override
  protected void doFilterInternal(
      HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
      throws ServletException, IOException {
    String authHeader = request.getHeader("Authorization");

    try {
      String token = null;
      String username = null;
      if (authHeader != null && authHeader.startsWith("Bearer ")) {
        token = authHeader.substring(7);
        username = jwtUtility.extractUserNameFromToken(token);
      }
      if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {

        // fetch username from db
        UserDetails userDetails = customUserDetailsService.loadUserByUsername(username);

        if (jwtUtility.validateToken(username, userDetails, token)) {
          UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken =
              new UsernamePasswordAuthenticationToken(
                  userDetails, null, userDetails.getAuthorities());
          SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
        }
      }
      filterChain.doFilter(request, response);
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }
  }
}
