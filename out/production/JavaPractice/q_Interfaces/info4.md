# Interface inheritance


## Interface inheritance
- Can inherit another one or multiple interfaces,
- The inherited interfaces are known as `superinterfaces` and the interface inheriting them is known as `subinterface`,
- An interface inherits the following members of its superinterfaces,
    - Abstract and default methods,
    - Constant fields,
    - Nested types,
- Does not inherit static methods from its superinterfaces,

## Some interfaces used in below examples
- `Singer` interface
  ```
  interface Singer {
      void sing();
      void setRate(double rate);
      double getRate();
  }
  ```
- `Writter` interface, 
  ```
  interface Writer {
      void write();
      void setRate(double rate);
      double getRate();
  }
  ```
- `Player` interface,  
  ```
  interface Player {
      void play();
      void setRate(double rate);
      default double getRate() {
          return 300.0;
      }
  }
  ```

## Example-1: 
- See `TestInheritenceOne.java`,

  Overriding is completely optional in `CharitySinger` since this is an interface,
  ```
  interface CharitySinger extends Singer {
      @Override
      default void setRate(double rate) { // do nothing }
  
      @Override
      default double getRate() {
          return 0.0;
      }
  }
  ```
  Overriding is must here since `MySinger` is a class,
  ```
  static class MySinger implements CharitySinger {
      @Override
      public void sing() {
          System.out.println("Singing free...");
      }
  }
  ```
  Using like this:
  ```
  public static void main(String[] args) {
      CharitySinger singer = new MySinger();
      singer.setRate(345);
      System.out.println(singer.getRate()); // 0
  }
  ```
- There is no problem in this example,

## Example-2
- It is possible that the same person is a `Singer` as well as a `Writer`,
  ```
  interface SingerWriter extends Singer, Writer {
      // No code
  }
  ```
- `SingerWritter` interface inherits, 
  - 3 abstract methods from the `Singer` interface,
  - 3 abstract methods from the `Writer` interface,
  - Inherits methods `setRate()` and `getRate()` twice. One from `Writter` and one from `Writter`,
  - This doesn't even cause any problem as both methods are abstract,
  - 
