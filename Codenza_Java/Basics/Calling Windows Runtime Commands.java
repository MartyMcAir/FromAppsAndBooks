Calling Windows Runtime Commands

import java.io.*;
public class Win
{
public static void main(String[] Miller) throws IOException
{
 Process process =
Runtime.getRuntime().exec("/C:WINNTsystem32calculator.exe");
         process.waitFor();
}
}
