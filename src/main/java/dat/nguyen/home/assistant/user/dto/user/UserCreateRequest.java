package dat.nguyen.home.assistant.user.dto.user;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
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
public class UserCreateRequest {
  @NotBlank
  @Size(min = 6, max = 255)
  private String username;

  @NotBlank
  @Size(min = 6, max = 255)
  private String password;

  @NotBlank
  @Size(min = 6, max = 255)
  private String name;

  @NotBlank
  @Email
  private String email;
}
