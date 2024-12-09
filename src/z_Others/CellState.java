package z_Others;

public class CellState{

    public enum MyColor {
        RED(1), BLUE(2), BLANK(0);

        final int id;
        MyColor(int id) {
            this.id = id;
        }

    }
}
