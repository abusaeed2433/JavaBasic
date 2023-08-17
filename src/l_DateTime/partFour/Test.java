package l_DateTime.partFour;

import java.time.Clock;
import java.time.LocalDateTime;
import java.time.ZoneId;

public class Test {

    public static void main(String[] args) {

        testClock();

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
