package com.epsilon.homebanking.security.filter;

import com.epsilon.homebanking.security.common.JwtUtils;
import com.epsilon.homebanking.security.common.JwtUtils.Jwt;
import io.jsonwebtoken.JwtException;
import java.io.IOException;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

@Component
@RequiredArgsConstructor
public class AuthorizationFilter extends OncePerRequestFilter {

  private static final String BEARER_PART = "Bearer ";
  private static final Object CREDENTIALS = "";

  private static void setAuthentication(String authorizationHeader) {
    Jwt jwt = JwtUtils.extract(authorizationHeader);
    Authentication authentication = new UsernamePasswordAuthenticationToken(
        jwt.getUsername(),
        CREDENTIALS,
        jwt.getGrantedAuthorities());
    SecurityContextHolder.getContext().setAuthentication(authentication);
  }

  @Override
  protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response,
      FilterChain filterChain) throws ServletException, IOException {
    String authorizationHeader = request.getHeader(HttpHeaders.AUTHORIZATION);

    if (!isValid(authorizationHeader)) {
      SecurityContextHolder.clearContext();
      filterChain.doFilter(request, response);
      return;
    }

    try {
      setAuthentication(authorizationHeader);
      filterChain.doFilter(request, response);
    } catch (JwtException e) {
      throw new IllegalStateException("Invalid JWT signature.");
    }
  }

  private boolean isValid(String authorizationHeader) {
    return StringUtils.hasText(authorizationHeader) && authorizationHeader.startsWith(BEARER_PART);
  }
}