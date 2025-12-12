package chess.businesslayer.piece;

import chess.businesslayer.Color;
import chess.businesslayer.board.Square;
import java.util.ArrayList;
import java.util.List;

public class King extends Piece{
    public King(Color color){
        super(color, PieceType.KING);
    }

    public List<Square> possibleMoves(Square from){
        List l = new ArrayList<Square>();
        return l;
    }
}