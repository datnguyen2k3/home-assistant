package dat.nguyen.home.assistant.user.service;

import dat.nguyen.home.assistant.user.dto.token.TokenResponse;
import dat.nguyen.home.assistant.user.dto.user.UserCreateRequest;
import dat.nguyen.home.assistant.user.dto.user.UserCreateResponse;
import dat.nguyen.home.assistant.user.dto.user.UserGeneralResponse;
import dat.nguyen.home.assistant.user.entity.User;
import dat.nguyen.home.assistant.user.entity.UserAuthentication;
import dat.nguyen.home.assistant.user.mapper.UserCreateMapper;
import dat.nguyen.home.assistant.user.mapper.UserGeneralMapper;
import dat.nguyen.home.assistant.user.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

  private final UserRepository userRepository;
  private final UserCreateMapper userCreateMapper;
  private final UserGeneralMapper userGeneralMapper;
  private final PasswordEncoder passwordEncoder;
  private final JwtService jwtService;

  @Transactional
  public UserCreateResponse createUser(UserCreateRequest request) {
    User user = userCreateMapper.toEntity(request);
    user.setPassword(passwordEncoder.encode(request.getPassword()));

    user = userRepository.saveAndFlush(user);
    UserGeneralResponse userGeneralResponse = userGeneralMapper.toDto(user);
    TokenResponse tokenResponse = jwtService.createToken(new UserAuthentication(user));

    return UserCreateResponse.builder()
        .user(userGeneralResponse)
        .token(tokenResponse)
        .build();
  }
}
