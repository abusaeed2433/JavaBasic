
# Regex part-1

> Codes are in `partOne` package

<p align="center">
    <img src="files/regex_intro.jpg" height="300px" alt="from nixCraft facebook">
</p>

## Introduction
- A way to describe a `pattern` in a sequence of characters,
- The pattern may be used 
  - To validate the sequence of characters, 
  - To search through the sequence of characters, 
  - To replace the sequence of characters etc
- For example: We may validate user given email address using it,
- For validating a pattern, We need
  - To recognize the pattern,
  - A way(`Regular expression`) to express the recognized pattern,
  - A program(`Regular expression engine`) that can match the pattern against the input string,
- Characters that have `special meanings` inside a regular expression are called `metacharacters`,

## Some symbols for pattern
- `[ `, `]` are used to specify a `character class`(set of characters) inside a regular expression,
- Range of characters can be specified using a character class. The range is expressed using a hyphen (`-`),
- If you use `^` in the beginning of a `character class`, it means `complement` (meaning not),
- Some examples:
  - `[abc]`:
    - Pattern can have only one character among `a`,`b`,`c`,
    - Ex: `a`, `c` are valid string,
  - `[A-Z]`:
    - Pattern can have only one character between `A` to `Z`,
    - Ex: `A`, `R`, `S` are valid string,
  - `[^A-Z]`:
    - Pattern can have only one character except `A` to `Z`,
    - Ex: `a`, `t`, `4` are valid string,
  - `[a-cx-z]`:
    - Any character from `a,b,c,x,y,z`,
  - `[0-9&&[4-8]]`:
    - Intersection of `[0-9]` and `[4-8]`, 
    - Any character from `4,5,6,7,8`,


## Predefined character class
- `\d`:
  - A digit,
  - Same as `[0-9]`,
  - Ex: `0`,`1,`
- `\D`:
  - A non-digit,
  - Same as `[^0-9]`,
  - Ex: `a`, `P`,
- `\s`:
  - A `whitespace` character,
  - Same as `[ \t\n\x0B\f\r]`,
  - Includes:
    - A space(` `) see first one before `\t`,
    - A tab(`\t`),
    - A new line(`\n`),
    - A vertical tab(`\x0B`), 
    - A form feed(`\f`, 
    - A carriage return (`\r`),
  - Ex: ` `(space),
- `\S`:
  - A `non-whitespace` character,
  - Same as `[^\s]`,
  - Ex: `S`,`U`,

- `\w`:
  - A word character,
  - Same as `[a-zA-Z_0-9]`,
  - Includes:
    - lowercase letters,
    - uppercase letter, 
    - underscore,
    - decimal digits,
  - Ex: `N`,`D`,
- `\W`:
  - A non-word character,
  - Same as `[^\w]`,
  - Ex: `@`,`+`,


## Ex-1 (Basic): See `basicRegex()` in `Test.java`,
- Everything will be explained later,
   ```
    private static void basicRegex(){
    
        String regex = "[ABO][+-]";
        Pattern pattern = Pattern.compile(regex);
    
        String[] arr = {"A+","AB-","B-","O"};
    
        for(String bg : arr) {
            Matcher matcher = pattern.matcher(bg);
    
            if(matcher.matches()){ System.out.println(bg+" passed"); }
            else{ System.out.println(bg+" failed"); }
        }
    
    }
    ```
- Output:
    ```
    A+ passed
    AB- failed
    B- passed
    O failed
    ```

## More Powers to Regular Expressions
- `java.util.regex` contains three classes to support the full version of regular expressions,
- `3` classes are:
  - `Pattern`,
    - Holds the compiled form of a regular expression,
    - Compiled form facilitate faster string matching,
  - `Matcher`,
    - Associates the string to be matched with a `Pattern`,
    - It performs the actual match,
  - `PatternSyntaxException`,
    - Represents an `error` in a malformed regular expression,


**RE = Regular Expression**

## Compiling Regular Expressions (`Pattern`)
- A `Pattern` holds the `compiled form` of a RE,
- It(`Pattern`) is `immutable`,
- It can be shared,
- It has no public `constructor`,
- `Pattern` class contains a `static compile()` method, which returns a `Pattern object`,
- Two overloaded version of `compile()` method in `Pattern` class:
  - `static Pattern compile(String regex)`,
  - `static Pattern compile(String regex, int flags)`
- Ex:
    ```
    String regex = "[ABO][+-]";
    Pattern pattern = Pattern.compile(regex);
    Pattern pattern1 = Pattern.compile(regex,Pattern.CASE_INSENSITIVE);
    ```


