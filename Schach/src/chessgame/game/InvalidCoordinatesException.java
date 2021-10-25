package chessgame.game;

public class InvalidCoordinatesException extends Exception{

    public InvalidCoordinatesException(String message, Throwable cause) {
        super(message, cause);
    }

    public InvalidCoordinatesException(String message) {
        super(message);
    }
}
