

# DateTime part-4

> Codes are in `partFour` package


## Clocks
- Provides access to the current `instant`, `date`, and `time` in a time `zone`,
- You can extend the `Clock` class to implement your own clock,
- Ex: See `testClock()` in `Test.java`,
    ```
    Clock clock = Clock.systemDefaultZone();
    Clock clock1 = Clock.system(ZoneId.of("+06:00")); 
    
    System.out.println( clock.getZone() ); // Asia/Dhaka
    System.out.println( clock.instant() ); // 2023-08-17T09:10:14.911558100Z <---- UTC
    System.out.println( clock.millis() ); // 1692263414911
    
    
    LocalDateTime ldt = LocalDateTime.now(clock);
    System.out.println( ldt ); // 2023-08-17T15:10:14.911558100 <----- system time
    ```


## Period & Duration
- Amount of time in terms of calendar fields `years`, `months`, and `days`. Whereas `Duration` is also an amount of time in terms of `seconds` and `nanoseconds`,
- `Negative periods` are supported,
- `Duration` represents an `exact number of nanoseconds`, whereas `Period` represents an `inexact amount of time`,
- `Period` is for `humans` what a `Duration` is for `machines`,
- For example: `2 months` is a period since this is not exact. It can be `59`,`60`,`61` days,
- `Additions`, `subtractions`, `multiplications`, and `negation` can be performed on a period,
- Object is created using `static factory method`,
- When you add a `period of one day` to a `ZonedDateTime`, the `date component` changes to the `next day`, keeping the `time the same`. But,
- When you add a `duration of a day`, it will always add `24 hours`,
- `normalized()` method of the `Period` class to normalize the `years` and `months` only,
- Ex(`Period`): See `testPeriod()` in `Test.java`,
  ```
  private static void testPeriod(){  
      Period period;
      period = Period.of(1,1,1);
      System.out.println( period ); // P1Y1M1D <--- 1year 1month 1day
  
      period = Period.ofDays(10);
      System.out.println( period ); // P10D <--- 10days
  
      period = period.negated();
      System.out.println( period ); // P-10D
  
      period = period.negated();
      System.out.println( period ); // P10D
  
      period = period.plusMonths(16);
      System.out.println( period ); // P16M10D
  
      period = period.minusMonths(4);
      System.out.println( period ); // P12M10D
  
      period = period.multipliedBy(2);
      System.out.println( period ); // P24M20D
  
      period = period.normalized();
      System.out.println( period ); // P2Y20D <-- only year & month are normalized  
  }
  ```
- Ex(`Duration`): See `testDuration()` in `Test.java`,
  ```
  private static void testDuration(){
  
      Duration duration;
      duration = Duration.ofDays(10);
      System.out.println( duration ); // PT240H
  
      duration = duration.negated();
      System.out.println( duration ); // PT-240H
  
      duration = duration.negated();
      System.out.println( duration ); // PT-240H
  
      duration = duration.plusMinutes(160);
      System.out.println( duration ); // PT242H40M
  
      duration = duration.minusMinutes(20);
      System.out.println( duration ); // PT242H20M
  
      duration = duration.multipliedBy(2);
      System.out.println( duration ); // PT484H40M
  }
  ```


