

# inheritance part-2

> Codes are in `partTwo` package

## Binding
- Classes have `methods` and `fields`,
- Suppose: See `Parent.java`, `Child.java` and `basicBindingTest()` in `Test.java` 
    ```
    public class Parent {
    
        public void print(){
            System.out.println("Inside parent");
        }
        
    }
    ```
    ```
    public class Child extends Parent{
    
        public void print(){
            System.out.println("Inside child");
        }
    
    }
    ```
    ```
    private static void basicBindingTest(){
        Parent parent = new Child();
        parent.print(); <------ (a)
        parent = new Parent();
        parent.print();
    }
    ```
  - In `(a)`, which method will be called?
  - In such situation, `binding` makes decision, which method or field will be accessed,
  - There are two types of binding:
    - `Early-binding`:
      - Binding occurs at compile time,
      - Also known as `static-binding`,
    - `Late binding`:
      - Binding occurs at runtime, 
      - Also known as `dynamic-binding`,



## Early binding
- Made by the compiler at `compile-time`,
- Used for the following types of methods and fields of a class in Java:
  - All types of fields: `static` and `non-static`,
  - `Static` methods,
  - `Non-static` final methods,
- In early binding, a method or a field is accessed based on the declared type,
- Ex:
    ```
    Parent parent = new Child();
    parent.print(); <------ (a)
    ```
  For above `(a)`, according to `early-binding`, `print()` method of `Parent` class will be called. Remember code is executed at runtime not compile-time,
- Ex





 