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
- Example usage:
  ```
  public class MyWriterSinger implements TestInheritanceOne.SingerWriter {
  
      private double rate;
  
      @Override
      public void sing() {
          System.out.println("Singing...");
      }
  
      @Override
      public void write() {
          System.out.println("Writing...");
      }
  
      @Override
      public void setRate(double rate) {
          this.rate = rate;
      }
  
      @Override
      public double getRate() {
          return rate;
      }
  }
  ```
- Calling like below:
  ```
  SingerWriter singerWriter = new MyWriterSinger();
  singerWriter.sing();  // Singing...
  singerWriter.write(); // Writing...
  ```
- There is also no problem in this example,


## Example-3
- It is possible that the same person is a `Singer` as well as a `Player`,
  ```
  interface SingerPlayer extends Singer, Player{
          
  }
  ```
  - Above code generates this compile-time-error: `Player and Singer are incompatible; interface SingerPlayer inherits abstract and default for getRate() from types Player and Singer`,
  - Error is because `getRate()` method,
  - `getRate()` is abstract in `Writer` and default in `Player`. So,
  - The compiler cannot decide which method to inherit.
- This error will also occur if any or both of the method is `default`,
- This error can be solved by overriding the method in `sub-interface`,
- So, new implementation of `SinglePlayer` become: See `TestInheritenceOne.java`,
  ```
  interface SingerPlayer extends Singer, Player{
  
      //double getRate(); // ok
  
  //    @Override
  //    default double getRate() { // ok
  //        // own implementation
  //        return 0;
  //    }
  
      @Override
      default double getRate(){
          return Player.super.getRate();
      }
  
  }
  ```
- Overriding method can be `abstract` or `default`. It can also call parent implementation of the method. See uncommented method in above example,

