package chess.businesslayer.piece;

import chess.businesslayer.Color;
import chess.businesslayer.board.Square;
import java.util.List;

public class King extends Piece{
    public King(Color color){
        super(color, PieceType.KING);
    }

    public List<Square> getPossibleMoves(Square from){
        return null;
    }
}