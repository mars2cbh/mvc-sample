package kr.lasel.b2bmall.authapi.model.common.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ErrorResponse {

  @Builder.Default
  int code = 0;

  @Builder.Default
  String message = null;

  @Builder.Default
  Object detailInfo = null;
}
