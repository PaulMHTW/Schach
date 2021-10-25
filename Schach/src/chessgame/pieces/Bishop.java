package chessgame.pieces;

import chessgame.game.ChessImpl;

public class Bishop extends PieceImpl{
    public Bishop(PieceColors color) {
        super(color);
    }

    @Override
    public void calculateLegalMoves(int posX, int posY, Piece[][] board) {
        //reset
        this.legalMoves.clear();
        // *****************in x plus, y plus direction**********************
        int j = posY + 1;
        for (int i = posX + 1; i < ChessImpl.BOARDSIZE; i++) {
            // still on board?
            if(j < ChessImpl.BOARDSIZE){
                // is blocked?
                if(board[i][j] != null){
                    // can capture?
                    if(board[i][j].getColor() != this.color){
                        this.legalMoves.add(i + "" + j);
                    }
                    // stop looking this direction (kill for loop)
                    i = ChessImpl.BOARDSIZE;
                }else{
                    this.legalMoves.add(i + "" + j);
                }
            }
            j++;
        }
        // *****************in x plus, y minus direction**********************
        j = posY -1;
        for (int i = posX + 1; i < ChessImpl.BOARDSIZE; i++) {
            // still on board?
            if(j >= 0){
                // is blocked?
                if(board[i][j] != null){
                    // can capture?
                    if(board[i][j].getColor() != this.color){
                        this.legalMoves.add(i + "" + j);
                    }
                    // stop looking this direction (kill for loop)
                    i = ChessImpl.BOARDSIZE;
                }else{
                    this.legalMoves.add(i + "" + j);
                }
            }
            j--;
        }
        // *****************in x minus, y plus direction**********************
        j = posY + 1;
        for (int i = posX - 1; i >= 0; i--) {
            // still on board?
            if(j < ChessImpl.BOARDSIZE){
                // is blocked?
                if(board[i][j] != null){
                    // can capture?
                    if(board[i][j].getColor() != this.color){
                        this.legalMoves.add(i + "" + j);
                    }
                    // stop looking this direction (kill for loop)
                    i = -1;
                }else{
                    this.legalMoves.add(i + "" + j);
                }
            }
            j++;
        }
        // *****************in x minus, y minus direction**********************
        j = posY - 1;
        for (int i = posX - 1; i >= 0; i--) {
            // still on board?
            if(j >= 0){
                // is blocked?
                if(board[i][j] != null){
                    // can capture?
                    if(board[i][j].getColor() != this.color){
                        this.legalMoves.add(i + "" + j);
                    }
                    // stop looking this direction (kill for loop)
                    i = -1;
                }else{
                    this.legalMoves.add(i + "" + j);
                }
            }
            j--;
        }
    }

    @Override
    public void wasMoved() {

    }
}