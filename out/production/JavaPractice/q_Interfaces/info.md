
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
  - 