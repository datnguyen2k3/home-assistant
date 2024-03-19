package dat.nguyen.home.assistant.user.service;

import dat.nguyen.home.assistant.user.dto.token.TokenCreateRequest;
import dat.nguyen.home.assistant.user.dto.token.TokenResponse;
import dat.nguyen.home.assistant.user.entity.UserAuthentication;
import dat.nguyen.home.assistant.user.exception.type.UserNotFoundException;
import dat.nguyen.home.assistant.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
@RequiredArgsConstructor
public class TokenService {

  private final UserRepository userRepository;
  private final AuthenticationManager authenticationManager;
  private final JwtService jwtService;


  public TokenResponse createToken(TokenCreateRequest request) {
    authenticationManager.authenticate(
        new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));

    var user = userRepository.findByUsername(request.getUsername())
        .orElseThrow(UserNotFoundException::new);

    return createToken(new UserAuthentication(user));
  }

  public TokenResponse createToken(UserAuthentication userAuthentication) {
    String token = jwtService.generateToken(userAuthentication);
    return TokenResponse.builder()
        .token(token)
        .expiredAt(new Date(System.currentTimeMillis() + JwtService.EXPIRED_TIME))
        .build();
  }
}
