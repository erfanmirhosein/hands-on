package erfan.handson.testing.common.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum HttpError {
    NOT_FOUND(404, "Resource was not found");
    private final int statusCode;
    private final String message;
}
