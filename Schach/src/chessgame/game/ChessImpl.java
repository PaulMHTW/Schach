package chessgame.game;

import chessgame.pieces.*;

public class ChessImpl implements Chess {

    public final static int BOARDSIZE = 8;
    private PieceImpl[][] theBoard = new PieceImpl[BOARDSIZE][BOARDSIZE];

    PieceColors activePlayer;

    @Override
    public void selectNameAndColor(String name, String color)
            throws InvalidColorException {

    }

    @Override
    public void movePiece(String newMove)
            throws IllegalMoveException, InvalidPieceException, InvalidCoordinatesException {

        // convert Coordinate String into index values
        int oldPosX = convertBoardCoordinates(newMove.charAt(0));
        int newPosX = convertBoardCoordinates(newMove.charAt(2));
        int oldPosY = newMove.charAt(1) - 1;
        int newPosY = newMove.charAt(3) - 1;
        // check if coordinates are actually part of the board
        if (oldPosY < 0 || oldPosY >= BOARDSIZE || newPosY < 0 || newPosY >= BOARDSIZE) {
            throw new InvalidCoordinatesException("The entered Coordinates \"" + newMove + "\" do not exist");
        }

        //check if there is a piece and if it is owned by the player
        PieceImpl movingPiece = theBoard[oldPosX][oldPosY];
        if (movingPiece != null && movingPiece.getColor() == activePlayer) {
            //check if new position is a legal move
            String move = "" + newPosX + newPosY;
            if (movingPiece.getLegalMoves().contains(move)) {
                //move the piece to its new position
                theBoard[newPosX][newPosY] = movingPiece;
                theBoard[oldPosX][oldPosY] = null;
                movingPiece.wasMoved();
                // reevaluate legal moves for all pieces
                calculateAllPossibleMoves();
            } else {
                throw new IllegalMoveException("Move is not allowed!");
            }
        } else {
            throw new InvalidPieceException("There is no piece of your color here");
        }

    }

    /**
     * This will iterate over the whole board and forces each piece, which is still alive, to recalculate its
     * legal moves
     */
    private void calculateAllPossibleMoves() {
        for (int i = 0; i < BOARDSIZE; i++) {
            for (int j = 0; j < BOARDSIZE; j++) {
                if (theBoard[i][j] != null) {
                    theBoard[i][j].calculateLegalMoves(i, j, theBoard);
                }
            }
        }
    }

    /**
     * This will convert the chessboard coordinates the user enters into index values which are readable for
     * the program. Capitalisation does not matter.
     * @param a letter coordinate to be converted
     * @return the index value associated with the letter
     * @throws InvalidCoordinatesException if any character but a,b,c,d,e,f,g or h is passed
     */
    private int convertBoardCoordinates(char a) throws InvalidCoordinatesException {
        a = Character.toLowerCase(a);
        return switch (a) {
            case 'a' -> 0;
            case 'b' -> 1;
            case 'c' -> 2;
            case 'd' -> 3;
            case 'e' -> 4;
            case 'f' -> 5;
            case 'g' -> 6;
            case 'h' -> 7;
            default -> throw new InvalidCoordinatesException(a + " is not on the board");
        };
    }

    /**
     * This will place all pieces on the board creating the starting formation. White will be on the top and
     * black on the bottom
     */
    public void populateBoard() {
        //White (on top)
        theBoard[0][0] = new Rook(PieceColors.WHITE);
        theBoard[0][1] = new Knight(PieceColors.WHITE);
        theBoard[0][2] = new Bishop(PieceColors.WHITE);
        theBoard[0][3] = new King(PieceColors.WHITE);
        theBoard[0][4] = new Queen(PieceColors.WHITE);
        theBoard[0][5] = new Bishop(PieceColors.WHITE);
        theBoard[0][6] = new Knight(PieceColors.WHITE);
        theBoard[0][7] = new Rook(PieceColors.WHITE);
        for (int i = 0; i < BOARDSIZE; i++) {
            theBoard[1][i] = new Pawn(PieceColors.WHITE);
        }

        //Black (on bottom)
        theBoard[7][0] = new Rook(PieceColors.BLACK);
        theBoard[7][1] = new Knight(PieceColors.BLACK);
        theBoard[7][2] = new Bishop(PieceColors.BLACK);
        theBoard[7][3] = new Queen(PieceColors.BLACK);
        theBoard[7][4] = new King(PieceColors.BLACK);
        theBoard[7][5] = new Bishop(PieceColors.BLACK);
        theBoard[7][6] = new Knight(PieceColors.BLACK);
        theBoard[7][7] = new Rook(PieceColors.BLACK);
        for (int i = 0; i < BOARDSIZE; i++) {
            theBoard[6][i] = new Pawn(PieceColors.BLACK);
        }
    }
}