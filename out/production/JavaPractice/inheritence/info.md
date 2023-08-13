

# inheritance part-1

> Codes are in `partOne` package


## Introduction
- Important concept of OOP,
- Lets you create `new-class` by reusing code from `existing-class`,
- `new-class` is called `sub-class`, `child-lass`, `derived-class`,
- `existing-class` is called `super-class` or `parent-class`,
- For example: `PartTimeStudent` can inherit `Student`,
- `is-a` relationship must exist among child and parent class. Ex:
  - `PartTimeStudent` is a `Student`,
  - `Manager` is an `Employee`,
  - `Human` is a `Creature`
- Done using `extends` keyword,
    ```
    public class Child extends Parent{
    ```

## Object Class is the Default Superclass
- `extends Object` is implicitly added for `first` `Parent` class,
- Any class can access code of `Object` class without extending it since it is implicitly extended to `Object` class,
- 