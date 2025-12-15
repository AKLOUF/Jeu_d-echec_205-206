package chess.businesslayer;

import chess.businesslayer.board.Square;

public class Move {
    Square start, end;

    public Move(Square start, Square end){
        this.end = end;
        this.start = start;
    }

    public Square getStart(){
        return start;
    }

    public Square getEnd(){
        return end;
    }
}
