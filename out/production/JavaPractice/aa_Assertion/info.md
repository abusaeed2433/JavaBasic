# assertion

### Introduction
- State `xxx` in a strong, confident, and forceful way,
- When you assert `xxx` you believe that `xxx` to be true,
- But it does not make that `xxx` always true,
- Sometimes you may be wrong and that `xxx` may be false, even if you assert it to be true,
- Helps to debug code in development and testing,
- Used for detecting logical errors in a program,
- `assert` can be written in 2 ways:
  - `assert booleanAssertionExpression;`
    - This form is enough in almost all cases,
  - `assert booleanAssertionExpression : errorMessageExpression;`
    - `errorMessageExpression` allows writing custom error message. Can be any data type,
- If the assertion expression evaluates to true, no action is taken. Code is executed normally,
- But if evaluates to false, `java.lang.AsssertionError` is thrown,
- Assertion is by default disabled. You must run your code using:
    ```
    java -ea YourClassName
    ```
- Ex:
    ```
    java -ea src/aa_Assertion/Test.java
    ```
- Ex(See `Test.java`):
    ```
    private static void assertType1(){
        int a = getNumber(2);
    
        assert a==4;
        /*
            when we write 4, we know how getNumber(int) works. It helps to debug code.
            Because if a != 4, then there must have error in getNumber(int) function
        */
    
        // assert a == 6; // will throw runtime exception
        System.out.println(a);
    }
    
    private static void assertType2(){
        int a = getNumber(2);
    
        assert a==6 : "Something is wrong in getNumber(int)";
    
        System.out.println(a); // java.lang.AssertionError: Something is wrong in getNumber(int)
    }
    ```
- Must have to run using above command. Otherwise, assertion will be ignored,
- 