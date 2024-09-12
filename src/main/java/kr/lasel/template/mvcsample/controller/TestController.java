package kr.lasel.template.mvcsample.controller;

import kr.lasel.template.mvcsample.model.common.response.BaseResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("/test")
public class TestController {

  @GetMapping("/")
  public BaseResponse<?> test() {
    return BaseResponse.builder()
      .status(HttpStatus.OK.value())
      .data("Hello, World!")
      .build();
  }

}
