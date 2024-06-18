public class EmptyListException extends RuntimeException {
    EmptyListException() {
        super();
    }

    EmptyListException(String message) {
        super(message);
    }
}
