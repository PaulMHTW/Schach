package chessgame.pieces;

import chessgame.game.ChessImpl;

public class King extends PieceImpl {


    public King(PieceColors color) {
        super(color);
    }

    @Override
    public void calculateLegalMoves(int posX, int posY, Piece[][] board) {
        // reset
        this.legalMoves.clear();
        for (int i = posX - 1; i <= posX + 1; i++) {
            for (int j = posY - 1; j <= posY + 1; j++) {
                // On Board??
                if (j < ChessImpl.BOARDSIZE && i < ChessImpl.BOARDSIZE &&
                        i >= 0 && j >= 0) {
                    // Is not its own position?
                    if (i != posX || j != posY) {
                        // Is Free?
                        if (board[i][j] == null) {
                            //Is not itself?
                            this.legalMoves.add(i + "" + j);
                        } else {
                            // can capture?
                            if (board[i][j].getColor() != this.color) {
                                //Is not itself?
                                this.legalMoves.add(i + "" + j);
                            }
                        }
                    }
                }
            }
        }
    }

    @Override
    public void wasMoved() {

    }
}