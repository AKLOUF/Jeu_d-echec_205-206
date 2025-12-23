package chess.useCases;

import chess.businessLayer.board.Board;

public interface IBotStrategy {
    String findBestMove(Board board);
}