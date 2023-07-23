
# Class

## class
- Basic unit of Object-Oriented Programming paradigm(pattern),
- Ex: `Animal` is a class and `tiger` is an object of `Animal` class,

## Structure of JAVA class
```
<<modifiers>> class <<class name>> {
    // Body of the class goes here
}
```
- modifiers:
  - Keywords that associate special meanings to the class declaration,
  - May have zero or more modifiers.
- class name:
  - User defined class name,
  - Follows `Pascal Case` naming convention.
- Body of the class:
  - Contains fields, methods.
- Example: (`Hooman.java`)
  ```
  public class Hooman {
    //see Hooman.java
  }
  ```
  - has `public` modifier,
  - class name is `Hooman`,
  - body contains `field`,`constructor` & some `methods`.


## Components of java class
### A class in Java may consist of five components:
- ### Field / variables
  - Represent properties or attributes of objects of that class.
  - Two types of fields for a class:
    - #### Instance variables: 
      - Non-static variables,
      - Every object contains separate copy of these variables,
      - Must be called using object of the class.
    - #### Class variables:
      - Static variables,
      - Declared using the static keyword as a modifier,
      - Every object uses same copy of these variables,
      - Shared among all objects of this class,
      - Can be called using class name.
- ### Method
  - Represent behavior of objects of the class,
- ### Constructor
  - Used to create objects of the class,
- ### Static initializer
  - For initializing static variables which need some calculation,
- ### Instance initializer,
    - For initializing variables which need some calculation,

Let us understand these through `Hooman` class(`Hooman.java` for full definition)
```
public class Hooman {

    // Field - 2 Class variables
    public static final String SPECIES;
    private static int objectCounter = 0;

    // Field - 3 instance variables
    private String name;
    private int age;
    private boolean isAdult;

    //static initializers
    static {...}

    //instance initializers
    {...}

    //constructor - 2 constructors
    public Hooman() {...}
    public Hooman(String name, int age) {...}

    // methods - 6 methods
    public String getName() {...}
    public void setName(String name) {...}
    public int getAge() {...}
    ...
}
```
