Simple element filter
  
 

package com.ack.xml.jdom;

import java.util.Iterator;
import java.util.List;

import org.jdom.Element;
import org.jdom.Namespace;
import org.jdom.filter.ElementFilter;
import org.jdom.filter.Filter;
import org.jdom.input.SAXBuilder;

public class SimpleElementFilter {
  public static void main( String[] args ) throws Exception {
    // load in xml file and get a handle on the root element
    SAXBuilder builder = new SAXBuilder();
    org.jdom.Document doc = builder.build( "drainpipe.xml" );
    Element rootElement = doc.getRootElement();

    // filter to get all immediate element nodes for a specific element
    Filter elementFilter = new ElementFilter();

    // filter to get all immediate element nodes called 'colour'
    // for a specific, the null represent the default namespace
    Filter elementFilter2 = new ElementFilter( "colour", null );

    // filter to get all immediate element nodes that belong to the
    // specified namespace
    Namespace aNamespace = Namespace.getNamespace( "myPrefix", "myURI" );
    Filter elementFilter3 = new ElementFilter( aNamespace );

    // filter to get all immediate element nodes named 'clients'
    // that belong to the specified namespace
    Filter elementFilter4 = new ElementFilter( "clients", aNamespace );


    // gets all immediate nodes under the rootElement
    List allNodes = rootElement.getContent();

    // gets all element nodes under the rootElement
    List elements = rootElement.getContent( elementFilter );

    // cycle through all immediate elements under the rootElement
    for( Iterator it = elements.iterator(); it.hasNext(); ) {
      // note that this is a downcast because we
      // have used the element filter.  This would
      // not be the case for a getContents() on the element
      Element anElement = (Element) it.next();
      System.out.println( anElement );
    }
  }
}
