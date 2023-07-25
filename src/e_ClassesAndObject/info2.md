
## Local variable
- Variable declared inside `method`, `constructor`, `block`,
- Formal parameters for a method are treated as local variables,
- `Not` initialized by default,
- Can't be used until it is assigned a value. Will show error instead of garbage value,
- Must be declared before it is used,
- If variables having same name found, local variable get precedence,
- See `LocalVariable.java` for full code,
  ```
  public class LocalVariable {
      private static int counter; // 0
      private String name; // null
      private int num; // 0
      public static void main(String[] args) {...}
  
      public void assignMust(){
          int num;
          //System.out.println(num); // error. Not initialized.
      }
  
      public int calculateDifference(int num2){
          int num = 1001; // local
          System.out.println(num); // 1001
          return this.num - num2; // `this` later
      }
  }
  ```

## Null
- A special reference type called null type,
- It has no name,
- Assignment compatible with any other reference type. Ex:
  ```
  String name = null; // ok
  Integer number = null; // ok
  Hooman none = null; // ok
  int count = null; // error. int is not reference type. Remember?
  ```
- After making `sh = null;`, the object `sh` was referring will be destroyed by JVM, since it is no longer accessible.
  ```
  Hooman sh = new Hooman("sh",22);
  sh = null;
  ```

## this
- Extremely useful keyword,
- Reference to the `current instance` of a class. (Alert it's for `!!!instance`, not class),
- Can be used only in the context of an instance/object.
- Ex:
  ```
  public class TriState {
      ...
      private StateEnum state = StateEnum.FIRST;
      public TriState(StateEnum state) { // state = SECOND is passed
          System.out.println(this.state); // FIRST
          System.out.println(state); // SECOND
          this.state = state; // this.state refers to the global state --- (a)
      }
      ...
  }
  ```
- Creating instance of above class
  ```
  TriState triState = new TriState(SECOND);
  System.out.println(triState.state); ---- (b)
  ```
- `triState.state` in outside is same as `this.state` inside the class for a specific object of the class. See `(b)` and `(a)`.
- Practice yourself.

## final
- prevent modification on which it is used,
- For declaring constant,
- Can be used in the following three contexts:
  - Variable
    - Can be assigned a value only once,
    - Can't reassign after assigning,
    - Can be assigned while declaration or later,
    - If you do not initialize a final variable at the time of its declaration, such a variable is known as a blank final variable. Ex: 
    ```
    final int total;
    ```
  - Class:
    - Class can't be extended or inherited,
  - Method:
    - Can't be redefined (overridden or hidden) in the subclasses,

## final local variable && final parameter
  - see `getArea()` of `Test.java`:
    ```
    private static double getArea(final double r){ // final parameter
       final double pi = 3.1415; // final local variable
       //pi = 3; // error
       //r = 5; // error
       return pi*r*r;
    }
    ```

## final instance variable
- Can be final or blank final,
  - Rules apply for initializing a blank final instance variable:
  - Must be initialized in `one of the` instance initializers or `all` constructors,
  - Don't be confused. Just remember that you can only assign value at once, if you try to reassign it, you will get error.
- All blank final variables and final reference variables are runtime constants. i.e. they are calculated at runtime,
- `Circle.java`
  ```
  public final class Circle {
  
      public static final double PI = 3.14159; // final
  
      private final double r; // blank - final
  
      public Circle() {
          this.r = 0;
      }
  
      public Circle(double r) {
          this.r = r;
      }
  
      public Circle(Circle c){
          this(c.r); // this will assign value
          //this.r = c.r; // error, since already assigned in previous line
      }
  
      public double getArea(){
          return PI * r * r;
      }
  
  }
    
  ```
## final class variable
- Same like previous,
- Good practice to use capital letter for variable naming:
  ```
  public static final double PI = 3.14159;
  ```

## Varargs
- Full form: `variable-length arguments`,
- Can be used both in method and constructor,
- `...` is used,
- We can pass any number of arguments, parameter will work like array. But we don't have to pass array explicitly, 
- Ex: ( See `Test.java` ),
  ```
   private static int max(int... arr){
      ...
   }
  ```
- Can call like this:
  ```
  System.out.println( max() ); // 0
  System.out.println( max(1,22) ); // 22
  System.out.println( max(1,2,3,4,5,6,7,8,10) ); // 10
  ```
- Isn't it awesome?
- There is two restriction
  - A varargs method can have a maximum of one varargs,
     ```
     // n1 has infinite length, so n2 is not needed. error
      void m1(String str, int...n1, int...n2) {
       ...
     }
     ```
  - The varargs must be the last argument in the argument. Same reason even though parameter type is different.
     ```
     void m2(int...n1, String str) {
      ...
     }
    ```
  - This is perfectly valid: ( see `Test.java`)
     ```
     private static int findMinMax(boolean findMax, int ...arr){...}
     ```

