package l_DateTime.partFive;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class Test {

    public static void main(String[] args) {

        testFormatter();

    }


    private static void testFormatter(){
        System.out.println("------------------- testFormatter ---------------------------");

        {
            System.out.println("----------- Using pre-defined standard datetime formatters -----------");
            LocalDate date = LocalDate.of(2023, Month.AUGUST,17);

            String strDate;

            strDate = DateTimeFormatter.ISO_DATE.format(date);
            System.out.println( strDate ); // 2023-08-17

            strDate = DateTimeFormatter.ISO_WEEK_DATE.format(date);
            System.out.println( strDate ); // 2023-W33-4 <----- 33 weeks 4 days

            //strDate = DateTimeFormatter.ISO_TIME.format(date); // Runtime error. since date doesn't have time component

            LocalTime time = LocalTime.of(11,12,13);
            String strTime = DateTimeFormatter.ISO_TIME.format(time);

            System.out.println( strTime ); // 11:12:13

        }

        {
            System.out.println("----------- Using the format() method of the datetime classes -----------");

            LocalDate date = LocalDate.of(2023, Month.AUGUST,17);
            String strDate;

            strDate = date.format(DateTimeFormatter.ISO_DATE);
            System.out.println(strDate); // 2023-08-17

            strDate = date.format(DateTimeFormatter.ISO_WEEK_DATE);
            System.out.println(strDate); // 2023-W33-4

            LocalTime time = LocalTime.of(11,12,13);
            String strTime = time.format(DateTimeFormatter.ISO_TIME);
            System.out.println(strTime); // 11:12:13

        }

    }


}
