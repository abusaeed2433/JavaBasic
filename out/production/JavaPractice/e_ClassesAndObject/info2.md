
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
  - 