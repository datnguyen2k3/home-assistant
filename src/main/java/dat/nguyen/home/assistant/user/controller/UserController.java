package dat.nguyen.home.assistant.user.controller;

import dat.nguyen.home.assistant.user.dto.token.TokenCreateRequest;
import dat.nguyen.home.assistant.user.dto.token.TokenResponse;
import dat.nguyen.home.assistant.user.dto.user.UserCreateRequest;
import dat.nguyen.home.assistant.user.dto.user.UserCreateResponse;
import dat.nguyen.home.assistant.user.dto.user.UserGeneralResponse;
import dat.nguyen.home.assistant.user.service.UserService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
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

  private final UserService userService;

  @PostMapping("/token")
  public ResponseEntity<TokenResponse> createToken(@RequestBody @Valid TokenCreateRequest request) {
    return ResponseEntity.ok(TokenResponse.builder()
        .token("token")
        .expiredAt(new Date())
        .build());
  }

  @PostMapping("")
  public ResponseEntity<UserCreateResponse> createUser(@RequestBody @Valid UserCreateRequest request) {
    return new ResponseEntity<>(userService.createUser(request), HttpStatus.CREATED);
  }

}
