package chess.businessLayer.piece;

import chess.businessLayer.Color;
import chess.businessLayer.board.Board;
import chess.businessLayer.board.Position;
import java.util.ArrayList;
import java.util.List;

public class King extends Piece {
    public King(Color color){
        super(color, PieceType.KING);
    }

    @Override
    public List<Position> getPseudoLegalMoves(Position currentPos, Board board) {
        List<Position> moves = new ArrayList<>();
        int[] offsets = {-1, 0, 1};

        for (int dx : offsets) {
            for (int dy : offsets) {
                if (dx == 0 && dy == 0) continue;
                int nx = currentPos.x() + dx;
                int ny = currentPos.y() + dy;

                if (nx >= 0 && nx < Board.BOARD_SIZE && ny >= 0 && ny < Board.BOARD_SIZE) {
                    Position target = new Position(nx, ny);
                    if (board.isSquareEmpty(target) || board.getPieceAt(target).getColor() != this.getColor()) {
                        moves.add(target);
                    }
                }
            }
        }
        return moves;
    }
}