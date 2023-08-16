
# Regex part-4

> Codes are in `partThree` package

## Using Named Groups
- group can be named instead of using with number,
- Format:
  ```
  (?<groupName>pattern)
  ```
- The group name must consist of
  - Only `letters` and `digits`,
  - `a to z`, `A to Z`, and `0 to 9`,
  - Must start with `letter`,
- Ex: See `groupTest2()` in `Test.java`,
  - This is the previous example but using `name` instead of `number`,
  - Will find phone number,
  - Find code & number from that phone number,
  - Format the number & print
  ```
  private static void groupTest2(){
      String phones = "+8801792101111, +8801234567890, +8804324567890,+2101234";
  
      String regex = "(\\+\\d{3})(\\d+)\\b"; // <--------------
      Pattern pattern = Pattern.compile(regex);
  
      Matcher matcher = pattern.matcher(phones);
  
      while (matcher.find()){
          String code = matcher.group(1); // <--------------
          String num = matcher.group(2); // <--------------
  
          System.out.println(code+" - "+num);
      }
  }
  ```
  Output:
  ```
  +880 - 1792101111
  +880 - 1234567890
  +880 - 4324567890
  +210 - 1234
  ```

## Resetting the Matcher
- `Matcher` class has a `reset()` method,
- `reset()`:
  - Next call to match a pattern will start from the `beginning` of the input text,
  - Uses the same string,
- `reset(input)`
  - Next call to match a pattern will start from the `beginning` of the input text,
  - Uses the provided `input` string,
- Ex: See `resetTest()` in `Test.java`,
  ```
  private static void resetTest(){
      String[] arr = {"+8801792101111", "+8801234567890", "+8804324567890","+2101234"};
  
      String regex = "(?<code>\\+\\d{3})(?<num>\\d+)\\b";
      Pattern pattern = Pattern.compile(regex);
  
      Matcher matcher = pattern.matcher(""); // dummy
  
      for(String phone : arr){
          matcher.reset(phone);
          matcher.find();
  
          String code = matcher.group("code");
          String num = matcher.group("num");
          System.out.println(code+" - "+num);
      }
  
  }
  ```
  Output:
  ```
  +880 - 1792101111
  +880 - 1234567890
  +880 - 4324567890
  +210 - 1234
  ```

