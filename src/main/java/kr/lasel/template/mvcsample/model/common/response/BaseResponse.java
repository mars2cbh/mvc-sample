package kr.lasel.template.mvcsample.model.common.response;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.json.JsonMapper;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BaseResponse<T> {

  @Builder.Default
  private int status = 200;

  @Builder.Default
  private T data = null;

  @Builder.Default
  @JsonProperty(value = "error")
  ErrorResponse errorResponse = null;

  @JsonIgnore
  public String toJson() throws JsonProcessingException {
    JsonMapper mapper = new JsonMapper();
    return mapper.writeValueAsString(this);
  }
}
