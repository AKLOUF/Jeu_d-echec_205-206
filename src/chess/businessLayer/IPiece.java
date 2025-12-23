package chess.businessLayer;
import chess.businessLayer.piece.PieceType;

public interface IPiece {
    Color getColor();
    PieceType getType();
}