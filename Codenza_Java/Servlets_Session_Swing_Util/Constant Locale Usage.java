Constant Locale Usage

import java.text.*;
import java.util.*;

public class ConstantLocaleUsage {

  public static void main(String [] argv) {

    NumberFormat numberFormat = NumberFormat.getInstance();
    numberFormat.setParseIntegerOnly(false);
    double usersNumber;

    if (argv.length == 1)
      try {
        usersNumber = numberFormat.parse(argv[0]).doubleValue();
      } catch (ParseException e) {
        usersNumber = 197912.29;
      }
    else
      usersNumber = 1976.0826;

    numberFormat = NumberFormat.getNumberInstance(Locale.US);
    System.out.println("User's number (US): " + numberFormat.format(usersNumber));
    numberFormat = NumberFormat.getNumberInstance(Locale.GERMANY);
    System.out.println("User's number (GERMANY): " + numberFormat.format(usersNumber));
    numberFormat = NumberFormat.getNumberInstance();
    System.out.println("User's number (DEFAULT LOCALE): " + numberFormat.format(usersNumber));
  }
}
