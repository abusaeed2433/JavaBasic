package z_Others;

import java.beans.beancontext.BeanContextServicesListener;
import java.util.*;

public class aiProject {

    public static void main(String[] args) {
        List<Cell> parent1 = List.of(
                new Cell(0,0, CellState.MyColor.RED),
                new Cell(1,0, CellState.MyColor.RED),
                new Cell(2,0, CellState.MyColor.RED),
                new Cell(3,0, CellState.MyColor.BLUE),
                new Cell(4,0, CellState.MyColor.BLUE),
                new Cell(5,0, CellState.MyColor.BLUE)
        );

        List<Cell> parent2 = List.of(
                new Cell(5,0, CellState.MyColor.RED),
                new Cell(4,0, CellState.MyColor.RED),
                new Cell(3,0, CellState.MyColor.RED),
                new Cell(2,0, CellState.MyColor.BLUE),
                new Cell(1,0, CellState.MyColor.BLUE),
                new Cell(0,0, CellState.MyColor.BLUE)
        );


        List<List<Cell>> child = applyCrossover(parent1,parent2);

        System.out.println(child.get(0));
        System.out.println(child.get(1));

    }

    private static List<List<Cell>> applyCrossover(List<Cell> parentOne, List<Cell> parentTwo){
        final int half = parentOne.size() / 2;

        final Cell[] childOne = new Cell[parentOne.size()];
        final Cell[] childTwo = new Cell[parentOne.size()];

        final Random random = new Random();

        int indexOne = random.nextInt(half);
        int indexTwo = half + random.nextInt(half);

        final Map<Cell,Cell> mapOne = new HashMap<>();
        final Map<Cell,Cell> mapTwo = new HashMap<>();

        for(int i = indexOne; i<indexTwo; i++){
            childOne[i] = parentTwo.get(i);
            childTwo[i] = parentOne.get(i);

            mapTwo.put(parentOne.get(i), parentTwo.get(i));
            mapOne.put(parentTwo.get(i), parentOne.get(i));
        }

        for(int i=0; i<childOne.length; i++){
            if(i < indexOne || i >= indexTwo) {

                Cell cellOne = parentOne.get(i);
                while (mapOne.containsKey(cellOne)) {
                    cellOne = mapOne.get(cellOne);
                    System.out.println(cellOne);
                }
                childOne[i] = cellOne;

                Cell cellTwo = parentTwo.get(i);
                while (mapTwo.containsKey(cellTwo)) {
                    cellTwo = mapTwo.get(cellTwo);
                }
                childTwo[i] = cellTwo;
            }

            // making the first half of same color
            CellState.MyColor color = (i < half) ? CellState.MyColor.RED : CellState.MyColor.BLUE;
            childOne[i].myColor = color;
            childTwo[i].myColor = color;
        }

        final List<List<Cell>> offspring = new ArrayList<>();
        offspring.add(Arrays.stream(childOne).toList());
        offspring.add(Arrays.stream(childTwo).toList());

        return offspring;
    }

}
