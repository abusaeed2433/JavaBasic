
# Interface

## Introduction
- Very important concept,
- Used for communicating between objects,
- Let us understand the need by considering a case,
- Suppose we have a `Person` class which has `walk()` method in it,
    ```
    public static void letThemWalk(Person[] list){
        for(Person person : list) {
            person.walk();
        }
    }
    ```
    ```    
    Person[] persons = new Person[3];
    persons[0] = new Person("Jack");
    persons[1] = new Person("Jeff");
    persons[2] = new Person("John");
    letThemWalk(persons); // <---------------
    ```
- `letThemWalk(Person[])` will be executed `3` times. There is no problem till now,
- Let us add a class named `Duck` in our project,
- `Duck` can also walk. Except this, there is no similarity between `Person` & `Duck`,
- So, there can have many such class that can have `walk()` method,
- But we can't use them based on this property(`Walkable`) only, since all are different classes,
  ```
  persons[3] = new Duck("Duck1"); // compile time error
  ```
- Above problem can be solved in `3` ways:
  - Solution-1: 
    - See `solution1()`, `letThemWalkUpdated()`, and `getWalkMethod()` in `Test.java`,
    - Using Object class array instead of Person class array,
    ```
    private static Method getWalkMethod(Object obj) {
        ...
        walkMethod = c.getMethod("walk"); // <--- concrete method name is used
        ...
    }
    ```
    ```
    private static void letThemWalkUpdated(Object[] list){
        for(Object  obj : list) {
            Method walkMethod = getWalkMethod(obj); // getting method reference
            ...
            walkMethod.invoke(obj); // calling walk method on the obj
            ...
        }
    }
    ```
    ```
    private static void solution1(){
        Object[] persons = new Object[4];
        ...
        letThemWalkUpdated(persons);
    }
    ```
  - Problem here is: it will stop working if method name is changed,
  - Solution-2:
    - Use different function for `Person` and `Duck` class,
    ```
    private static void letDuckWalk(Duck[] list){
        for(Duck duck : list) {
            if(duck == null) continue;
            duck.walk();
        }
    }
    ```
    ```
    private static void letPersonWalk(Person[] list){
        for(Person person : list) {
            if(person == null) continue;
            person.walk();
        }
    }
    ```
    ```
    private static void solution2(){
        Person[] persons = new Person[3];
        persons[0] = new Person("Jack");
        persons[1] = new Person("Jeff");
        persons[2] = new Person("John");
        letPersonWalk(persons); // <-------

        Duck[] ducks = new Duck[3];
        ducks[0] = new Duck("Ab");
        ducks[1] = new Duck("Bc");
        ducks[2] = new Duck("Ka");
        letDuckWalk(ducks); // <----------
    }
    ```
    - It's not good solution at all since we need to write different function for every class,
  - Solution-3:
    - We can create a parent class named `Animal` then inherit this into `Person` and `Duck` class,
    - Not good because it requires a parent class,
    - Try yourself if you want to,

## Ideal solution for above problem
- We can create an interface named `Walkable` then implement this to `Person` and `Duck` class,
- Ex:
- 