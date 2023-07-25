
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
