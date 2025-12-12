package chess.businesslayer.board;

import chess.businesslayer.IPiece;

public class Square {

    IPiece piece;

    public Square(IPiece p) {
        piece = p;
    }

    public void setPiece(IPiece p) {
        piece = p;
    }

    public IPiece getPiece() {
        return piece;
    }
}
