
# inheritance part-3
> Codes are in `partFour` package

## Method overloading
- Having more than one method with the `same name` in the `same class`,
- Methods could be declared methods, inherited methods, or a combination of both,
- At least one of this must differ: 
  - `Number of parameters,` 
  - `Types of parameters`,
- Things that doesn't matter:
  - The return type, 
  - Access level,
  - `throws` clause,
- It is another kind of polymorphism where the same method name has different meanings,
- It is bound at `compile time` as opposed to `method overriding` that is bound at runtime,
- For an overloaded method call:
  - Compiler chooses the **most specific** method,
  - If it **doesn't** find an exact match, it will try to **look for a more generic version** by converting actual parameter into a more generic type,

- Ex-1: See `Test.java`,
    ```
    private static int add(int x, int y){
        int res = (x+y);
        System.out.println("int add");
        return res;
    }
    
    private static double add(double x, double y){
        double res = x+y;
        System.out.println("double add");
        return res;
    }
    ```
    Calling like:
    ```
    System.out.println( add(5,10) ); // 15
    System.out.println( add(5.0,10) ); // 15.8
    ```

- Ex-2: See `MyMath.java`,
    ```
    public class MyMath {
        public double sub(int a, double b) { return a - b; }
  
        public double sub(double a, int b) { return a - b; }
    }
    ```
    Calling like:
    ```
    MyMath myMath = new MyMath();
    myMath.sub(5.0,2); // fine
    myMath.sub(5,2.0); // fine
    //myMath.sub(5,5); // ambiguous - compile-time error
    ```
- Last one is ambiguous, because compiler can use both `sub()` methods,
- Most of the error will be compile-time. So don't worry,

> Overloading is simple. Just don't be confused,

## Inheritance and Constructors
- Constructors are `not inherited by subclasses` since they are not member of a class,
- To initialize the instance variables of `Parent` classes, the constructors of `Parent` class must be called,
- `super` keyword is used for calling parent class constructor,
- Constructor of `Parent` class is called first then `Child` class,
- Ex: See `Parent.java`, `Child.java` and `testConstructorSequence()` in `Test.java`,
  ```
  public class Parent {
      public Parent() {
          System.out.println("parent constructor");
      }
  }
  ```
  ```
  public class Child extends Parent{
      public Child() {
          // super(); // is automatically inserted
          System.out.println("Child constructor");
      }
  }
  ```
  Calling like this:
  ```
  private static void testConstructorSequence(){
      Child child = new Child();
      /*
       Output
       parent constructor
       Child constructor
      */
  }
  ```
- Here `super()`:
  - Calls `Parent` class constructor,
  - Calls no argument constructor of `Parent` class,
  - Is automatically added by compiler,
  - Must be the first statement of a constructor,
- If constructor of `Parent` class takes some parameter then simply pass those inside `super(here)`,
- Ex:















