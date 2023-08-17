
# DateTime part-3

> Codes are in `partThree` package

## `LocalDate`, `LocalTime`, and `LocalDateTime`
- `LocalDate`:
  - Represent `Date` without `time` and `zone`,
- `LocalTime`:
  - Represent `Time` without `date` and `zone`,
- `LocalDateTime`:
  - Represent `Date` & `Time` without `zone`,
- Ex: See `dateTimeDateTime()` in `Test.java`,
    ```
    LocalDate date = LocalDate.of(2023, Month.MARCH, 23);
    System.out.println( date ); // 2023-03-23
    
    LocalDate date1 = date.plusDays(20);
    System.out.println( date1 ); // 2023-04-12
    
    LocalTime time = LocalTime.of(11,12,13);
    System.out.println( time ); // 11:12:13
    
    LocalTime time1 = time.plusHours(14);
    System.out.println(time1); // 01:12:13
    
    LocalDateTime dateTime = LocalDateTime.of(2023,Month.MARCH,23,11,12,13);
    System.out.println( dateTime ); // 2023-03-23T11:12:13
    
    LocalDateTime dateTime1 = dateTime.plusMonths(23);
    System.out.println( dateTime1 ); // 2025-02-23T11:12:13
    
    LocalDate date2 = LocalDate.from(dateTime1); // dateTime has date component
    System.out.println( date2 );
    
    LocalTime time2 = LocalTime.from(dateTime1); // dateTime has time component
    System.out.println( time2 );
    ```

## `OffsetTime` and `OffsetDatetime`
- Represents a `time` and a `datetime` respectively with a `zone offset` from `UTC`,
- `OffsetTime` can be converted into `LocalTime`. Since,
  ```
  OffsetTime = LocalTime + ZoneOffset
  ```
- `OffsetDateTime` can be converted into `LocalDate`, `LocalTime`, `LocalDateTime`, `ZonedDateTime`. Since,
  ```
  OffsetDateTime = LocalDateTime + ZoneOffset
  ```
- Ex: See `zoneTimeDateTime()` in `Test.java`,
    ```
    ZoneOffset zone = ZoneOffset.of("+06:00");

    OffsetTime time = OffsetTime.of(11,12,13,0,zone);
    System.out.println( time ); // 11:12:13+06:00

    LocalTime localTime = time.toLocalTime(); // to localTime
    System.out.println( localTime ); // 11:12:13

  
    OffsetDateTime offsetDateTime = OffsetDateTime.of(2023,3,23,11,12,13,0,zone);
    System.out.println( offsetDateTime ); // 2023-03-23T11:12:13+06:00

    LocalDateTime localDateTime = offsetDateTime.toLocalDateTime(); // to LocalDateTime
    System.out.println( localDateTime ); // 2023-03-23T11:12:13

    LocalDate localDate = offsetDateTime.toLocalDate(); // to LocalDate
    System.out.println( localDate ); // 2023-03-23

    LocalTime localTime1 = offsetDateTime.toLocalTime(); // to LocalTime
    System.out.println( localTime1 ); // 11:12:13

    OffsetDateTime offsetDateTime1 = OffsetDateTime.of(2023,3,23,11,12,13,0,zone);
    System.out.println( offsetDateTime1 ); // 2023-03-23T11:12:13+06:00

    Instant instant = offsetDateTime1.toInstant(); // UTC so, 6 is subtracted
    System.out.println( instant ); // 2023-03-23T05:12:13Z
    ```

## `ZonedDatetime`
- Represents a `datetime` with time `zone`,
    ```
    ZonedDateTime = LocalDateTime + ZoneId
    ```
-