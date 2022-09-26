package com.epsilon.homebanking.security;

import com.epsilon.homebanking.user.infrastructure.rest.response.ErrorResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import javax.servlet.http.HttpServletResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;

public class ResponseUtils {

  private ResponseUtils() {}

  public static void setCustomForbiddenResponse(HttpServletResponse response) throws IOException {
    response.setStatus(HttpStatus.FORBIDDEN.value());
    response.setContentType(MediaType.APPLICATION_JSON_VALUE);
    ObjectMapper mapper = new ObjectMapper();
    response.getWriter().write(mapper.writeValueAsString(getGenericUserErrorResponse()));
  }

  private static ErrorResponse getGenericUserErrorResponse() {
    return ErrorResponse.builder()
        .statusCode(HttpStatus.FORBIDDEN.value())
        .message("Access denied. Please, try to login again or contact an admin.")
        .build();
  }
}
