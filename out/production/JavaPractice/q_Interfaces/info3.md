

# interface part-3

> CODES ARE IN `partThree` PACKAGE

## Interface Defines a New Type
- An `interface` defines a new reference type,
- You can use an `interface` type anywhere you can use a reference type,
- All rules for a reference type variable apply to a variable of an `interface` type,
- Let us see through an example:
- See `Swimmable.java`, `Swimmer.java` & `Test.java`
    ```
    public interface Swimmable {
        double DEFAULT_SPEED = 20;
        void swim();
    }
    ```
  ```
  public class Swimmer implements Swimmable{
      ...
      private Swimmable swimmable; // global variable
  
      ...
  
      public Swimmable getSwimmable() {
          if(swimmable == null){
              swimmable = this; // referring to this instance
          }
          return swimmable;
      }
  
      public Swimmable getSwimmable() {
          Swimmable swimmable = this; // local variable
          if(this.swimmable == null){
              this.swimmable = swimmable;
          }
          return swimmable;
      }
      ...
  }
  ```
  Calling like this:
  ```
  private static void testReferenceType(){
      Swimmer swimmer = new Swimmer("John",1);
      swimmer.swim(); // calling function
  }
  ```

- ### What type of object in memory does a variable of an interface type refer to?
  - 