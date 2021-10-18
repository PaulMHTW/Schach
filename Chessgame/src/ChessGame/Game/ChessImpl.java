package ChessGame.Game;

import ChessGame.ChessGameExceptions.*;

public class ChessImpl implements Chess{
    String PlayerName;
    String PlayerColor;

    @Override
    public void selectNameAndColor(String name, String color)
            throws InvalidColorException {
            PlayerName = name;
            if(color.equals("black") || color.equals("white") || color.equals("random")){
                PlayerColor = color;
            }else{
                throw new InvalidColorException(color + " is an invalid Choice, choose black/white or random");
            }
    }

    @Override
    public void movePiece(String newMove)
            throws IllegalMoveException, InvalidPieceException, InvalidCoordinatesException {

    }
}
