Character transcoding

import java.io.*;
import java.net.URL;
import org.xml.sax.InputSource;
import com.sun.xml.parser.Resolver;
import com.sun.xml.util.XmlChars;

public class main
{
    //
    // how many characters of pushback to accomodate when scanning
    // the XML declaration -- enough for the entire XML (or text)
    // declaration, except when excessive whitespace is used.
    //
    static final int    PUSHBACK_SIZE = 1024;

    //
    // Simple demonstration of character set transcoding, where a
    // document in one character set is converted into one in
    // another character set.
    //
    // Argument 0:    encoding to use for output
    // Argument 1:    file or URI to transcode
    //
    // Output is on System.out, in the specified encoding.  This
    // must be a Java encoding name; unfortunately at this time
    // the IANA standard encoding names aren't all accepted, even
    // when the encoding is itself supported.  (JDK 1.2 is better
    // than JDK 1.1 in this respect.)
    //
    // NOTE:  JDK 1.1 and JDK 1.2 do not expose the capability to
    // cause an I/O exception when writing characters which can't
    // be expressed in the output encoding.  This means that the
    // transcoding performed by this program may cause SILENT (!!)
    // errors; the non-encodable characters will be rendered as
    // ASCII question marks ("?") in the output.  (This should get
    // fixed in a future java release.)
    //
    // For example, attempting to transcode a document with Chinese,
    // Japanese, Korean, or Vietnamese text into US-ASCII will as
    // a rule produce lots of "????" text rather than reporting any
    // error in the transcoding.  However, EUC-JP can be readily
    // transcoded to ISO-2022-JP or UTF-8.
    //
    // All input encodings can be transcoded to UTF-8 or UTF-16.
    //
    public static void main (String argv [])
    {
    if (argv.length != 2) {
        System.err.println ("Usage:  transcode encoding [file|uri]");
        System.exit (1);
    }

    try {
        InputSource        inSource;
        PushbackReader    in;
        Writer        out;

        out = new OutputStreamWriter (System.out, argv [0]);
        inSource = createInputSource (argv [1]);
        in = new PushbackReader (inSource.getCharacterStream (),
        PUSHBACK_SIZE);

        // Write the XML declaration, optionally followed
        // by a new end-of-line if there was none already...
        out.write ("<?xml version="1.0" encoding="");
        out.write (argv [0]);
        out.write (""");
        if (maybeStandaloneDecl (in, out))
        out.write ("?>");
        else
        out.write ("?>"
            + System.getProperty ("line.separator"));

        // ... then transcode everything (modulo the errors
        // that are silently swallowed by java.io) 
        char        buf [] = new char [16 * 1024];
        int            len;

        for (;;) {
        len = in.read (buf, 0, buf.length);
        if (len < 0)
            break;
        out.write (buf, 0, len);
        }

        out.close ();

    } catch (Throwable t) {
        t.printStackTrace (System.err);
    }
    System.exit (0);
    }


    static private InputSource createInputSource (String fileOrUrl)
    throws IOException
    {
    File f = new File (fileOrUrl);

    if (f.exists ())
        return Resolver.createInputSource (f);

    return Resolver.createInputSource (new URL (fileOrUrl), true);
    }


    // returns true if saw an XML decl -- avoid adding extra whitespace
    static private boolean maybeStandaloneDecl (
    PushbackReader    in,
    Writer        out
    ) throws IOException
    {
    char    xmlDecl [] = new char [PUSHBACK_SIZE];
    int    len = in.read (xmlDecl, 0, xmlDecl.length);

    for (;;) {
        // 
        // Must start with "<?xml" whitespace
        //
        if (len < 6)
        break;
        if (xmlDecl [0] != '<'
            || xmlDecl [1] != '?'
            || xmlDecl [2] != 'x'
            || xmlDecl [3] != 'm'
            || xmlDecl [4] != 'l')
        break;
        if (!XmlChars.isSpace (xmlDecl [5]))
        break;
        
        //
        // OK, scan for "standalone" pseudo-attribute
        //
        int    cursor;

        for (cursor = 6; cursor < len; cursor++) {
        if (XmlChars.isSpace (xmlDecl [cursor]))
            continue;

        // assume legal XML 1.0 -- shortcuts the parsing!

        // terminate only at "?>"
        if (xmlDecl [cursor] == '?')
            break;
        
        // only "standalone=" starts with 's'
        boolean    isStandalone = (xmlDecl [cursor++] == 's');

        // ... all values are singly or doubly quoted
        while (!(xmlDecl [cursor] == ''' || xmlDecl [cursor] == '"')
            && cursor < len)
            cursor++;
        cursor++;

        // ... 'standalone="no"' can be dropped; only
        // the 'yes' needs to be repeated...
        if (isStandalone && xmlDecl [cursor] == 'y')
            out.write (" standalone="yes"");
        
        // ... skip to the terminating quote
        while (!(xmlDecl [cursor] == ''' || xmlDecl [cursor] == '"')
            && cursor < len)
            cursor++;

        // continue till last "attribute"

        // XXX note:  extremely long XML declarations won't all
        // be buffered ... this happens when unhealthy amounts
        // of whitespace get used.  In such cases this routine
        // will fail by not skipping through the terminal "?>".
        }
        cursor += 2;
        in.unread (xmlDecl, cursor, len - cursor);
        return true;
    }
    in.unread (xmlDecl, 0, len);
    return false;
    }
}
