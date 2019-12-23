Parsing and Formatting a Number into Binary, Octal, and Hexadecimal

int i = 1023;

// Parse and format to binary
i = Integer.parseInt("1111111111", 2); // 1023
String s = Integer.toString(i, 2); // 1111111111

// Parse and format to octal
i = Integer.parseInt("1777", 8); // 1023
s = Integer.toString(i, 8); // 1777

// Parse and format to decimal
i = Integer.parseInt("1023"); // 1023
s = Integer.toString(i); // 1023

// Parse and format to hexadecimal
i = Integer.parseInt("3ff", 16); // 1023
s = Integer.toString(i, 16); // 3ff

// Parse and format to arbitrary radix <= Character.MAX_RADIX
int radix = 32;
i = Integer.parseInt("vv", radix); // 1023
s = Integer.toString(i, radix); // vv
