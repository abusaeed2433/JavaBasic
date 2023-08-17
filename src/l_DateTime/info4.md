

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

