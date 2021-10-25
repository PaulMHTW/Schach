package chessgame.game;

public class InvalidColorException extends Exception{

    public InvalidColorException(String message, Throwable cause) {
        super(message, cause);
    }

    public InvalidColorException(String message) {
        super(message);
    }
}
