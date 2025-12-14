package chess.businesslayer.board;

import chess.businesslayer.Color;
import chess.businesslayer.IPiece;
import chess.businesslayer.piece.King;
import chess.businesslayer.piece.PieceType;
import java.util.HashMap;
import java.util.Map;

public class Board {

    public static final int BOARD_SIZE = 8;
    private Map<Position, Square> tableau = new HashMap<>();

    public Board() {
        for (int x = 0; x < BOARD_SIZE; x++) {
            for (int y = 0; y < BOARD_SIZE; y++) {
                tableau.put(new Position(x,y), new Square(null));
            }
        }

        tableau.get(new Position(2,5)).setPiece(new King(Color.BLACK));
    }

    public void afficheTableau() {
        for (int x = 0; x < BOARD_SIZE; x++) {
            for (int y = 0; y < BOARD_SIZE; y++) {
                IPiece piece = tableau.get(new Position(x, y)).getPiece();
                char p = (piece == null) ? ' ' : switch (piece.getType()) {
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

    public Map<Position, Square> getTableau() {
        return tableau;
    }

    public void setTableau(Map<Position, Square> tableau) {
        this.tableau = tableau;
    }
}
