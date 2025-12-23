package chess.useCases;

import chess.businessLayer.board.Board;
import chess.businessLayer.Move;
import chess.businessLayer.Color;

public class BotStrategy implements IBotStrategy {

    @Override
    public String findBestMove(Board board) {
        MoveGenerator generator = new MoveGenerator();

        var moves = generator.generateLegalMoves(board, Color.WHITE);

        if (moves.isEmpty()) {
            return null;
        }

        // Stratégie basique : on prend le premier coup de la liste
        Move bestMove = moves.get(0);

        // On convertit le coup en String UCI (ex: "e2e4")
        return bestMove.toUCI();
    }
}