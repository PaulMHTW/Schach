package chessgame.pieces;

import chessgame.game.ChessImpl;

public class Knight extends PieceImpl {
    public Knight(PieceColors color) {
        super(color);
    }

    @Override
    public void calculateLegalMoves(int posX, int posY, Piece[][] board) {
        // reset
        this.legalMoves.clear();
        // list all 8 possible positions for a knight in the middle of the board (relative to its own position)
        int[] yMoves = {2, 2, 1, -1, -2, -2, -1, 1};
        int[] xMoves = {-1, 1, 2, 2, 1, -1, -2, -2};
        // test all positions listed above
        int j, i;
        for (int x = 0; x < 8; x++) {
            i = posX + xMoves[x];
            j = posY + yMoves[x];
            // position exists on board?
            if (i >= 0 && i < ChessImpl.BOARDSIZE &&
                    j >= 0 && j < ChessImpl.BOARDSIZE)
                //is blocked?
                if (board[i][j] != null) {
                    // can capture?
                    if (board[i][j].getColor() != this.color) {
                        this.legalMoves.add(i + "" + j);
                    }
                } else {
                    this.legalMoves.add(i + "" + j);
                }
        }
    }

    @Override
    public void wasMoved() {
        this.legalMoves.clear();
    }

}
