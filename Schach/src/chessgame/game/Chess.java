package chessgame.game;

public interface Chess {
    /**
     * The Player is prompted to enter a Name and choose a color to play with. If
     * both Players pick the same Color, Colors will be randomly assigned.
     *
     * @param name  The alias the player is going to play as.
     * @param color The color the player would prefer to play as (valid colors black/white/random)
     * @throws InvalidColorException Case anything, but "white" or "black" was entered
     */
    public void selectNameAndColor(String name, String color) throws InvalidColorException;

    /**
     * The Player enters the next move he wants to make; the format should be, first the field where the
     * piece, which should be moved is now and than the field where the piece should be placed. There should
     * be no whitespace between the coordinates and capitalisation does not matter. Example: "B1C4" or "b1c4"
     *
     * @param newMove a string containing the two coordinates. Where the piece is standing where it should be
     *                moved to.
     * @throws IllegalMoveException;        The move is not allowed according to the rules of chess
     * @throws InvalidPieceException;       The piece either does not exist or is of opposing color
     * @throws InvalidCoordinatesException; The coordinates entered are not part of the field or in the wrong
     *                                      format.
     */
    public void movePiece(String newMove)
            throws IllegalMoveException, InvalidPieceException, InvalidCoordinatesException;

}
