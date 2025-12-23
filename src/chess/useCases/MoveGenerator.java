package chess.useCases;

import chess.businessLayer.Color;
import chess.businessLayer.IPiece;
import chess.businessLayer.Move;
import chess.businessLayer.board.Board;
import chess.businessLayer.board.Position;
import chess.businessLayer.piece.Piece;

import java.util.ArrayList;
import java.util.List;

public class MoveGenerator {
    public List<Move> generateLegalMoves(Board board, Color turnColor) {
        List<Move> legalMoves = new ArrayList<>();

        List<Move> pseudoMoves = generatePseudoLegalMoves(board, turnColor);

        for (Move move : pseudoMoves) {
            if (isMoveLegal(board, move, turnColor)) {
                legalMoves.add(move);
            }
        }

        return legalMoves;
    }

    private boolean isMoveLegal(Board originalBoard, Move move, Color turnColor) {
        Board simulationBoard = new Board(originalBoard);

        simulationBoard.performMove(move);

        return !isKingInCheck(simulationBoard, turnColor);
    }

    private boolean isKingInCheck(Board board, Color kingColor) {
        Position kingPos = board.findKing(kingColor);

        if (kingPos == null) return false;

        Color enemyColor = (kingColor == Color.WHITE) ? Color.BLACK : Color.WHITE;

        List<Move> enemyMoves = generatePseudoLegalMoves(board, enemyColor);

        for (Move m : enemyMoves) {
            if (m.end().equals(kingPos)) {
                return true;
            }
        }
        return false;
    }


    private List<Move> generatePseudoLegalMoves(Board board, Color color) {
        List<Move> moves = new ArrayList<>();

        for (int x = 0; x < Board.BOARD_SIZE; x++) {
            for (int y = 0; y < Board.BOARD_SIZE; y++) {
                Position pos = new Position(x, y);
                IPiece piece = board.getPieceAt(pos);

                if (piece != null && piece.getColor() == color) {
                    if (piece instanceof Piece) {
                        List<Position> targets = ((Piece) piece).getPseudoLegalMoves(pos, board);
                        for (Position target : targets) {
                            moves.add(new Move(pos, target));
                        }
                    }
                }
            }
        }
        return moves;
    }
}