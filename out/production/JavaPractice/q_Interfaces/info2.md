
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
- Can declare three types of methods in an interface,
  - Abstract methods in interface,
    - Are implicitly `abstract` and `public`,
    - Doesn't have body,
    - May include parameters, a return type, and a `throws` clause,
    - Can't be `final` since final method can't be overridden,
    - Ex: See `Clickable.java`,
       ```
       public interface Clickable {
           ...
           //public abstract void onClick(); // same as below one
           void onViewSingleClick();
           void onViewDoubleClick() throws RuntimeException;
       }
       ```
  - Static methods,
    - They are implicitly public,
    - Must be called on interface name,
    - Can't be called on variable,
    - Ex: See `Clickable.java` & `Test.java`
      ```
      public interface Clickable {
         ...
         static void printConstant(){
             System.out.println("SINGLE_CLICK: "+SINGLE_CLICK);
             System.out.println("DOUBLE_CLICK: "+DOUBLE_CLICK);
             System.out.println("DOUBLE_CLICK_INTERVAL: "+DOUBLE_CLICK_INTERVAL);
         };

      }
      ```
      Must be called like this: See `Clickable.java`, `Test.java` and `MyItem.java`,
      ```
      private static void staticMethodTest(){
         Clickable.printConstant();
        
         Clickable c = new MyItem();
         //c.printConstant(); // error
      }
      ```
  - Default methods,
    - Provides a default implementation for the method,
    - Declared with `default` keyword,
    - Optional to override `default` method in a `class` that implements the interface,
    - One reason
      - Suppose you have developed an interface and used it in many place,
      - You want to add a new method in the interface,
      - If you add a new method, you will have to override this method in every class that implements the interface,
      - Solution is to add a default method by providing a default implementation,
      - Since `default` method is optional to override. So,
      - You can add any number of default method without modifying existing code,
    - Have access to the keyword this in the same way as class,
    - Ex: See `Clickable.java`, `MyItem.java ` & `Test.java`,
      ```
      public interface Clickable {
         ...
         default void requestSingleClick(){
             this.onViewSingleClick(); //
         }
      }
      ```
      
      ```
      public class MyItem implements Clickable{
         @Override
         public void onViewSingleClick() {
            System.out.println("Single click");
         }

         @Override
         public void onViewDoubleClick() throws RuntimeException {
            System.out.println("Double click");
         }
      }
      ```
      Accessing like this:
      ```
      private static void defaultMethodTest(){
         Clickable myItem = new MyItem();
         myItem.requestSingleClick();
      }
      ```
    - See we haven't overridden `requestSingleClick()` method in `MyItem.java`,
    - But we can override if we want to. It's optional,
    - 
      