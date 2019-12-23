Example XML client

package project;

import java.io.IOException;
import java.net.URL;

import org.w3c.dom.Element;

import com.sun.xml.tree.XmlDocument;
import com.sun.xml.parser.Resolver;


/**
 * This class is a sample XML messaging client, supporting simple "echo" and
 * "uppercase" messages that accept pure text messages to show mechanics
 * of sending and receiving valid XML documents as messages over HTTP(S).
 *
 * <P> Normally, XML documents would be designed to reflect the workflow of
 * some process that's being automated.  The vocabulary (element tags, their
 * attributes, and the allowed contents) would be defined to reflect the
 * requirements of that particular proces, and would be described in one or
 * more "Document Type Declaration" (DTD) files, as done in this example.
 * DTDs also have documentation defining the semantics of their elements;
 * for simple DTDs this can be embedded in comments, but DTDs supporting
 * more complex procedures require external documentation.
 *
 * <P> The definitions of such vocabulary definitions need to be agreed
 * on only by the organizations participating in the process.  They might
 * be parts of one organization developing an Intranet application, some
 * companies working on a private Extranet system, or an industry group
 * working on vertical supply chain integration.  Open Standards processes
 * apply to the development of larger systems, such as those involved in
 * Internet Business frameworks.
 *
 * @version 1.3
 */
public class ExampleClient
{
    // can't instantiate
    private ExampleClient () { }

    private final static String exampleDtdFPI =
    "+//Example DTD//foo//EN";

    /**
     * Driver for client, needs three parameters:  URL of server,
     * method name, text message.
     */
    public static void main (String argv [])
    {
    XmlRpcClient    client;
    XmlDocument    doc;
    Element        root;

    if (argv.length != 3) {
        System.err.println ("usage: project.ExampleClient "
        + "URL (echo|uppercase) Message");
        System.exit (1);
    }

    try {

        // prepare to call ...
        client = createClient (new URL (argv [0]));

        // create document that _should_ be valid (server validates!)
        doc = new XmlDocument ();
        doc.setDoctype (exampleDtdFPI, "http://www.example.com/xml", null);
        root = doc.createElement (argv [1]);
        doc.appendChild (root);
        root.appendChild (doc.createTextNode (argv [2]));

        // make call, print result
        doc = client.call (doc);
        doc.write (System.out);
    
    } catch (Exception e) {
        e.printStackTrace (System.err);
    }
    }


    //
    // Create a simple proxy for the object on the server side, which
    // understands the DTD used to define this (trivial) workflow
    // protocol.
    //
    private static XmlRpcClient createClient (URL uri)
    {
    XmlRpcClient    retval = new XmlRpcClient (uri);
    Resolver    r = new Resolver ();

    // In this example, the client doesn't need to customize 
    // request or response documents with specialized DOM elements

    r.registerCatalogEntry (exampleDtdFPI,
        "project/example.dtd",
        ExampleClient.class.getClassLoader ());
    retval.customizeResolver (r);

    return retval;
    }
}
