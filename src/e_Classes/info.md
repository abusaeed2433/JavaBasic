
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

## Creating instance of a class
- Object can be created by calling its constructor.
- Ex: `new Hooman();`. This object will be automatically deleted, since we are not assigning it in any variable.
- When you create an object using `new` keyword, it allocates memory for each `instance field` of the class.
- Java runtime takes care of memory allocation, you don't need it.
- Creating object and calling method:
  ```
  Hooman saeed = new Hooman("Saeed",21);
  System.out.println(saeed.isAdult()); // true
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
