
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
  - `return-type` of the `overriding-method` must be assignment compatible to the `return-type` of the `overridden-method`,
- Ex:
- 
