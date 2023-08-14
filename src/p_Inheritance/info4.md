
# inheritance part-3
> Codes are in `partFour` package

## Method overloading
- Having more than one method with the `same name` in the `same class`,
- Methods could be declared methods, inherited methods, or a combination of both,
- At least one of this must differ: 
  - `Number of parameters,` 
  - `Types of parameters`,
- Things that doesn't matter:
  - The return type, 
  - Access level,
  - `throws` clause,
- It is another kind of polymorphism where the same method name has different meanings,
- It is bound at `compile time` as opposed to `method overriding` that is bound at runtime,
- For an overloaded method call:
  - Compiler chooses the **most specific** method,
  - If it **doesn't** find an exact match, it will try to **look for a more generic version** by converting actual parameter into a more generic type,

- Ex-1: See `Test.java`,
    ```
    private static int add(int x, int y){
        int res = (x+y);
        System.out.println("int add");
        return res;
    }
    
    private static double add(double x, double y){
        double res = x+y;
        System.out.println("double add");
        return res;
    }
    ```
    Calling like:
    ```
    System.out.println( add(5,10) ); // 15
    System.out.println( add(5.0,10) ); // 15.8
    ```

- Ex-2: See `MyMath.java`,
    ```
    public class MyMath {
        public double sub(int a, double b) { return a - b; }
  
        public double sub(double a, int b) { return a - b; }
    }
    ```
    Calling like:
    ```
    MyMath myMath = new MyMath();
    myMath.sub(5.0,2); // fine
    myMath.sub(5,2.0); // fine
    //myMath.sub(5,5); // ambiguous - compile-time error
    ```
- Last one is ambiguous, because compiler can use both `sub()` methods,
- Most of the error will be compile-time. So don't worry,

> Overloading is simple. Just don't be confused,
