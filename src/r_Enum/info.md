

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
- Can be used in `switch` statement,

## Enum constant
- All enum constants are objects of the same enum type,
- In above `Gender` enum: `MALE`, `FEMALE`, `OTHERS` are enum constant,
- Name is assigned to each enum constant,
- Order number is assigned to each enum constant called `ordinal`,
- The `ordinal` starts with zero & it is incremented by one for enum constant,
    ```
    System.out.println(Gender.MALE.name()); // MALE
    System.out.println(Gender.FEMALE.name()); // FEMALE
    System.out.println(Gender.OTHERS.name()); // OTHERS
    
    System.out.println(Gender.MALE.ordinal());   // 0
    System.out.println(Gender.FEMALE.ordinal()); // 1
    System.out.println(Gender.OTHERS.ordinal()); // 2
    ```


