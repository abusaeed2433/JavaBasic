
# inheritance part-3

> Codes are in `partThree` package

## Method Overriding
- Redefining a method in child class,
- Ex: See `Parent.java`, `Child.java` & `basicOverriding()` in `Test.java`,
    ```
    public class Parent {
    
        public void walk(){ // overridden method
            System.out.println("Parent walking...");
        }
    
    }
    ```
    ```
    public class Child extends Parent{
    
        @Override // optional annotation
        public void walk(){ // overriding method
            System.out.println("Child walking...");
        }
    
    }
    ```
    Using like this:
    ```
    private static void basicOverriding(){
        Child child = new Child();
        child.walk(); // Child walking...
    
        Parent parent = new Parent();
        parent.walk(); // Parent walking...
    
        parent = child;
        parent.walk(); // Child walking... because of late-binding
    }
    ```

## Overriding rules
### Rule-1:
- Method must have to be an `instance` method,
- Overriding doesn't apply to static methods,
### Rule-2:
- The `overriding-method` must have the same name as the `overridden-method`,
### Rule-3:
- The `overriding-method` must have the same number of parameters 
  - of the same type,
  - in the same order as the `overridden-method`,
  - `void print(String str)` & `void print(String msg)` are considered the same method,

### Rule-4:
- For primitive data type,
  - `return-type` of both methods must be the same,
- For reference data type,
  - `return-type` of the `overriding-method` must be assignment compatible to the `return-type` of the `overridden-method`, i.e.,
  - `Child-type` should be assignment compatible to `Parent-type`,
- Ex:
  ```
  public class Parent {
      ...
      int getOne(){ return 1; }
      Parent getThis(){ return this; }
      ...
  }
  ```
  ```
  public class Child extends Parent{
      ...
      @Override
      int getOne(){ return -1; }
      @Override
      Child getThis(){ return this; }
      ...
  }
  ```
  Using like this: See `overridingRule4()` in `Test.java`,
  ```
  private static void overridingRule4(){
      Parent parent = new Parent();
      System.out.println(parent.getOne()); // 1
  
      parent = new Child();
      System.out.println(parent.getThis()); // Child
  }
  ```

### Rule-5:
- The access level of the `overriding-method` must be at least the `same or more relaxed` than that of the `overridden-method`,
- `private` members can't be overridden since they are not inherited,
- See this:
- <img src="files/relaxed_overriding_method.jpg" height="160px"/>


### Rule-6:
- The `overriding-method` can't add a new exception to the list of exceptions in the `overridden-method`,
- It may remove one or all exceptions, 
- It may replace an exception with another exception,
- 
