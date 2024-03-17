package dat.nguyen.home.assistant.user.dto.user;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import dat.nguyen.home.assistant.user.dto.token.TokenResponse;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class UserCreateResponse {

  @JsonProperty("user")
  private UserGeneralResponse user;

  @JsonProperty("token")
  private TokenResponse token;
}
