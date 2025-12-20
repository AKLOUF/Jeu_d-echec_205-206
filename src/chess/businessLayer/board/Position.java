package chess.businessLayer.board;

public record Position(int x, int y) {

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Position)) return false;
        Position p = (Position) o;
        return x == p.x() && y == p.y();
    }
}
