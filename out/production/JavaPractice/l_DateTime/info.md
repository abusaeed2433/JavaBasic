
# DateTime part-1

> Codes are in `partOnr` package


## Introduction
- `Java 8` introduced a new `Date-Time API`,
- Before this new API, there was `Legacy Date-Time API`,
- `Legacy Date-Time API`:
  - Includes classes like:
    - `Date`, 
    - `Calendar`, 
    - `GregorianCalendar`
  - Available in `java.util` and `java.sql` packages,
  - Some issues with the legacy Date-Time API are:
    - A `date` always had two components: `a date` and `a time`. No option for using one separately,
    - Manipulating dates were complex,
    - `Mutable` and therefore `not thread-safe`,
 
## `The New Date-Time API`:
- `Correct`, `powerful`, and `extensible` Date-Time API,
- It consists of about `80` classes,
- `15` classes are enough for using effectively,
- Has a separate set of classes to deal with `machine-based time` and `calendar-based human time`,
- Lets you convert `machine-based time` to `human-based time` and vice versa,
- Most `classes` are `immutable`,
- Doesn't provide public `constructors`,
- They allow creating object via `static factory methods` like,
  - `of()`, `ofXxx()`, and `from()`,

## Exploring the New Date-Time API
- Contains large number of classes,
- Naming convention of methods help understand the API tremendously,
- Methods starting with the same prefix do the similar work,
- All `classes`, `interfaces`, and `enums` for the `Date-Time API` are in `java.time` package,
- Some frequently used classes of `java.time` package are:
  - `LocalDate`: Only `Date`,
  - `LocalTime`: Only `Time`,
  - `LocalDateTime`: `Date` and `Time`,
  - `ZonedDateTime`: `Date`, `Time` and `Zone`,
  - `Period`: Deals with `years`, `months`, and `days` & their operation,
  - `Duration`: Represents a period of time in terms of `seconds` and `nanoseconds`,
  - `Instant`: Represents a `specific point` in time,
- `4` of its subpackages are:
  - `java.time.chrono`:
    - Contains classes supporting `non-ISO calendar` systems like `Hijrah calendar`, `ThaiBuddhist calendar`,
  - `java.time.format`:
    - Contains classes for `formatting` and `parsing` `dates` and `times`,
    - `java.time.temporal`:
      - Contains classes for accessing `components of dates and times`,
      - Also contains classes that act like `date-time adjusters`,
    - `java.time.zone`: 
      - contains classes supporting time zones and zone rules
- Ex: 