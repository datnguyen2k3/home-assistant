package dat.nguyen.home.assistant.user.controller;

import dat.nguyen.home.assistant.user.dto.token.TokenCreateRequest;
import dat.nguyen.home.assistant.user.dto.token.TokenResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@Validated
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/users", produces = "application/json")
@SecurityRequirement(name = "Bearer Authentication")
public class UserController {

  @PostMapping("/token")
  public ResponseEntity<TokenResponse> createToken(@RequestBody @Valid TokenCreateRequest request) {
    return ResponseEntity.ok(TokenResponse.builder()
        .token("token")
        .expiredAt(new Date())
        .build());
  }
}
