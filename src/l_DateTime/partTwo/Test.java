package l_DateTime.partTwo;

import java.time.Duration;
import java.time.Instant;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;

public class Test {

    public static void main(String[] args) {
        testInstantDuration();
    }

    private static void testInstantDuration() {
        System.out.println("--------------- testInstantDuration ---------------------");

        {
            System.out.println("---------- Instant -----------------------");
            Instant instant = Instant.now();
            Instant instant1 = Instant.ofEpochSecond(86420); //second

            //----------------------epoch is 1970-01-01T00:00:00Z
            System.out.println(instant1); // 1970-01-02T00:00:20Z

            System.out.println(instant1.getEpochSecond()); // 86420
            System.out.println(instant1.get(ChronoField.MILLI_OF_SECOND)); // 0
        }
        {
            System.out.println("---------------- Duration ----------------");
            Duration duration = Duration.ofSeconds(86400);
            System.out.println(duration); // PT24H   < ------ 24hours

            Duration duration1 = Duration.ofDays(10).plusHours(12).plusMinutes(24).plusSeconds(48);
            System.out.println(duration1); // PT252H24M48S <-- 252hours 24min 48sec

            System.out.println(duration1.getSeconds()); // 908688
            System.out.println(duration1.get(ChronoUnit.NANOS)); // 0
        }


        {
            System.out.println("----------- compare instant & duration -----------");
            Instant instant = Instant.ofEpochSecond(86420);
            Instant instant1 = Instant.ofEpochSecond(86420*2);

            System.out.println( instant.isBefore(instant1) ); // true
            System.out.println( instant.isAfter(instant1) ); // false

            Instant instant2 = Instant.ofEpochSecond(86420);
            System.out.println( instant.equals(instant2) ); // true

            Duration duration = Duration.ofSeconds(100);
            Instant instant3 = instant2.plus(duration); //
            System.out.println(instant3); // 1970-01-02T00:02:00Z


            Duration duration1 = Duration.ofDays(120);
            Duration duration2 = duration1.plusDays(120);
            System.out.println(duration2); // PT5760H

        }



    }

}
