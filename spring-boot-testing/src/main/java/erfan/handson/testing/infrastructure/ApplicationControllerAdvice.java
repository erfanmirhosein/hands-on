package erfan.handson.testing.infrastructure;

import erfan.handson.testing.common.exception.ApplicationException;
import erfan.handson.testing.common.exception.ErrorResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ApplicationControllerAdvice {
    @ExceptionHandler(ApplicationException.class)
    ResponseEntity<ErrorResponseDto> handleDomainException(ApplicationException exception) {
        return ResponseEntity.status(exception.getResultingHttpStatus()).body(new ErrorResponseDto(exception.getResultingHttpStatus(), exception.getMessage()));
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    ResponseEntity<ErrorResponseDto> handleValidationException(MethodArgumentNotValidException exception) {
        return ResponseEntity.badRequest().body(new ErrorResponseDto(HttpStatus.BAD_REQUEST.value(), exception.getLocalizedMessage()));
    }

}
