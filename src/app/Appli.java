package app;

import chess.model.board.Square;
import chess.model.move.Color;
import chess.model.piece.*;

public class Appli{
    public static void main(String[] args){
        King k = new King(Color.WHITE, new Square());
        System.out.println(k.getColor());
    }
}