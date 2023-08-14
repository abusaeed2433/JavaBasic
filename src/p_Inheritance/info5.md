
# inheritance part-5
> Codes are in `partFive` package

## Disabling Inheritance
- Prevent class from being used as parent class,
- Done by making a class final by adding `final` in class declaration,
- A method can be `final` also,
- A final method cannot be `overridden` or `hidden` by a `subclass`,
- Ex: `String` class is `final`,
- Why to disable inheritance? 
  - Main reasons are `security`, `correctness`, & `performance`,
  - If your class is important for security reasons, you do not want someone to inherit from your class and mess with the security that your class is supposed to implement,
  - A `final` method may result in better performance at runtime because a code optimizer is free to inline the final method calls,
- Ex of `final-class`: 
  ```
  public final class Parent{ }
  ```
  ```
  public class Child extends Parent{} // compile-time error
  ```
- Ex of `final-method`: See `DummyParent.java`, `DummyChild.java`,
  ```
  public class DummyParent {
  
      protected final void start(){
          System.out.println("Parent starting...");
      }
  }
  ```
  ```
  public class DummyChild extends DummyParent{
  
      protected final void start(){ //compile time error
          System.out.println("Parent starting...");
      }
  }
  ```


