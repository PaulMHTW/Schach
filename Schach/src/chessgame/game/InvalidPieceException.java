package chessgame.game;

public class InvalidPieceException extends Exception {

    public InvalidPieceException(String message, Throwable cause) {
        super(message, cause);
    }

    public InvalidPieceException(String message) {
        super(message);
    }
}
