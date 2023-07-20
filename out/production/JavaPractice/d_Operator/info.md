
# Operator

> !!! NEVER USE CONFUSING OPERATOR OR CLEVER CODE !!!

> These are just for understanding the concept and for understanding code written by some idiots.

## Operator
A symbol that performs a specific kind of operation on one, two, or three operands, and produces a
result.

## Operators in Java can be categorized based on two criteria:
- ### The number of operands they operate on
  - unary: `a++;`
  - binary: `a = b;`
  - ternary: `mx = a > b `?` a `:` b;`
- The type of operation they perform on the operands

> #### Operator has precedence just like other languages.

## Assignment operator(`=`):
- ### Compile time error will be shown if right side is not assignment compatible to left side. Ex:
  ```
  float f = 1.19F;
  int i = 15;
  i = f; // compile time error.
  i = (int)f; // ok
  ```
- ### `num = 25;`
  - Assigns 25 to `num`,
  - `num = 25` produces 25. So `num1 = num2 = 25` is valid
  - `num = 25` is called an expression (no semicolon),
  - `num = 25;` is called a statement.

- ### Declaration, Initialization, Assignment
  ```
  int count; // Declaration
  count = 0; // assignment
  int value = 5; // initialization
  ```
- ### Expression data type
  Type of the result of `b @ c` is evaluated as
  - `double > float > long > int`. It means that
  - Suppose `c` is of double and `b` is of long, then `b @ c` will be double. Got it?

  - ### Incompatible assignment
  ```
  byte b1;
  b1 = 5; // ok --------------------(a)
  ```
  But,
  ```
  byte b1;
  byte b2 = 2; // ok
  byte b3 = 3; // ok
  b1 = b2 + b3; // error -----------(b)
  b1 = 2 + 3; // ok    -------------(c)
  ```
  - (a) is ok, because 5 is a constant which is within the `-128 to 127`. So ok.
  - (b) is giving error, because `b2+b3` evaluate to `int` and int can't be assigned to a `byte` directly.
  - (b) follows expression data type.
  - (c) is ok because 2,3 are compiled time constant and  `2+3` is calculated at compile time and works like `b1=5`.
  

### Division(`/`): like `C` or `C++`

### Modulus(`%`): find remainder

### Unary plus(`+`):
```
byte b1 = 10;
byte b2 = +5;
b1 = b2; // Ok. byte to byte assignment
b1 = +b2 // error. bcause +b2 convert it into int. Remember Expression data type
```

### Unary minus(`-`): Same like unary plus

### Compound assignment operator:
- `+=`,`-+`,`*=`, `/=`, `%=` 
- These operators are faster and efficient.

### Increment: 
- `++a` : First incremented, then other operation
- `a++` : Other one operation, then increment, then others.
- Ex: 
  ```
  int i = 100;
  ```
  ```
  int j = ++i + 15;
  ```
  > i = 101, j = 116. Remember pre increment is incremented first.
  ```
  j = i++ + 15;
  ```
  ```
  i = 101, j = 115. Steps be like:
  
  j = 100 + 15; // i = 100
  j = 100 + 15; // i = 101
  j = 115; // i =101
  ```
- #### Another idiot
  ```
  int i = 15;
  i = i++;
  ```
  ```
  Steps be like:
  i = 15; // i = 15
  i = 15; // i = 16
  i = 15; 
  ```
  > answer is 15
  

### Decrement: 
- `--a`, `a--`
- Similar to increment rules.

## Relational operators
### Operators
- `==`,`!=`, `>`, `>=`, `<`, `<=`
- These are binary operator
- For primitive operands, it returns true if the both operands represent the same value
- For reference operands, it returns true if the both operands refer to the same object in memory
  > ALERT WHILE USING THESE OPERATORS WITH REFERENCE TYPE
  ```     
  Kuetian st1 = new Kuetian(75,"CSE","Pantho");
  Kuetian st2 = new Kuetian(57,"CSE","Saeed");
  Kuetian st3 = new Kuetian(57,"CSE","Saeed");
  ```
  
  ```
  System.out.println(st1 == st2); // false
  ```
  > false, because referring different object
  ```
  System.out.println(st2 == st3); // false
  ```
  > false, because object is different even though properties are same
  ```
  st1 = st3;
  System.out.println(st1==st3); // true
  ```
  > true, because  `st1` & `st2` are referring same object
- Let's get confused a little
  ```
  Integer num1 = 100;
  Integer num2 = 100;
  System.out.println(num1==num2); // true
  
  Integer num3 = 10000;
  Integer num4 = 10000;
  System.out.println(num3==num4); // false
  ```
  > Just remember this `num1`,`num2`, `num3`, `num4` are object of class `Integer`. Rest will be discussed later
- So, for reference data type, always use `obj1.equlas(obj2)` instead of `==`.
  ```
  Integer num3 = 10000;
  Integer num4 = 10000;
  System.out.println(num3.equals(num4)); // true
  ```

## Logical operators
### Operators
- Logical AND Operator (`&`)
- Short-Circuit AND Operator (`&&`)
- Logical OR Operator (`|`)
- Logical Short-Circuit OR Operator (`||`)
- Logical XOR Operator (`^`)
- Compound Boolean Logical Assignment Operators
  - `&=`, `|=`, `^=`

- Logical and short circuit operator do same thing, only difference is short-circuit operator doesn't execute other condition if not needed.
  - Ex:
  - 

