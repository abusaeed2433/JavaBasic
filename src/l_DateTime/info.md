
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


