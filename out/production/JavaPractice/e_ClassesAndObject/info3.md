
# Classes and Object part-3
> Codes are in `partThree` package

# Parameter passing in java

## Before passing parameter, let us clear these concepts
- Remember, JAVA supports 2 types of data type.
- primitive: 
  - Stores value directly at its memory address,
- reference:
  - Stores the reference of the object which is located in Heap,

- 1st one is primitive, 2nd one is reference
<img src="primitive_and_reference_data.png" height="200px" alt="Primitive & Reference data type">

- Every variable name has two things associated with it: 
  - a memory address(`lvalue`),
  - a value stored at that memory address(`rvalue`),
- For primitive data type, memory address hold actual data,
- For reference data type, memory address hold the reference of actual data,
- Ex:
  ```
    Hooman sd = new Hooman("sh",22);
    Hooman sh = new Hooman("sd",23);
    sh = sd; ----(a)
    ```
- `lvalue` stores `rvalue` and here `rvalue` is reference of Hooman object.
- For `(a)`, it is interpreted as
    ```
    lvalue of sh = rvalue of sd
    ```
  it means that memory address of `sh` will store the reference of the object to which `sd` is pointing.

## Back to parameter passing again
- All parameters in Java are `passed by value`,
- No way to pass by reference in JAVA,
- The memory address with data is copied into different memory address then passed to method,
- For primitive data type,
  - Memory address holds actual value,
  - So, data is actually copied & it is truly pass by value,
- But for reference data type,
  - The memory address(`lvalue`) holds the reference of actual data, not the actual data,
  - So, `lvalue` with same reference variable is passed,
  - So, `lvalue` is copied but both are pointing to same object,
  - As a result, if we make any change in the object inside method, it will take effect in passed data,

- see `Student.java` and try to understand the code.
- See this image also
<img src="primitive_reference_passing.png" height="180px" alt="Primitive & Reference data type">

>> BELIEVE ME, UNDERSTANDING THIS WILL MAKE YOUR LIFE EASIER

