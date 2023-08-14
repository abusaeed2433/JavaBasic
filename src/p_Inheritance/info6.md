
# inheritance part-6
> Codes are in `partSix` package


## Method Overriding and Generic Method Signatures
- When Java codes with generics types is compiled, the generic types are transformed into raw types
- The process that is used to transform the generic type parameters information is known as `type erasure`,
- Ex: See `GenericSuper.java`, `GenericSub.java`,
    ```
    public class GenericSuper<T> {
        public void m1(T a) { }
    
        public <P extends Employee> void m2(P a) { }
    }
    ```
    When the `GenericSuper` class is compiled, the `erasure` transforms the code during compilation and the resulting code looks as shown
    ```
    public class GenericSuper {
        public void m1(Object a) { }
    
        public void m2(Employee a) { }
    }
    ```
- Overriding generic class like:
    ```
    public class GenericSub extends GenericSuper<Object>{
        public void m1(Object a) { }
    
        public void m2(Employee a) { }
    }
    ```
- In overriding generic class,
  - You may think that they(`m1()`, `m2()`) don't have the same signature. But,
  - If a method uses generic parameters, you need to compare its `erasure`, not the generic version of its declaration,
  - So, comparing with `erasure`, overriding is completely valid,


