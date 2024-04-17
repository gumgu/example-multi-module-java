package hello.web.support.error;

public class ApiSyncFailedException extends RuntimeException {

    private final ErrorType errorType;

    public ApiSyncFailedException(ErrorType errorType) {
        this.errorType = errorType;
    }
}
