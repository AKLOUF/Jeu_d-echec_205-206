package chess.model.piece;

import chess.model.board.Square;
import chess.model.move.Color;

public abstract class Piece implements IPiece {

    private final Color color;
    private Square square;

    public Piece(Color color, Square square) {
        this.color = color;
        this.square = square;
    }

    public Color getColor() {
        return color;
    }

    public Square getSquare() {
        return square;
    }

    public void setSquare(Square square) {
        this.square = square;
    }
}
