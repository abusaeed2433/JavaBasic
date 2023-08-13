

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
  - In such situation, 