package ChessGame.ChessGameExceptions;

public class IllegalMoveException extends Exception{

    public IllegalMoveException(String message, Throwable cause) {
        super(message, cause);
    }

    public IllegalMoveException(String message) {
        super(message);
    }
}
