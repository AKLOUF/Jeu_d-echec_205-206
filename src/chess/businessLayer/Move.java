package chess.businessLayer;

import chess.businessLayer.board.Position;

public record Move(Position start, Position end) {

    public String toUCI() {
        return toAlg(start) + toAlg(end);
    }

    private String toAlg(Position p) {
        char col = (char) ('a' + p.x());
        char row = (char) ('1' + p.y());
        return "" + col + row;
    }
}