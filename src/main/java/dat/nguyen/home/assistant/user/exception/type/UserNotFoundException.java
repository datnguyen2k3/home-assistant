package dat.nguyen.home.assistant.user.exception.type;

public class UserNotFoundException extends RuntimeException{
  private static final String USER_NOT_FOUND = "User not found";

  public UserNotFoundException() {
    super(USER_NOT_FOUND);
  }
}
