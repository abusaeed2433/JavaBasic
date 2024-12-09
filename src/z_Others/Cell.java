package z_Others;

import java.util.Objects;

public class Cell {
    final int x,y;
    protected CellState.MyColor myColor;

    public Cell(int x, int y, CellState.MyColor myColor) {
        this.x = x;
        this.y = y;
        this.myColor = myColor;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x,y);
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj) return true;

        if(obj == null) return false;

        if( !(obj instanceof Cell cell) ) return false;

        return x == cell.x && y == cell.y;
    }

    @Override
    public String toString() {
        return x+"";
    }
}
