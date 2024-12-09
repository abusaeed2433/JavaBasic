package z_Others;

import java.util.ArrayList;
import java.util.List;

public class PathScore {

    final Point startCell;
    final Point endCell;
    final CellState.MyColor color;
    private final List<Point> pointsAtStart = new ArrayList<>();
    private final List<Point> pointsAtEnd = new ArrayList<>();
    int length;
    int score;

    public PathScore(Point startCell, Point endCell, CellState.MyColor color) {
        this.startCell = startCell;
        this.endCell = endCell;
        this.color = color;
        this.score = 0;

        updateLength();
    }

    public PathScore(CellState.MyColor color) {
        this.startCell = new Point(Integer.MAX_VALUE, Integer.MAX_VALUE);
        this.endCell = new Point(Integer.MIN_VALUE, Integer.MIN_VALUE);
        this.color = color;
        length = -1;
    }

    public List<Point> getPointsAtStart() {
        return pointsAtStart;
    }

    public List<Point> getPointsAtEnd() {
        return pointsAtEnd;
    }

    public void update(PathScore pathScore){
        if(pathScore.color != this.color) return;
        if(pathScore.length <= this.length) return;

        pointsAtStart.clear();
        pointsAtEnd.clear();

        this.pointsAtStart.addAll(pathScore.pointsAtStart);
        this.pointsAtEnd.addAll(pathScore.pointsAtEnd);

        this.startCell.x = pathScore.startCell.x;
        this.startCell.y = pathScore.startCell.y;

        this.endCell.x = pathScore.endCell.x;
        this.endCell.y = pathScore.endCell.y;
        updateLength();
    }

    public void reCalc(int x, int y){
        if(color == CellState.MyColor.RED){ // left to right

            if(y < startCell.y){
                startCell.update(x,y);
                pointsAtStart.clear();
                pointsAtStart.add(new Point(x,y));
            }
            else if(y == startCell.y) pointsAtStart.add(new Point(x,y));

            if(y > endCell.y){
                endCell.update(x,y);
                pointsAtEnd.clear();
                pointsAtEnd.add(new Point(x,y));
            }
            else if(y == endCell.y) pointsAtEnd.add(new Point(x,y));
        }

        if(color == CellState.MyColor.BLUE){ // top to bottom
            if(x < startCell.x){
                startCell.update(x,y);
                pointsAtStart.clear();
                pointsAtStart.add(new Point(x,y));
            }
            else if(x == startCell.x) pointsAtStart.add(new Point(x,y));

            if(x > endCell.x){
                endCell.update(x,y);
                pointsAtEnd.clear();
                pointsAtEnd.add(new Point(x,y));
            }
            else if(x == endCell.x) pointsAtEnd.add(new Point(x,y));
        }
        updateLength();
    }

    private void updateLength(){
        length = Math.abs(
                (color == CellState.MyColor.RED) ? (endCell.y - startCell.y + 1)
                        : (endCell.x - startCell.x + 1)
        );
    }



    public static class Point{
        int x, y;
        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
        public void update(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
}
