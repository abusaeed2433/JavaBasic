

# Enum

## Introduction
- Lets you create an ordered list of constants as a type,
- Mainly used for declaring constant,
- Simple structure:
    ```
    <access-modifier> enum <enum-type-name> {
     // List of comma separated names of enum constants
    }
    ```
- Ex:
    ```
    public enum Gender {
        MALE, FEMALE, OTHERS ; // these are enum constant
    }
    ```
- It is a convention to name the enum constants in uppercase,
- Java implements an enum type as a class,
- The compiler does a lot of work for an enum type and generates code for it that is essentially a class,
- Can't create object of enum type. But,
- It can have constructor which is called by compiler only,

## Enum constant
- All enum constants are objects of the same enum type,
- Name is assigned to each enum constant,
- Order number is assigned to each enum constant called `ordinal`,
- - In above `Gender` enum: `MALE`, `FEMALE`, `OTHERS` are enum constant,
- The `ordinal` starts with zero & it is incremented by one for enum constant,
- Ordinal of constant of `Gender` enum is
  - `MALE` = 0,
  - `FEMALE` = 1,
  - `OTHERS` = 2
- 