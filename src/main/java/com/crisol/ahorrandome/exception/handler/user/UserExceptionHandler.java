package com.crisol.ahorrandome.exception.handler.user;

import org.hibernate.exception.ConstraintViolationException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.crisol.ahorrandome.dto.api.response.ApiResponse;
import com.crisol.ahorrandome.dto.api.response.ApiResponse.ErrorDetail;
import com.crisol.ahorrandome.dto.api.response.StatusApiResponse;

import jakarta.servlet.http.HttpServletRequest;

@RestControllerAdvice(basePackages = "com.crisol.ahorrandome.controller.user")
public class UserExceptionHandler {

  @ExceptionHandler(DataIntegrityViolationException.class)
  public ResponseEntity<ApiResponse<Object>> handleDataIntegrity(DataIntegrityViolationException ex,
      HttpServletRequest request

  ) {
    ErrorDetail errorDetail = generateErrorType(ex);

    ApiResponse<Object> response = ApiResponse.error(errorDetail, HttpStatus.CONFLICT,StatusApiResponse.CONFLICT);

    return ResponseEntity.status(HttpStatus.CONFLICT).body(response);
  }


  @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
  public ResponseEntity<ApiResponse<Object>> handleMethodNotAllowed(HttpRequestMethodNotSupportedException ex,
      HttpServletRequest request

  ) {
    ErrorDetail errorDetail = generateErrorType(ex);

    ApiResponse<Object> response = ApiResponse.error(errorDetail, HttpStatus.METHOD_NOT_ALLOWED,StatusApiResponse.METHOD_NOT_ALLOWED);

    return ResponseEntity.status(HttpStatus.METHOD_NOT_ALLOWED).body(response);
  }

  @ExceptionHandler(UserNotFoundException.class)
  public ResponseEntity<ApiResponse<Object>> handleMethodNotAllowed(UserNotFoundException ex,
      HttpServletRequest request

  ) {
    ErrorDetail errorDetail = generateErrorType(ex);

    ApiResponse<Object> response = ApiResponse.error(errorDetail, HttpStatus.METHOD_NOT_ALLOWED,StatusApiResponse.METHOD_NOT_ALLOWED);

    return ResponseEntity.status(HttpStatus.METHOD_NOT_ALLOWED).body(response);
  }


  private ErrorDetail generateErrorType(Throwable ex) {
    ErrorDetail errorDetail = ErrorDetail.builder()
        .code(StatusApiResponse.BAD_REQUEST.name())
        .message("Peticion invalida.")
        .field(StatusApiResponse.NOT_FOUND.name())
        .build();
    // Inspeccionamos la causa
    if (ex.getCause() instanceof ConstraintViolationException cve) {
      String constraint = cve.getConstraintName();

      if ("users_email_key".equals(constraint)) {
        errorDetail = buildErrorDetailDuplicateEmail( StatusApiResponse.EMAIL_ALREADY_EXISTS.name(), "El email ya está registrado.");
      }
    }
    return errorDetail;

  }

  private ErrorDetail buildErrorDetailDuplicateEmail(String code, String message) {

    return ErrorDetail.builder()
        .code(code)
        .message(message)
        .field(StatusApiResponse.EMAIL.name())
        .build();
  }
}
