
# DateTime part-6

> Codes are in `partSix` package

## Parsing Dates and Times
- Process of creating a `date`, `time`, or `datetime` object from a `string`,
- `2` ways to parse:
  - Using the `parse()` method of the `datetime` class,
  - Using the `parse()` method of the `DateTimeFormatter` class,
- A `DateTimeParseException` is thrown if the text can't be parsed,
- `getErrorIndex()` method returns the `index` in the text where the error occurred,
- `getParsedString()` method returns the text being parsed,
- Ex(using `datetime` `parse()`):
    ```
    String strDate = "2023-08-17";
    
    LocalDate localDate = LocalDate.parse(strDate);
    System.out.println(localDate); // 2023-08-17
    
    strDate = "2023-W33-4"; // this format is discussed in previous section
    LocalDate localDate1 = LocalDate.parse(strDate,DateTimeFormatter.ISO_WEEK_DATE);
    System.out.println(localDate1); // 2023-08-17
    ```
- Ex(Using `DateTimeFormatter` `parse()`):
- 