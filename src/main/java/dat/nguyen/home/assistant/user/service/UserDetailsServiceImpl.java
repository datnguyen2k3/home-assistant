package dat.nguyen.home.assistant.user.service;

import dat.nguyen.home.assistant.user.entity.User;
import dat.nguyen.home.assistant.user.entity.UserAuthentication;
import dat.nguyen.home.assistant.user.exception.type.UserNotFoundException;
import dat.nguyen.home.assistant.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {

  private final UserRepository userRepository;

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    User user = userRepository.findByUsername(username)
        .orElseThrow(UserNotFoundException::new);

    return new UserAuthentication(user);
  }

  public UserDetails loadUserByUserId(Long userId) {
    User user = userRepository.findById(userId)
        .orElseThrow(UserNotFoundException::new);

    return new UserAuthentication(user);
  }
}
