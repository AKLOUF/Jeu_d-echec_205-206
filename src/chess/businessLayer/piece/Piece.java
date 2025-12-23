package chess.businessLayer.piece;

import chess.businessLayer.Color;
import chess.businessLayer.IPiece;
import chess.businessLayer.board.Board;
import chess.businessLayer.board.Position;
import java.util.List;

public abstract class Piece implements IPiece {

    private final Color color;
    private final PieceType type;

    public Piece(Color color, PieceType type) {
        this.color = color;
        this.type = type;
    }

    @Override
    public Color getColor() {
        return color;
    }

    @Override
    public PieceType getType(){
        return type;
    }

    public abstract List<Position> getPseudoLegalMoves(Position currentPos, Board board);
} 
