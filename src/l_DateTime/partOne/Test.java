package l_DateTime.partOne;

import java.time.LocalDate;
import java.time.Month;

public class Test {

    public static void main(String[] args) {
        basicExample();
    }


    private static void basicExample(){
        System.out.println("--------------- basicExample --------------");

        LocalDate ld = LocalDate.of(2023, Month.MARCH,23);
        System.out.println(ld); // 2023-03-23

        LocalDate newDate = ld.plusDays(9);
        System.out.println(newDate); // 2023-04-01

        System.out.println( newDate.getDayOfWeek() ); // SATURDAY
        System.out.println( newDate.getMonthValue() ); // 4

    }

}
