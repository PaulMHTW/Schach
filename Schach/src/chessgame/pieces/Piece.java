package chessgame.pieces;

import java.util.ArrayList;

public interface Piece {

    /**
     * @return The color of the Piece
     */
    public PieceColors getColor();

    /**
     * @return  A list with all positions where the piece is allowed to move
     */
    public ArrayList<String> getLegalMoves();

    /**
     * A list of all position where the piece is allowed to move will be created. The positions come as strings
     * Example: 11 or 70, the first number is th x coordinate while the second number is the y coordinate
     * @param posX x-position where the piece is currently at
     * @param posY y-position where the piece is currently at
     * @param board the board on which the piece is standing in form of an 2D array of pieces. Empty fields with
     *              no piece should be null
     */
    public void calculateLegalMoves(int posX,int posY, Piece[][] board);

    /**
     * If there is stuff to be handled after the piece was moved (can be left empty)
     */
    public void wasMoved();
}