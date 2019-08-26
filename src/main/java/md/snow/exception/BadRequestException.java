package md.snow.exception;

public class BadRequestException extends RuntimeException {

    @Override
    public String getMessage() {
        return "Bad Request";
    }
}
