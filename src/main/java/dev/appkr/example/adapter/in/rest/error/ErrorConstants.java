package dev.appkr.example.adapter.in.rest.error;

import java.net.URI;

public final class ErrorConstants {

  public static final String ERR_VALIDATION = "error.validation";
  public static final String PROBLEM_BASE_URL = "example";
  public static final URI DEFAULT_TYPE = URI.create(PROBLEM_BASE_URL + "/problem-with-message");
  public static final URI CONSTRAINT_VIOLATION_TYPE = URI.create(PROBLEM_BASE_URL + "/constraint-violation");

  private ErrorConstants() {
  }
}