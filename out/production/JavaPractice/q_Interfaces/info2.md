
# interface part-2

> Codes are in `declaration` package

## Declaring an Interface
- Can be declared as 
  - A top-level interface(general),
  - A nested interface,
  - An annotation type,
- Generally interface means top-level interface,
- Structure:
    ```
    <modifiers> interface <interface-name> {
     Constant-Declaration
     Method-Declaration
     Nested-Type-Declaration
    }
    ```
- modifiers are same as class modifier,
- interface-name is a valid java identifier,
- An interface declaration is always abstract whether you declare it abstract explicitly or not,
- Ex: See `Clickable.java`
    ```
    public interface Clickable {
       // body of interface. Discussed later    
    }
    ```

## Declaring Interface Members
- An interface can have three types of members,
  - Constant fields,
  - Abstract, static, and default methods,
  - Static types (nested interfaces and classes)
- All members of an interface are implicitly public,
- An interface cannot have `mutable`(changeable) instance and class variables. Because we can't create object of an interface,


## Constant Fields Declarations
- All fields in an interface are implicitly `public`, `static` and `final`,
- No need to write `public`, `static` and `final` explicitly,
- Constant field can be accessed using dot(`.`),
- Since fields are `final`, so you must have to initialize it while declaring,
- It is a convention to use uppercase letters in the field name,
- Ex: See `Clickable.java`
    ```
    public interface Clickable {
        int SINGLE_CLICK = 1;
        int DOUBLE_CLICK = 2;
        int DOUBLE_CLICK_INTERVAL = 500; // ms
    }
    ```
- Can be used like this: See `Test.java`
  ```
  private static void testConstantField(){
      System.out.println(Clickable.SINGLE_CLICK); // 1
  
      System.out.println(Clickable.DOUBLE_CLICK_INTERVAL); // 500
  
      //Clickable.DOUBLE_CLICK = 10; // error since implicitly final
          
  }
  ```

## Methods Declarations