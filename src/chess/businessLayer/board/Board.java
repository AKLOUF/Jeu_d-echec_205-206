package chess.businesslayer.board;

import chess.businesslayer.Color;
import chess.businesslayer.piece.King;
import chess.businesslayer.piece.PieceType;

public class Board {

    public static final int BOARD_SIZE = 8;
    private Square[][] tableau;

    public Board() {
        tableau = new Square[BOARD_SIZE][BOARD_SIZE];
        for (int x = 0; x < BOARD_SIZE; x++) {
            for (int y = 0; y < BOARD_SIZE; y++) {
                tableau[x][y] = new Square(null);
            }
        }

        tableau[2][5].setPiece(new King(Color.BLACK));  //Place un roi noir sur la case (2,5) 
    }

    public void afficheTableau() {
        for (int x = 0; x < BOARD_SIZE; x++) {
            for (int y = 0; y < BOARD_SIZE; y++) {
                char p = switch (tableau[x][y].getPiece().getType()) {
                    case null -> ' ';
                    case PieceType.KING -> 'K';
                    case PieceType.BISHOP -> 'b';
                    case PieceType.KNIGHT -> 'k';
                    case PieceType.PAWN -> 'p';
                    case PieceType.QUEEN -> 'Q';
                    case PieceType.ROOK -> 'r';
                };

                System.out.print("[" + p + "]");
                if(y == BOARD_SIZE - 1) System.out.println("");
            }
        }
    }

    public Square[][] getTableau() {
        return tableau;
    }

    public void setTableau(Square[][] tableau) {
        this.tableau = tableau;
    }
}
