
# interface part-6

> CODES ARE IN `partSix` PACKAGE

## Polymorphism - One Object, Many Views
- It is an ability of an object to provide its different views,
- Interfaces let you create a polymorphic object,
- Ex: See `Walkable.java`, `Swimmable.java`, `Turtle.java`, & `Test.java`,
    ```
    public interface Walkable {
        void walk();
    }
    ```
    ```
    public interface Swimmable {
        void swim();
    }
    ```
    ```
    public class Turtle implements Walkable,Swimmable{
        private String name;
        ...
  
        public void bite(){
            System.out.println(name+" is biting...");
        }
        @Override
        public void swim() {
            System.out.println(name+" is swimming...");
        }
        @Override
        public void walk() {
            System.out.println(name+" is walking...");
        }
    }
    ```
    ```
    private static void testPolymorphic(){
        Turtle turti = new Turtle("Turti");
    
        Swimmable swimmable = turti;
        Walkable walkable = turti;
        Object obj = turti;
    }
    ```
  - `4` different views of the same `turti` object is shown in above `testPolymorphic` method. See below image:
  <img src="files/polymorphic_views.jpg" height="280px">
  - If we use `Walkable` view, then we can access `walk()` method on `Turtle` object,
  - So, different views give different types of access to an object,

- An object of a class can have the following views:
  - A view that is **defined by its class** type
  - Views that are **defined by all superclasses** (direct or indirect) of its class,
  - Views that are **defined by all interfaces implements** by its class or superclasses(direct or indirect),  
- In previous example `Turtle` class has `4` views:
  - `1` from it own class,
  - `1` from its superclass `Object`. Remember, `Object` class is superclass of all class,
  - `2` from implementing two interfaces,
- It may be useful if we want to give access to particular method of a class,
- 

## Dynamic Binding and Interfaces
