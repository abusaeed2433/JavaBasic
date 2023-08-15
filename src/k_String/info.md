
# String part-1

> Codes are in `partOne` package


## Introduction
- A sequence of zero or more characters,
- Represented by an object of the `java.lang.String` class,
- `String` class is `immutable`. i.e., contents of a `String` object can't be modified after it has been created,
- Has two companion classes,
  - `StringBuilder` & `StringBuffer`
  - These are `mutable`,

## String Literals
- `Literals` means `Constant-value`,
- Consists of a sequence of zero or more characters enclosed in `double quotes`,
- All `String literals` are `Objects` of the `String` class,
  - Ex:
  - `""` // empty String literals,
  - `Hello world` // String literals of 11 characters
- Cannot be broken into two lines,
  ```
  // compile-time error
  "He
  llo"
  ```
- Can be broken into 2 lines by using plus(`+`),
  ```
  // valid
  "He"+
  "llo"
  ```

## Escape Sequence in String Literals
- Valid to use all `escape sequence characters` to form a string literal,
- A character can also be represented as a `Unicode escape` in the form `\uxxxx`,
  - `x` is a hexadecimal digit,
- Ex: See `escapeTest()` in `Test.java`,
    ```
    private static void escapeTest(){
        System.out.println( "hello" ); // hello
    
        System.out.println( "he\nllo" );
        // he
        // llo
    
        System.out.println( "100%" ); // 100%
        System.out.println( "Said by \"Unknown\"" ); // Said by "Unknown"
    
        System.out.println("Apple"); // Apple
        System.out.println("\u0041pple"); // Apple
    
    }
    ```
- Not used too much,


## CharSequence
- Is an `interface` in the `java.lang package`,
- `String`, `StringBuffer`, and `StringBuilder` implements `CharSequence` interface. So, these can be used wherever `Charsequence` is required,
- Ex: See `charSequenceTest()` in `Test.java`,
    ```
    private static void printWithLength(CharSequence cs){
        System.out.println(cs+" -> "+cs.length());
    }
    ```
    ```
    private static void charSequenceTest(){
        String name = "Hello S";
        printWithLength(name); // Hello S -> 7
    
        StringBuffer buffer = new StringBuffer("Buffer"); // will be discussed later
        printWithLength(buffer); // Buffer -> 6
    
        StringBuilder builder = new StringBuilder("Builder"); // will be discussed later
        printWithLength(builder); // Builder -> 7
    }
    ```


## Creating String Objects
- `String` class contains `many constructors` that can be used for creating `String` object,
- Ex(Very few constructor): See `stringConstructorTest()` in `Test.java`,
    ```
    private static void stringConstructorTest(){
        String name;
    
        name = new String(); // empty String
        System.out.println(name); //
    
        name = new String("Hello");
        System.out.println(name); // Hello
    
        char[] chars = {'1','2','3','4','a','b','d'};
        name = new String(chars);
        System.out.println(name); // 1234abd
    
        name = new String(chars,3,3); // start from index - 3 & take 3 characters from index-3
        System.out.println(name); // 4ab
    }
    ```
  














