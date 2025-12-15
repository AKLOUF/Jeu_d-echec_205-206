package chess.businessLayer.piece;

import chess.businesslayer.Color;
import chess.businesslayer.IPiece;
import chess.businessLayer.board.Board;
import chess.businessLayer.board.Position;
import chess.businesslayer.board.Square;
import chess.businesslayer.piece.PieceType;
import java.util.List;

public abstract class Piece implements IPiece {

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

    // C'est ici que la magie opère : chaque pièce devra définir comment elle bouge
    public abstract List<Position> getPseudoLegalMoves(Position currentPos, Board board);
}