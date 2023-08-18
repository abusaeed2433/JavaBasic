
# Main changes from java-8 to java-17

## New `var` keyword
- A new `var` keyword was added that allows local variables to be declared in a more concise manner,
- Ex:
    ```
    var name = new String("hello");
    System.out.println(name); // hello
    
    var student = new Student(121,"Doniel",5.9);
    System.out.println(student.getName()); // Doniel
    System.out.println(student.getHeight()); // 5.9
    ```

## Records


## Extended switch expressions
- Cleaner and less error-prone syntax,
- 