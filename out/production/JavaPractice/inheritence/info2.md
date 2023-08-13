

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
- Done by the compiler at `compile-time`,
- Only used for the following types of `methods` and `fields` of a class in Java:
  - All `static` and `non-static` fields,
  - `Static` methods,
  - `Non-static-final` methods,
- In early binding, a `method` or a `field` is accessed based on the declared type,
- Ex: See `Parent.java`, `Child.java`, `earlyBindingTest()` in `Test.java`:
    ```
    public class Parent {
        private String name;
        public static int id = 0;
    
        public final void send(){
            System.out.println("Parent sending...");
        }
    
        public static void run(){
            System.out.println("Parent running...");
        }
    
        public void print(){
            System.out.println("Parent printing...");
        }
    }
    ```
    ```
    public class Child extends Parent{
        private String type;
        public static int id = 1;
    
        public static void run(){
            System.out.println("Child running...");
        }
    
        public void print(){
            System.out.println("Child printing...");
        }
    }
    ```
    ```
    private static void earlyBindingTest(){
        Parent parent = new Parent(); 
        parent.send(); // Parent sending...
        parent.run(); // Parent running...
        System.out.println(parent.id); // 0
    
        parent = new Child(); 
        parent.send(); // Parent sending...
        parent.run(); // Parent running...
        System.out.println(parent.id); // 0
    
    
        Child child = new Child(); 
        child.send(); // Child sending...
        child.run(); // Child running...
        System.out.println(child.id); // 1
    
        ((Parent)child).send(); // Parent sending...
        ((Parent)child).run(); // Parent running...
        System.out.println(((Parent)child).id); // 0
    }
    ```
  - As you can see, it doesn't matter which object the variable is referring,
  - `methods` and `fields` are always accessed based on the variable type,


## Late Binding
- Used for `non-static`, `non-final` methods,
- 