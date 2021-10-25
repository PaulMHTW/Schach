package chessgame.pieces;

import chessgame.game.ChessImpl;

public class Pawn extends PieceImpl {
    private boolean firstMove;
    private int direction;

    public Pawn(PieceColors color) {
        super(color);
        firstMove = true;
        // white pawns move "downwards" black pieces move "upwards"
        switch (this.color) {
            case BLACK -> this.direction = 1;
            case WHITE -> this.direction = -1;
        }
    }

    @Override
    public void calculateLegalMoves(int posX, int posY, Piece[][] board) {
        // reset
        this.legalMoves.clear();

        // check if allowed to do double move (two forward)
        int newY = this.direction * 2;
        if (firstMove) {
            // is blocked?
            if (board[posX][posY + this.direction] == null && board[posX][posY + newY] == null) {
                //double move allowed
                this.legalMoves.add(posX + "" + newY);
            }
        }

        // normal move (one forward)
        newY = posY + this.direction;
        // is still on the board? (pawn upgrade rule might be implemented here later)
        if (0 <= newY && newY < ChessImpl.BOARDSIZE) {
            // is blocked?
            if (board[posX][newY] == null) {
                //move allowed
                this.legalMoves.add(posX + "" + newY);
            }
        }

        //capture diagonally
        newY = posY + this.direction;
        //"to the left"
        int newX = posX - 1;
        // on board?
        if (newX >= 0) {
            //is there a Piece of the opposite color?
            if (board[newX][newY].getColor() != null) {
                if (board[newX][newY].getColor() != this.color) {
                    //move allowed
                    this.legalMoves.add(newX - 1 + "" + newY);
                }
            }
        }
        //"to the right"
        newX = posX + 1;
        // on board?
        if (newX < ChessImpl.BOARDSIZE) {
            //is there a Piece of the opposite color?
            if (board[newX][newY].getColor() != null) {
                if (board[newX][newY].getColor() != this.color) {
                    //move allowed
                    this.legalMoves.add(newX + "" + newY);
                }
            }
        }
    }

    public void wasMoved() {
        this.firstMove = false;
    }
}