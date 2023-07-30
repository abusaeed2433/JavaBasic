
# Array

## Introduction
- A fixed-length data structure that is used to hold more than one value of the same data type,
- All elements of an array are stored contiguously in memory,
- All arrays in Java are objects but `abstract` i.e. can't create object directly,
- Arrays are created dynamically at runtime,
- The length of an array cannot be modified after it has been created,
- Ex:
    ```
    int[] arr = new int[5];
    ```
- Index is zero(`0`) based just like `C` or `C++`,
- See `Test.java`,


## Initializing Array Elements
- Array elements are initialized to a default value no matter is it global or local,
- Array elements of primitive data type are initialized to the default value for their data types,
  - Numeric array elements are initialized to zero(`0`), 
  - boolean elements to `false`,
  - Reference type elements to `null`,
  - Ex:
      ```
      String[] names = new String[4];
      printArray(names); // null null null null
      ```
- Make sure to assign values before using. In above `names` array, all values are `null`, you mush refer values, then you can do what you want,
- 
