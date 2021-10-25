package chessgame.pieces;

import java.util.ArrayList;


public abstract class PieceImpl implements Piece {

    protected final PieceColors color;
    protected ArrayList<String> legalMoves;

    public PieceImpl(PieceColors color) {
        this.color = color;
        this.legalMoves = new ArrayList<String>();
    }

    public PieceColors getColor() {
        return this.color;
    }

    public ArrayList<String> getLegalMoves() {
        return this.legalMoves;
    }

    public abstract void calculateLegalMoves(int posX, int posY, Piece[][] board);

    public abstract void wasMoved();
}