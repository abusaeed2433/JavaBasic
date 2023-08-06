

# interface part-5

> CODES ARE IN `partFive` PACKAGE

## The `instanceof` Operator
- To evaluate if a reference type variable refers to an object of a specific class or class implements a specific interface,
- Structure:
    ```
    <<referenceVariable>> instanceof <<referenceType>>
    ```
- Ex:
- 
- Each expression has a compile-time and a runtime type in java,  
- `instanceof` operator performs compile-time check as well as runtime check,
- At compile-time, it checks if it is possible for its `left-hand` operand to point to an instance of its `right-hand` operand type,
- If the `instanceof` operator returns `true` at runtime, it means that its `left-hand` operand can be safely cast to the type represented by its `right-hand` operand,
- If the `left-hand` operand of the `instanceof` operator is `null` or a reference variable, which points to null at runtime, `instanceof` returns `false`,
- if `var instanceof XYZ` returns `true`, then,
  - `var` is not `null`,
  - The cast `(XYZ)var` will always succeed,

## Marker Interfaces

## Comparing Objects

## Polymorphism—One Object, Many Views

## Dynamic Binding and Interfaces
