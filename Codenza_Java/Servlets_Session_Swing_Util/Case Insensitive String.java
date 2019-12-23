Case Insensitive String

import java.util.*;

public final class CaseInsensitiveString implements Comparable {
    private String s;

    public CaseInsensitiveString(String s) {
        if (s == null)
            throw new NullPointerException();
        this.s = s;
    }

    public boolean equals(Object o) {
        return o instanceof CaseInsensitiveString &&
            ((CaseInsensitiveString)o).s.equalsIgnoreCase(s);
    }

    // Lazily initialized, cached hashCode - page 40
    private volatile int hashCode = 0;  // (See Item 48)

    public int hashCode() {
        if (hashCode == 0)
            hashCode = s.toUpperCase().hashCode();

        return hashCode;
    }

    public int compareTo(Object o) {
        CaseInsensitiveString cis = (CaseInsensitiveString)o;
        return String.CASE_INSENSITIVE_ORDER.compare(s, cis.s);
    }

    public String toString() {
        return s;
    }

    // ...  // Remainder omitted

    public static void main(String[] args) {
        // Print arguments in order
        CaseInsensitiveString ciArgs[] =
            new CaseInsensitiveString[args.length];
        for (int i = 0; i < ciArgs.length; i++)
            ciArgs[i] = new CaseInsensitiveString(args[i]);
        Arrays.sort(ciArgs);
        System.out.println(Arrays.asList(ciArgs));

        // Print arguments with duplicates eliminated
        Set s = new HashSet();
        for (int i=0; i < ciArgs.length; i++)
            s.add(ciArgs[i]);
        System.out.println(s);
    }
}

/* USAGE

C:\>java CaseInsensitiveString
[]
[]

C:\>java CaseInsensitiveString uma
[uma]
[uma]

C:\>java CaseInsensitiveString uma hello
[hello, uma]
[uma, hello]

C:\>java CaseInsensitiveString Uma Hello
[Hello, Uma]
[Uma, Hello]

*/
