package com.epsilon.homebanking.exception;

import java.text.MessageFormat;

public enum ErrorMessage {
  RECORD_NOT_FOUND("{0} not found."),
  OPERATION_NOT_PERMITTED("Operation not permitted."),
  USER_ALREADY_EXISTS("Email is being used, try another!"),
  INVALID_CREDENTIALS("Invalid username or password.");

  private final String message;

  ErrorMessage(String message) {
    this.message = message;
  }

  public String getMessage(String object) {
    return MessageFormat.format(message, object);
  }

  public String getMessage() {
    return message;
  }
}