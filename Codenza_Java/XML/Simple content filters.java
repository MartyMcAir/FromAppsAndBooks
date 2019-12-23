Simple content filters
  
 

package com.ack.xml.jdom;

import java.util.Iterator;
import java.util.List;

import org.jdom.Comment;
import org.jdom.Element;
import org.jdom.Text;
import org.jdom.filter.ContentFilter;
import org.jdom.filter.Filter;
import org.jdom.input.SAXBuilder;

public class SimpleContentFilters {
  public static void main( String[] args ) throws Exception {
    // load in xml file and get a handle on the root element
    SAXBuilder builder = new SAXBuilder();
    org.jdom.Document doc = builder.build( "drainpipe.xml" );
    Element rootElement = doc.getRootElement();

    Filter filter =
        new ContentFilter( ContentFilter.TEXT | ContentFilter.COMMENT );

    // list all immediate nodes that are either comments or text
    List contents = rootElement.getContent( filter );

    // cycle through chosen content items under the rootElement
    for( Iterator it = contents.iterator(); it.hasNext(); ) {
      Object obj = it.next();
      if( obj instanceof Comment ) {
        System.out.println( "Comment: " + ( (Comment) obj ).getText() );
      }
      else if( obj instanceof Text ) {
        System.out.println( "Text: " + ( (Text) obj ).getTextTrim() );
      }
    }
  }
}
