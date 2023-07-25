
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
      - Can be accessed using dot(`.`). Ex: `obj.method();`
    - #### Class variables:
      - Static variables,
      - Declared using the static keyword as a modifier,
      - Every object uses same copy of these variables,
      - Shared among all objects of this class,
      - Can be called using class name.
      - Can be accessed using dot(`.`) on both object and class. Ex: `ClassName.method();`
  - `static` as well as `non-static` fields are initialized to a default value,
  - A numeric field (int, long, ...) is initialized to `zero(0)`,
  - A boolean field is initialized to `false`,
  - A reference type field is initialized to `null`,
- ### Method
  - Represent behavior of objects of the class,
  - see more after example.
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

## Method again
- Represent behavior of objects of the class,
- Is a named block of code,
- Method structure:
  ```
  <<modifiers>> <<return type>> <<method name>> (<<parameters list>>) <<throws clause>> {
    // Body of the method goes here
  }
  ```
- `throws` is optional,
- Ex:
  ```
  public void setAge(int age) {
     if(age < 0 || age < this.age) return;
     this.age = age;
     isAdult = (age>=18);
  }
  ```
- `return-type` can be any data type,
- `void` means doesn't return any value,
- Follows `camelCase` naming convention,
- Method signature:
  - Combination of method `name`, its parameter’s `number, types, order`.
  - `Modifiers`, `return-type`, and `parameter names` are not part of the signature,
  - Ex:
  ```
   public int add(int num1, int num2){
      return num1+num2;
   }
  ```
  - Signature is: `add(int, int)`;
- Not allowed to have more than one method in a class with the same signature,
- A class can have two types of method like variables. `instant method` and `class method`.

## Instance Method
- `Non-static` method,
- Used to implement behavior of the objects of the class,
- Must be called using object,
- Ex:
  ```
  public static void showSomeCharacter(){
    System.out.println("General characteristics");
    //System.out.println(name);//can't access name here
  }
  ```

## Class Method
- `static` method,
- Used to implement the behavior of the class itself,
- Can be called using object or Class name(Recommended) itself,
- Can't access instant variables here, guess why?
- Ex:
  ```
  public void showSpecificCharacter(){
    System.out.println("Name is => "+name);
  }
  ```

## Special `main()` method
- Special method having `public`,`static`, `void`, method name `main` having a String array as parameter,
  ```
  public static void main(String[] args) {
    // entry point of execution
  }
  ```
- JVM invokes this method. If not found, then JVM does not know where to start the application. So, it throws an error stating that no main() method was found,
- You can have as many as `main()` method in a class having different signature. But JVM will call only above one,
- You don't need to write main method in a class if you don't want it to start from here,
- You can also call `main()` method just like other method,
- see `Test.java` class for example.

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

## Local variable

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

