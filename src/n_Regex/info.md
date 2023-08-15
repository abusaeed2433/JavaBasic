
# Regex part-1

> Codes are in `partOne` package

<p align="center">
    <img src="files/regex_intro.jpg" height="300px" alt="from nixCraft facebook">
</p>

## Introduction
- A way to describe a `pattern` in a sequence of characters,
- The pattern may be used 
  - To validate the sequence of characters, 
  - To search through the sequence of characters, 
  - To replace the sequence of characters etc
- For example: We may validate user given email address using it,
- For validating a pattern, We need
  - To recognize the pattern,
  - A way(`Regular expression`) to express the recognized pattern,
  - A program(`Regular expression engine`) that can match the pattern against the input string,
- Characters that have `special meanings` inside a regular expression are called `metacharacters`,

## Some symbols for pattern
- `[ `, `]` are used to specify a `character class`(set of characters) inside a regular expression,
- Range of characters can be specified using a character class. The range is expressed using a hyphen (`-`),
- If you use `^` in the beginning of a `character class`, it means `complement` (meaning not),
- Some examples:
  - `[abc]`:
    - Pattern can have only one character among `a`,`b`,`c`,
    - Ex: `a`, `c` are valid string,
  - `[A-Z]`:
    - Pattern can have only one character between `A` to `Z`,
    - Ex: `A`, `R`, `S` are valid string,
  - `[^A-Z]`:
    - Pattern can have only one character except `A` to `Z`,
    - Ex: `a`, `t`, `4` are valid string,
  - `[a-cx-z]`:
    - Any character from `a,b,c,x,y,z`,
  - `[0-9&&[4-8]]`:
    - Intersection of `[0-9]` and `[4-8]`, 
    - Any character from `4,5,6,7,8`,








a



a