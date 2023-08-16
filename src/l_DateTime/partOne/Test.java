package l_DateTime.partOne;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.temporal.ChronoField;
import java.time.temporal.TemporalAccessor;

public class Test {

    public static void main(String[] args) {
        basicExample();
        basicMethod1();
        basicMethod2();
    }

    private static void basicMethod2(){
        System.out.println("-------------- basicMethod2 ---------------");

        System.out.println("------------- getXXX() --------------------");
        LocalDate date = LocalDate.of(2023,Month.AUGUST,16);

        System.out.println( date.getYear() ); // 2023

        System.out.println( date.getMonth() ); // AUGUST
        System.out.println( date.getMonthValue() ); // 8

        System.out.println( date.getDayOfMonth() ); // 16
        System.out.println( date.getDayOfWeek() ); // WEDNESDAY

        System.out.println( date.get(ChronoField.DAY_OF_YEAR) ); // 228


        System.out.println("------------- toXXX() --------------------");
        LocalDateTime dateTime = LocalDateTime.of(2023,Month.AUGUST,16,23,10);
        System.out.println(dateTime); // 2023-08-16T23:10

        LocalDate date1 = dateTime.toLocalDate();
        System.out.println(date1); // 2023-08-16

        LocalTime time1 = dateTime.toLocalTime();
        System.out.println(time1); // 23:10

        System.out.println( date.toEpochDay() ); // 19585

    }

    private static void basicMethod1(){
        System.out.println("-------------- basicMethod1 ---------------");

        System.out.println("--------- ofXXX() -------------------------");
        LocalDate date1 = LocalDate.now();
        LocalDate date2 = LocalDate.of(2023,4,23);
        LocalDate date3 = LocalDate.ofEpochDay(1000);
        LocalDate date4 = LocalDate.ofYearDay(2023,140);

        System.out.println("--------- from() -------------------------");
        LocalDate date6 = LocalDate.now();
        LocalDate date7 = LocalDate.from(date6);

        LocalDateTime ldt = LocalDateTime.now();
        LocalDate date8 = LocalDate.from(ldt);

        System.out.println("-------------- withXXX() -------------------");
        LocalDate date9 = LocalDate.of(2023,Month.AUGUST,16);
        LocalDate date10 = date9.withYear(2024);
        System.out.println(date9); // 2023-08-16
        System.out.println(date10);// 2024-08-16

        LocalDate date11 = date9.withMonth(3);
        System.out.println(date11); // 2023-03-16


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
