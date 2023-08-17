

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
    - Most of the formatters use `ISO datetime formats`,
    - 
  - Using the `format()` method of the `datetime classes`,
  - Using `user-defined patterns`,
  - Using the `DateTimeFormatterBuilder class`,
