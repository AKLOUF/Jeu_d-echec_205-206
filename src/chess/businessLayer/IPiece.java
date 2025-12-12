package chess.businesslayer;

import chess.businesslayer.board.Square;
import chess.businesslayer.piece.PieceType;

public interface IPiece{
    Color getColor();
    void setSquare(Square square);
    PieceType getType();
}