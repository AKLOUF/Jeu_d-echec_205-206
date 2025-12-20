package chess.businessLayer.piece;

import chess.businessLayer.Color;
import chess.businessLayer.board.Board;
import chess.businessLayer.board.Position;
import java.util.ArrayList;
import java.util.List;

public class Rook extends Piece {
    public Rook(Color color) {
        super(color, PieceType.ROOK);
    }

    @Override
    public List<Position> getPseudoLegalMoves(Position currentPos, Board board) {
        List<Position> moves = new ArrayList<>();
        int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

        for (int[] dir : directions) {
            int x = currentPos.x();
            int y = currentPos.y();
            while (true) {
                x += dir[0];
                y += dir[1];
                if (x < 0 || x >= Board.BOARD_SIZE || y < 0 || y >= Board.BOARD_SIZE) break;

                Position targetPos = new Position(x, y);
                if (board.isSquareEmpty(targetPos)) {
                    moves.add(targetPos);
                } else {
                    if (board.getPieceAt(targetPos).getColor() != this.getColor()) {
                        moves.add(targetPos);
                    }
                    break;
                }
            }
        }
        return moves;
    }
}