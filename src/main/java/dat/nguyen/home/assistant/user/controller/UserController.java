package dat.nguyen.home.assistant.user.controller;

import dat.nguyen.home.assistant.user.dto.token.TokenCreateRequest;
import dat.nguyen.home.assistant.user.dto.token.TokenResponse;
import dat.nguyen.home.assistant.user.dto.user.UserCreateRequest;
import dat.nguyen.home.assistant.user.dto.user.UserCreateResponse;
import dat.nguyen.home.assistant.user.service.JwtService;
import dat.nguyen.home.assistant.user.service.TokenService;
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

@Validated
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/users", produces = "application/json")
@SecurityRequirement(name = "Bearer Authentication")
public class UserController {

  private final UserService userService;
  private final TokenService tokenService;

  @PostMapping("/token")
  public ResponseEntity<TokenResponse> createToken(@RequestBody @Valid TokenCreateRequest request) {
    return new ResponseEntity<>(tokenService.createToken(request), HttpStatus.OK);
  }

  @PostMapping("")
  public ResponseEntity<UserCreateResponse> createUser(@RequestBody @Valid UserCreateRequest request) {
    return new ResponseEntity<>(userService.createUser(request), HttpStatus.CREATED);
  }
}
