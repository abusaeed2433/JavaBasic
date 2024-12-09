package z_Others;

import kotlin.Pair;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import static z_Others.CellState.MyColor.*;

public class FitnessCalculator {

    private static final int N = 5;
    private static final int[][] offsets = { {0, -1}, {1, -1}, {-1, 0}, {1, 0}, {-1, 1},{0, 1} };

    private CellState.MyColor[][] generateBoard(){
        final CellState.MyColor[][] board = new CellState.MyColor[N][N];
        board[0] = new CellState.MyColor[]{ BLUE, RED, RED, RED, RED};
        board[1] = new CellState.MyColor[]{ BLUE, RED, BLANK, BLANK, BLANK};
        board[2] = new CellState.MyColor[]{ BLANK, BLUE, BLUE, BLANK, BLANK};
        board[3] = new CellState.MyColor[]{ BLANK, BLANK, BLUE, BLANK, BLANK};
        board[4] = new CellState.MyColor[]{ RED, BLUE, BLANK, BLANK, BLANK};

        return board;
    }

    private void print(CellState.MyColor[][] board){
        for(int i=0; i<70; i++) System.out.print("-"); System.out.println();

        for(CellState.MyColor[] row : board){
            for(CellState.MyColor cell : row){
                System.out.printf("%1$10s", cell);
            }
            System.out.println();
        }

        for(int i=0; i<70; i++) System.out.print("-"); System.out.println();
    }

    private static PathScore spreadThisPath(CellState.MyColor[][] board, int x, int y, boolean[][] visited, int N){
        final PathScore pathScore = new PathScore(board[x][y]);
        pathScore.reCalc(x,y);

        final Queue<Pair<Integer,Integer>> queue = new LinkedList<>();
        queue.add(new Pair<>(x,y));
        visited[x][y] = true;

        while (!queue.isEmpty()){
            final Pair<Integer,Integer> pair = queue.poll();

            assert pair != null;
            final int oldX = pair.getFirst();
            final int oldY = pair.getSecond();

            for(int[] off : offsets){
                final int newX = oldX + off[0];
                final int newY = oldY + off[1];

                if(newX < 0 || newX >= N || newY < 0 || newY >= N) continue;
                if(visited[newX][newY]) continue;
                if(board[newX][newY] != board[x][y]) continue;

                visited[newX][newY] = true;

                pathScore.reCalc(newX, newY); // update automatically based on color
                queue.add(new Pair<>(newX,newY));
            }
        }

        return pathScore;
    }

    private static MyPair<PathScore,PathScore> getExpectedLongestPathBlueRed(CellState.MyColor[][] board, int N){
        final boolean[][] visited = new boolean[N][N];

        final PathScore bluePathScore = new PathScore(BLUE);
        final PathScore redPathScore = new PathScore(RED);

        for(int x=0; x<N; x++){
            for(int y=0; y<N; y++){
                if(board[x][y] == BLANK || visited[x][y]) continue;

                final PathScore pathScore = spreadThisPath(board, x,y,visited,N);
                bluePathScore.update(pathScore);
                redPathScore.update(pathScore);
            }
        }

        return new MyPair<>(bluePathScore, redPathScore); // BLUE, RED
    }

    private static Pair<Integer,Integer> calcMobilityBlueRed(CellState.MyColor[][] board, int N){

        int blueMobility = 0;
        int redMobility = 0;

        for(int x=0; x<N; x++){
            for(int y=0; y<N; y++){
                if(board[x][y] != BLANK) continue;

                final int[][] offsets = { {0, -1}, {1, -1}, {-1, 0}, {1, 0}, {-1, 1},{0, 1} };

                int blue = 0, red = 0;
                for(int[] off : offsets){
                    final int newX = x + off[0];
                    final int newY = y + off[1];

                    if(newX < 0 || newX >= N || newY < 0 || newY >= N) continue;

                    if(board[newX][newY] == RED) red = 1;
                    else if(board[newX][newY] == BLUE) blue = 1;

                    if(red + blue == 2) break;
                }

                blueMobility += blue;
                redMobility += red;
            }
        }

        // the less, the better
        final int max = Math.max(blueMobility, redMobility);
        return new Pair<>(blueMobility, redMobility); // the more, the better since subtracted
    }

    private static MyPair<Integer,Integer> calcFreeBlueRed(CellState.MyColor[][] board, int N,
                                                           PathScore bluePathScore, PathScore redPathScore) {
        final int redLeftFreeCell = countFreeCellAtThese( board, N,
                new int[][]{ {-1, 0}, {1, -1}, {0, -1} },
                new int[]{2,2,1},
                redPathScore.getPointsAtStart(), redPathScore.length,
                Direction.LEFT
        );

        final int redRightFreeCell = countFreeCellAtThese(board, N,
                new int[][]{ {0,1}, {-1,1}, {1,0} },
                new int[]{2,2,1},
                redPathScore.getPointsAtEnd(), redPathScore.length,
                Direction.RIGHT
        );

        final int blueTopFreeCell = countFreeCellAtThese(board, N,
                new int[][]{ {-1,0}, {-1,1} },
                new int[]{2,2},
                bluePathScore.getPointsAtStart(), bluePathScore.length,
                Direction.TOP
        );

        final int blueBottomFreeCell = countFreeCellAtThese(board, N,
                new int[][]{ {1,0}, {1,1} },
                new int[]{2,2},
                bluePathScore.getPointsAtEnd(), bluePathScore.length,
                Direction.BOTTOM
        );

        final int blueFreeCell = blueTopFreeCell + blueBottomFreeCell;
        final int redFreeCell = redLeftFreeCell + redRightFreeCell;
        return new MyPair<>(blueFreeCell, redFreeCell);
    }

    private static int countFreeCellAtThese(CellState.MyColor[][] board, final int N,
                                            final int[][] offsets, final int[] weights,
                                            final List<PathScore.Point> points, int len, Direction direction){

        final boolean[][] visited = new boolean[N][N];
        int count = 0;
        for (PathScore.Point pt : points) {

            if( (direction == Direction.LEFT && pt.y == 0) || (direction == Direction.RIGHT && pt.y == N-1) ||
                    (direction == Direction.TOP && pt.x == 0) || (direction == Direction.BOTTOM && pt.x == N-1) ) {
                return 4*len;//points.size() * 2; // no need to check
            }

            for(int i=0; i<offsets.length; i++){
                final int[] off = offsets[i];

                final int newX = pt.x + off[0];
                final int newY = pt.y + off[1];

                if(newX < 0 || newX >= N || newY < 0 || newY >= N) continue;

                if(visited[newX][newY]) continue;

                visited[newX][newY] = true;

                if(board[newX][newY] == CellState.MyColor.BLANK) count += weights[i];
            }
        }
        return count;
    }

    private static final int PATH_LENGTH_WEIGHT = 10;
    private static final int MOBILITY_WEIGHT = 5;
    private static final int FREE_WEIGHT = 8;

    public static int getBoardScore(CellState.MyColor[][] board, int N){

        int blueScore = 0;
        int redScore = 0;

        final MyPair<PathScore,PathScore> pathScores = getExpectedLongestPathBlueRed(board, N);

        {
            final int valOne = pathScores.blue.length * PATH_LENGTH_WEIGHT;
            final int valTwo = pathScores.red.length * PATH_LENGTH_WEIGHT;
            System.out.println("LongestPath: " + valOne + " | " + valTwo);

            blueScore += valOne;
            redScore += valTwo;
        }

        {
            final Pair<Integer,Integer> mobilities = calcMobilityBlueRed(board, N);

            final int valOne = mobilities.getFirst() * MOBILITY_WEIGHT;
            final int valTwo = mobilities.getSecond() * MOBILITY_WEIGHT;
            System.out.println("Mobility: " + valOne + " | " + valTwo);

            blueScore += valOne;
            redScore += valTwo;
        }

        {
            final MyPair<Integer,Integer> freeCount = calcFreeBlueRed(board, N, pathScores.blue, pathScores.red);
            final int valOne = freeCount.blue * FREE_WEIGHT;
            final int valTwo = freeCount.red * FREE_WEIGHT;

            System.out.println("FreeCount: " + valOne + " | " + valTwo);

            blueScore += valOne;
            redScore += valTwo;
        }

        return blueScore - redScore;
    }

    private void start(){
        final CellState.MyColor[][] board = generateBoard();
        print(board);

        int score = getBoardScore(board,N);
        System.out.println(score);
    }

    public static void main(String[] args) {
        new FitnessCalculator().start();
    }


    private enum Direction{ LEFT, RIGHT, TOP, BOTTOM }

}
