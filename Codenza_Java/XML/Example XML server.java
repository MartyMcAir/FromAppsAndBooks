Example XML server

package project;

import java.util.Hashtable;

import org.w3c.dom.*;
import com.sun.xml.parser.Resolver;
import com.sun.xml.tree.*;


/**
 * This servlet echoes or uppercases its input text.  A more complex
 * servlet might use a variety of server side state to perform its work,
 * including databases (JDBC), the file system (including XML files),
 * Enterprise JavaBeans (EJBs), Messaging Services (JMS), other web
 * servers (perhaps in a business-to-business Extranet), and more.
 *
 * @version 1.3
 */
public class ExampleServlet extends XmlRpcServlet
{
    private final static String exampleDtdFPI =
    "+//Example DTD//foo//EN";

    /**
     * Arranges that input XML documents are parsed in a trivial
     * "executable code" framework, and that resolving the DTD for
     * the allowed input document type will not require network access.
     */
    public ExampleServlet ()
    {
    SimpleElementFactory    factory = new SimpleElementFactory ();
    Hashtable        bindings = new Hashtable (2);
    Resolver        resolver = new Resolver ();

    //
    // We push most of the work into customized DOM elements
    //
    bindings.put ("*Element", "project.ExampleServlet$Executable");
    bindings.put ("uppercase", "project.ExampleServlet$Uppercase");
    factory.addMapping (
        "http://www.example.com/xml",
        bindings,
        getClass ().getClassLoader ());
    customizeDocument (factory, false);

    //
    // We _really_ don't want to access the network to validate
    // each document ... use its public ID to fetch a resource
    //
    resolver.registerCatalogEntry (exampleDtdFPI,
        "project/example.dtd",
        getClass ().getClassLoader ());
    customizeResolver (resolver);
    }

    /**
     * Modifies the input document, and returns it.  The path info
     * is unused.
     */
    protected XmlDocument rpc (
    String        pathInfo,
    XmlDocument    request
    )
    {
    TreeWalker    walker = new TreeWalker (request);
    Node        node;

    for (node = walker.getCurrent ();
        node != null;
        node = walker.getNext ()) {
        if (node instanceof Executable)
        ((Executable)node).execute ();

        // should report error if it's not an element type
        // that we support ... but client will see an error
        // when it validates, if we missed it!
    }

    // Ensure that the response is as valid as we can make it
    request.setDoctype (exampleDtdFPI, "http://www.example.com/xml", null);
    return request;
    }

    /**
     * Base class for simple execution framework.
     */
    static public class Executable extends ElementNode
    {
    /**
     * In this simple framework, elements may optionally "execute"
     * in an implicit context.  The default implementation of this
     * execution does nothing -- causing input to be echoed.
     *
     * <P> A more functional framework would pass explicit context
     * in to the execution, so that more interesting work could
     * be performed.  For example, per-client session state will
     * often be preserved, and the path info for the request will
     * identify some particular object.
     */
    public void execute ()
    {
        // Default implementation:  does nothing

        // Note that an explicit context (passed by argument)
        // is often desirable (e.g. security or transaction
        // context, parameters, etc)
    }
    }

    /**
     * Simple which, when executed, "uppercases" text (according
     * to the rules used in the server's locale).
     */
    static public class Uppercase extends Executable
    {
    /**
     * This method's execution uppercases the content of its child
     * text element.
     */
    public void execute ()
    {
        // merge multiple text nodes ... and collapse space, unless
        // requested otherwise
        normalize ();

        Text     child = (Text) getFirstChild ();

        if (child != null)
        child.setData (child.getData ().toUpperCase ());
    }
    }
}
