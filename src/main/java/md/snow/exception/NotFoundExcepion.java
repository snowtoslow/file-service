package md.snow.exception;

public class NotFoundExcepion extends RuntimeException {

    @Override
    public String getMessage() {
        return "Not Found";
    }
}
