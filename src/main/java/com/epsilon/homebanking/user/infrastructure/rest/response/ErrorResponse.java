package com.epsilon.homebanking.user.infrastructure.rest.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
@AllArgsConstructor
public class ErrorResponse {

  private int statusCode;
  private String message;
  @JsonInclude(JsonInclude.Include.NON_EMPTY)
  private List<String> moreInfo;

  public ErrorResponse(int statusCode, String message, String moreInfo) {
    this.statusCode = statusCode;
    this.message = message;
    this.moreInfo = List.of(moreInfo);
  }
}