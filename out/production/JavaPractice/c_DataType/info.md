
#### Java is a statically typed programming language. That is, it checks the data types of all values at compile time.

# Data type
Defined in terms of three components
- A set of values,
- A set of operations that can be applied,
- A data representation, which determines how the values are stored,

## Built-in data types
A programming language provides some predefined data types, which are known as built-in data types.

## Primitive data type
A data type that consists of an atomic, indivisible value, and that is defined without the help of any other data types, is known as a primitive data type.
- A programming language does not let the programmers extend primitive data types.

## Identifier
An identifier in Java is a sequence of characters of unlimited length.
- Includes letters and digits,
- First letter must be a letter,
- Spaces are not allowed in an identifier,
- Case sensitive, 
- Ex: `value`, `VALUE` are different identifier.

## Variables
- These memory locations,
- A variable has three properties:
  - A memory location for storing the value,
  - The type of the data to store at the memory location, and 
  - A name (also called identifier) to refer to the memory location,
  - Ex: `int sum;` data type = `int`, name = `sum`, memory for storing int is allocated.

## Java supports 2 kinds of data types:
### Primitive
  - Holds a value,
  - Ex: `int result;`,
  - 2 categories:
    - Numeric: `byte, short, int, long, char, float, double`, 
    - Boolean: `boolean`,

### Reference: 
- Holds a reference to an object,
- Ex: `String s;`. Keep in mind that, here space is allocated for variable not for object,
- Ex: `String s = new String("Saeed");`, here space is allocated separately for variable and the object it is referring,
  - Be alert while modifying object of reference type inside method,
  - Discussed briefly in `parameter-passing-section`,
  ```
  private static void printHumanData(Human human){
    System.out.println(human.getName()+" -> "+human.getAge());
    human.setAge(26); // will modify main object
  }
  ```
  Calling above function through main function
  ```
  Human human = new Human("Saeed",21);
  printHumanData(human); // Saeed -> 21
  System.out.println(human.getAge()); // 26
  ```
