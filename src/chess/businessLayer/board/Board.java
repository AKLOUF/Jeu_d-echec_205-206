package chess.businessLayer.board;

import chess.businessLayer.Color;
import chess.businessLayer.IPiece;
import chess.businessLayer.Move;
import chess.businessLayer.piece.PieceType;
import java.util.HashMap;
import java.util.Map;

public class Board {

    public static final int BOARD_SIZE = 8;
    private final Map<Position, Square> tableau = new HashMap<>();

    public Board() {
        clear();
    }

    public Board(Board original) {
        for (Map.Entry<Position, Square> entry : original.tableau.entrySet()) {
            Position pos = entry.getKey();
            Square originalSquare = entry.getValue();
            // On crée un nouveau Square avec la même pièce
            this.tableau.put(pos, new Square(originalSquare.getPiece()));
        }
    }

    public void clear() {
        tableau.clear();
        for (int x = 0; x < BOARD_SIZE; x++) {
            for (int y = 0; y < BOARD_SIZE; y++) {
                tableau.put(new Position(x,y), new Square(null));
            }
        }
    }

    public IPiece getPieceAt(Position p) {
        Square s = tableau.get(p);
        return (s != null) ? s.getPiece() : null;
    }

    public boolean isSquareEmpty(Position p) {
        return getPieceAt(p) == null;
    }

    public Position findKing(Color color) {
        for (Map.Entry<Position, Square> entry : tableau.entrySet()) {
            IPiece p = entry.getValue().getPiece();
            if (p != null && p.getType() == PieceType.KING && p.getColor() == color) {
                return entry.getKey();
            }
        }
        return null;
    }

    public void performMove(Move move) {
        Square startSq = tableau.get(move.start());
        Square endSq = tableau.get(move.end());

        IPiece pieceToMove = startSq.getPiece();

        endSq.setPiece(pieceToMove);
        startSq.setPiece(null);
    }

    public void putPiece(Position p, IPiece piece) {
        Square s = tableau.get(p);
        if(s != null) {
            s.setPiece(piece);
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int y = BOARD_SIZE - 1; y >= 0; y--) {
            sb.append(y + 1).append("  ");
            for (int x = 0; x < BOARD_SIZE; x++) {
                IPiece piece = tableau.get(new Position(x, y)).getPiece();
                char p = (piece == null) ? '.' : switch (piece.getType()) {
                    case PieceType.KING -> (piece.getColor() == Color.WHITE ? 'K' : 'k');
                    case PieceType.BISHOP -> 'b';
                    case PieceType.KNIGHT -> 'n';
                    case PieceType.PAWN -> 'p';
                    case PieceType.QUEEN -> 'q';
                    case PieceType.ROOK -> (piece.getColor() == Color.WHITE ? 'R' : 'r');
                };
                sb.append(" ").append(p).append(" ");
            }
            sb.append("\n");
        }
        sb.append("   a  b  c  d  e  f  g  h");
        return sb.toString();
    }
}