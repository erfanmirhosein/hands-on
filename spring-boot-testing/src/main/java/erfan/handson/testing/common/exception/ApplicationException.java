package erfan.handson.testing.common.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import static erfan.handson.testing.common.exception.HttpError.NOT_FOUND;

@Getter
@RequiredArgsConstructor
public class ApplicationException extends RuntimeException {
    private final int resultingHttpStatus;
    private final String message;
    private final Throwable cause;

    public static final ApplicationException RESOURCE_NOT_FOUND = new ApplicationException(NOT_FOUND.getStatusCode(), NOT_FOUND.getMessage(), null);
}
