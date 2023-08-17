package l_DateTime.partFour;

import java.time.*;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAmount;

public class Test {

    public static void main(String[] args) {

        testClock();
        testPeriod();
        testDuration();
//        pdConversion();
        calculateElapsed();
    }

    private static void calculateElapsed(){
        System.out.println("------------------- calculateElapsed -------------------");

        LocalTime t1 = LocalTime.of(7,12);
        LocalTime t2 = LocalTime.of(11,12);

        long hours = t1.until(t2, ChronoUnit.HOURS);
        System.out.println( hours ); // 4

        long hrs = ChronoUnit.HOURS.between(t1,t2);
        System.out.println( hrs ); // 4

    }

    private static void pdConversion(){ // error
        System.out.println("------------------ pdConversion ------------------------");

        Duration duration = Duration.ofDays(10);

        // duration to period
        Period period = Period.from(duration);
        System.out.println(period);

        // period to duration
        duration = Duration.from(period);
        System.out.println( duration );

    }

    private static void testDuration(){
        System.out.println("---------------- testDuration() ----------------");

        Duration duration;
        duration = Duration.ofDays(10);
        System.out.println( duration ); // PT240H

        duration = duration.negated();
        System.out.println( duration ); // PT-240H

        duration = duration.negated();
        System.out.println( duration ); // PT-240H

        System.out.println("-----------------------");

        duration = duration.plusMinutes(160);
        System.out.println( duration ); // PT242H40M

        duration = duration.minusMinutes(20);
        System.out.println( duration ); // PT242H20M

        duration = duration.multipliedBy(2);
        System.out.println( duration ); // PT484H40M

    }

    private static void testPeriod(){
        System.out.println("--------------- testPeriod ---------------------");

        Period period;
        period = Period.of(1,1,1);
        System.out.println( period ); // P1Y1M1D <--- 1year 1month 1day

        period = Period.ofDays(10);
        System.out.println( period ); // P10D <--- 10days

        period = period.negated();
        System.out.println( period ); // P-10D

        period = period.negated();
        System.out.println( period ); // P10D

        System.out.println("-----------------------");

        period = period.plusMonths(16);
        System.out.println( period ); // P16M10D

        period = period.minusMonths(4);
        System.out.println( period ); // P12M10D

        period = period.multipliedBy(2);
        System.out.println( period ); // P24M20D

        period = period.normalized();
        System.out.println( period ); // P2Y20D <-- only year & month are normalized

    }

    private static void testClock(){
        System.out.println("---------------- testClock ---------------------");

        Clock clock = Clock.systemDefaultZone();
        Clock clock1 = Clock.system(ZoneId.of("+06:00"));

        System.out.println( clock.getZone() ); // Asia/Dhaka
        System.out.println( clock.instant() ); // 2023-08-17T09:10:14.911558100Z <---- UTC
        System.out.println( clock.millis() ); // 1692263414911


        LocalDateTime ldt = LocalDateTime.now(clock);
        System.out.println( ldt ); // 2023-08-17T15:10:14.911558100 <----- system time



    }

}
