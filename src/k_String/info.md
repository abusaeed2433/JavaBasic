
# String part-1

> Codes are in `partOne` package


## Introduction
- A sequence of zero or more characters,
- Represented by an object of the `java.lang.String` class,
- `String` class is `immutable`. i.e., contents of a `String` object can't be modified after it has been created,
- Has two companion classes,
  - `StringBuilder` & `StringBuffer`
  - These are `mutable`,

## String Literals
- Consists of a sequence of zero or more characters enclosed in `double quotes`,
- All `String literals` are `Objects` of the `String` class,
  - Ex:
  - `""` // empty String literals,
  - `Hello world` // String literals of 11 characters
- Cannot be broken into two lines,
  ```
  // compile-time error
  "He
  llo"
  ```
- Can be broken into 2 lines by using plus(`+`),
  ```
  // valid
  "He"+
  "llo"
  ```

