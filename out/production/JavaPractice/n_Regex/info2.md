
# Regex part-2

> Codes are in `partTwo` package

## Beware of Backslashes
- `\w` means word character,
- `Backslash` is also used as a part of an escape character,
- Can be used to nullify the special meaning of `metacharacters`,
  - Ex: `\[[0-9]\]`
    - Will match `[` then `any digit` then `]`,
    - Will match `[4]`, `[2]` etc,
    - For expressing it, you need to use two `backslashes`,
    - Regex for above will `\\[[0-9]\\]]`,
- Ex: See `backslashTest()` in `Test.java`,
  ```
  private static void backslashTest(){
  
      //String regex = "\\[[0-9]\\]"; // valid
      String regex = "\\[[0-9]]"; // both are valid. ] itself don't have special meaning. So backslashes is optional
  
      Pattern pattern = Pattern.compile(regex);
  
      String[] arr = {"[0]","[1","[s]","2]","[5]"};
  
      for (String str : arr){
          Matcher matcher = pattern.matcher(str);
          if(matcher.find()){
              System.out.println(str+" -> passed");
          }
          else {
              System.out.println(str+" -> failed");
          }
      }
  
  }
  ```
  Output
  ```
  [0] -> passed
  [1 -> failed
  [s] -> failed
  2] -> failed
  [5] -> passed
  ```