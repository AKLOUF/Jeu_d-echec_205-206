package chess.businessLayer;

import chess.businessLayer.board.Position;

public class Move {
    private final Position start;
    private final Position end;

    public Move(Position start, Position end){
        this.end = end;
        this.start = start;
    }

    public Position getStart(){
        return start;
    }

    public Position getEnd(){
        return end;
    }

    public String toUCI() {
        return toAlg(start) + toAlg(end);
    }

    private String toAlg(Position p) {
        char col = (char)('a' + p.x);
        char row = (char)('1' + p.y);
        return "" + col + row;
    }
}