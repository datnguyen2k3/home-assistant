package dat.nguyen.home.assistant.common.exception.handler;

import dat.nguyen.home.assistant.common.exception.response.ErrorListResponse;
import dat.nguyen.home.assistant.common.exception.response.ErrorResponse;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.ArrayList;
import java.util.List;

@ControllerAdvice
public class DefaultExceptionHandler extends ResponseEntityExceptionHandler {
  @Override
  public ResponseEntity<Object> handleMethodArgumentNotValid(
        MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request)
  {
    List<ErrorResponse> errorResponses = new ArrayList<>();
    for (FieldError error : ex.getBindingResult().getFieldErrors()) {
        errorResponses.add(ErrorResponse.builder()
            .error(error.getField() + ": " + error.getDefaultMessage())
            .build());
    }
    for (ObjectError error : ex.getBindingResult().getGlobalErrors()) {
        errorResponses.add(ErrorResponse.builder()
            .error(error.getObjectName() + ": " + error.getDefaultMessage())
            .build());
    }


    return new ResponseEntity<>(new ErrorListResponse(errorResponses), HttpStatus.BAD_REQUEST);
  }
}
