package kr.lasel.b2bmall.authapi.common.exception;

import kr.lasel.b2bmall.authapi.model.common.response.BaseResponse;
import kr.lasel.b2bmall.authapi.model.common.response.ErrorResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.client.HttpClientErrorException.NotFound;
import org.springframework.web.servlet.NoHandlerFoundException;
import org.springframework.web.servlet.resource.NoResourceFoundException;

@Slf4j
@ResponseBody
@RestControllerAdvice
public class GlobalExceptionHandler {

  @ResponseStatus(HttpStatus.NOT_FOUND)
  @ExceptionHandler(value = {
    NoHandlerFoundException.class,
    NoResourceFoundException.class,
    NotFound.class
  })
  public BaseResponse<?> noHandlerExceptionHandler(Exception e) {
    log.debug("Exception: {}", e.getMessage());
    return BaseResponse.builder()
      .status(HttpStatus.NOT_FOUND.value())
      .errorResponse(
        ErrorResponse.builder()
          .code(HttpStatus.NOT_FOUND.value())
          .message("Not Found")
          .detailInfo(e.getLocalizedMessage())
          .build()
      )
      .build();
  }

  @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
  @ExceptionHandler(value = {
    RuntimeException.class,
    Exception.class
  })
  public BaseResponse<?> internalServerErrorHandler(Exception e) {
    log.error("Exception: {}", e.getMessage());
    return BaseResponse.builder()
      .status(HttpStatus.INTERNAL_SERVER_ERROR.value())
      .errorResponse(
        ErrorResponse.builder()
          .code(HttpStatus.INTERNAL_SERVER_ERROR.value())
          .message("Internal Server Error")
          .detailInfo(e.getLocalizedMessage())
          .build()
      )
      .build();
  }
}
