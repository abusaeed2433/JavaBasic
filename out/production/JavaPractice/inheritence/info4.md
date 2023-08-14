
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
  - 
