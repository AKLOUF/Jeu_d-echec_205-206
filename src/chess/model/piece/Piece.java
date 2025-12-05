package chess.model.piece;

import chess.model.board.Square;
import chess.model.move.Color;

public abstract class Piece implements IPiece {

    private final Color color;

    public Piece(Color color) {
        this.color = color;
    }

    public Color getColor() {
        return color;
    }

    public void setSquare(Square square) {
        this.square = square;
    }
}
