
# Array

## Introduction
- A fixed-length data structure that is used to hold more than one value of the same data type,
- All elements of an array are stored contiguously in memory,
  - In case of a reference type array, the array elements store the references of the objects,
  - Those references in the elements are stored contiguously, not the objects they are referring to. 
  - The objects are stored on heap and their locations are, typically, not contiguous,
- All arrays in Java are objects but `abstract` i.e. can't create object directly,
- Arrays are created dynamically at runtime,
- The length of an array cannot be modified after it has been created,
- Ex:
    ```
    int[] arr = new int[5];
    ```
- Index is zero(`0`) based just like `C` or `C++`,
- Make sure to assign values before using,
- Ex: See `arrayTest()` of `Test.java`,
    ```
    String[] names = new String[4];
    printArray(names); // null null null null
    
    names[0] = "Pantho";
    names[2] = "Aslam";
    printArray(names); // Pantho null Aslam null
    
    names[1] = "Maruf";
    names[3] = "Anik";
    
    printArray(names); // Pantho Maruf Aslam Anik 
    for (int i=0;i<names.length; i++){
        names[i] = names[i].substring(0,1); // ----(a)
    }
    printArray(names); // P M A A 
    ```
    - If you don't assign `Maruf` and `Anik`, then program will crash at `(a)`,
- See `Test.java`,

