package chessgame.pieces;

import chessgame.game.ChessImpl;

public class Rook extends PieceImpl {
    public Rook(PieceColors color) {
        super(color);
    }

    @Override
    public void calculateLegalMoves(int posX, int posY, Piece[][] board) {
        // reset
        this.legalMoves.clear();
        //******************************Horizontal line*************************
        // in x plus direction
        for (int i = posX + 1; i < ChessImpl.BOARDSIZE; i++) {
            // is blocked?
            if (board[i][posY] != null) {
                // can capture?
                if(board[i][posY].getColor() != this.color){
                    this.legalMoves.add(i + "" + posY);
                }
                // stop looking this direction (kill for loop)
                i = ChessImpl.BOARDSIZE;
            } else {
                this.legalMoves.add(i + "" + posY);
            }
        }
        // in x minus direction
        for (int i = posX - 1; i >= 0; i--) {
            // is blocked?
            if (board[i][posY] != null) {
                // can capture?
                if(board[i][posY].getColor() != this.color){
                    this.legalMoves.add(i + "" + posY);
                }
                // stop looking this direction (kill for loop)
                i = -1;
            } else {
                this.legalMoves.add(i + "" + posY);
            }
        }
        //******************************Vertical line*************************
        // in y plus direction
        for (int j = posY + 1; j < ChessImpl.BOARDSIZE; j++) {
            // is blocked?
            if (board[j][posY] != null) {
                // can capture?
                if(board[j][posY].getColor() != this.color){
                    this.legalMoves.add(j + "" + posY);
                }
                // stop looking this direction (kill for loop)
                j = ChessImpl.BOARDSIZE;
            } else {
                this.legalMoves.add(j + "" + posY);
            }
        }
        // in y minus direction
        for (int j = posY - 1; j >= 0; j--) {
            // is blocked?
            if (board[j][posY] != null) {
                // can capture?
                if(board[j][posY].getColor() != this.color){
                    this.legalMoves.add(j + "" + posY);
                }
                // stop looking this direction (kill for loop)
                j = -1;
            } else {
                this.legalMoves.add(j + "" + posY);
            }
        }
    }

    @Override
    public void wasMoved() {
    }
}
