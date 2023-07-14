package temporary;

import java.util.*;

public class Temp2 extends Temporary{

    public static void main(String[] args) {
        Set<Integer> set = new LinkedHashSet<>();
        set.add(2);
        set.add(1);
        set.add(5);

        Iterator<Integer> iterator = set.iterator();

        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }


        System.out.println(Arrays.toString(set.toArray()));



    }
    @Override
    public void print() {

    }
}
