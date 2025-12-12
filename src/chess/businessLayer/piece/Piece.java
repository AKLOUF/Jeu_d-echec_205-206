package chess.businesslayer.piece;

import chess.businesslayer.Color;
import chess.businesslayer.IPiece;
import chess.businesslayer.board.Square;

public class Piece implements IPiece {

    private final Color color;
    private Square carre;
    private final PieceType type;

    public Piece(Color color, PieceType type) {
        this.color = color;
        this.type = type;
    }

    @Override
    public Color getColor() {
        return color;
    }

    public Square getSquare() {
        return carre;
    }

    @Override
    public PieceType getType(){
        return type;
    }

    @Override
    public void setSquare(Square square) {
        this.carre = square;
    }
}
