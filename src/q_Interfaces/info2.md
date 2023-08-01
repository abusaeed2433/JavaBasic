
# interface part-2

## Declaring an Interface
- Can be declared as 
  - A top-level interface(general),
  - A nested interface,
  - An annotation type,
- Generally interface means top-level interface,
- Structure:
    ```
    <modifiers> interface <interface-name> {
     Constant-Declaration
     Method-Declaration
     Nested-Type-Declaration
    }
    ```
- modifiers are same as class modifier,
- interface-name is a valid java identifier,
- An interface declaration is always abstract whether you declare it abstract explicitly or not,
- Ex: See `Clickable.java`:
    ```
    public interface Clickable {
       // body of interface. Discussed later    
    }
    ```

