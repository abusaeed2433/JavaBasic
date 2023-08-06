

# interface part-5

> CODES ARE IN `partFive` PACKAGE

## The `instanceof` Operator
- To evaluate if a reference type variable refers to an object of a specific class or class implements a specific interface,
- Structure:
    ```
    <<referenceVariable>> instanceof <<referenceType>>
    ```
- Ex: See `instanceOfTest` in `Test.java`,
  ```
  Giver giver = new Giver();
  if(giver instanceof Object){
      System.out.println("giver is an object"); // executed
  }
  else{
      System.out.println("giver is not an object");
  }
  ```
- If `left-hand` side of `instanceof` operator is `null` or refers to `null`, then it will return `false`,
- So, if `var instanceof XYZ` returns `true`, then,
  - `var` is not `null`,
  - The cast `(XYZ)var` will always succeed, i.e. 
    - Class of `var` variable may be subclass of `XYZ` class. or,
    - Class of `var` variable may implement `XYZ` interface,
    - Above two can be done directly or indirectly,

- Each expression has a compile-time and a runtime type in java,  
- `instanceof` operator performs `compile-time` check as well as `runtime` check,
- At compile-time, it checks if it is possible for its `left-hand` operand to point to an instance of its `right-hand` operand type,
- Ex: See `InstanceOfTest.java`,
  <img src="files/instanceof_operator.jpg" height="200px">
- For above structure:
  - Ex-1:
    ```
    Munificent john = new MunificentGiver();
    System.out.println(john instanceof Munificent); // true
    ```
    - Because `MunificentGiver` implements `Munificent` interface,
  - Ex-2:
    ```
    Giver giver = new Giver();
    System.out.println (giver instanceof Munificent); // false
    ```
    - Because `Giver` class doesn't implement `Munificent` interface,
  - Ex-3:
    ```
    Giver kim = new StingyGiver();
    System.out.println(kim instanceof Munificent); // false
    ```
    - Because `StingyGiver` & `Giver`(parent of `StingyGiver`) class doesn't implement `Munificent` interface,
  - Ex-4:
    ```
    StingyGiver jim = new StingyGiver();
    //System.out.println(jim instanceof Munificent);
    ```
    - `compile-time` error. Because
    - Right side(`Munificent`) is not assignment compatible to left side(`StingyGiver`),
    - How can the compiler be so sure about this possibility? It is easy,
    - `StingyGiver` class is `final`, which means it cannot be `subclassed`,
    - Variable `jim` whose `compile-time` type is `StingyGiver` can only refer to an object whose class is `StingyGiver`,
    - The compiler also knows that the `StingyGiver` class and none of its ancestor classes implement the `Munificent` interface,
    - With all these reasoning, the compiler determines that you have a logical error in your program & you need to fix it,


## Marker Interfaces
- When an interface has no members (declared or inherited), it is known as a marker interface.
- Also called a `tag-interface`,
- An interface can have members in two ways,
  - by declaring its own members, or 
  - by inheriting members from its superinterfaces,
- Why do we need it?
  - Used to mark a class with a special meaning that can be used in a particular context,
  - 

## Comparing Objects

## Polymorphism—One Object, Many Views

## Dynamic Binding and Interfaces
