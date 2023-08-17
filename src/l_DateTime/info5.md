

# DateTime part-5

> Codes are in `partFive` package

## Formatting Dates and Times
- Representing a `datetime` object in a `user-defined textual form`,
- The most important point to keep in mind is that `formatting` and `parsing` are always performed by an object of the `DateTimeFormatter` class,
- `Parsing` is the `opposite of formatting`,
- To format a `datetime object`, `a formatter` needs `2` pieces of information:
  - A format `pattern`, and 
  - A `locale`,
- Formatting can be performed in several ways. They all use `a DateTimeFormatter object` directly or indirectly,
- Some ways are:
  - Using `pre-defined` `standard datetime formatters`,
  - Using the `format()` method of the `datetime classes`,
  - Using `user-defined patterns`,
  - Using the `DateTimeFormatterBuilder class`,

## Using `pre-defined` `standard datetime formatters`,
- Most of the formatters use `ISO datetime formats`,
- Ex:
    ```
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
    ```

## Using the `format()` method of the `datetime classes`
- Done using `format()` method on `datetime` related class,
- `format()` method take an object of the `DateTimeFormatter` class,
- Ex:
    ```
    LocalDate date = LocalDate.of(2023, Month.AUGUST,17);
    String strDate;
    
    strDate = date.format(DateTimeFormatter.ISO_DATE);
    System.out.println(strDate); // 2023-08-17
    
    strDate = date.format(DateTimeFormatter.ISO_WEEK_DATE);
    System.out.println(strDate); // 2023-W33-4
    
    LocalTime time = LocalTime.of(11,12,13);
    String strTime = time.format(DateTimeFormatter.ISO_TIME);
    System.out.println(strTime); // 11:12:13
    ```
