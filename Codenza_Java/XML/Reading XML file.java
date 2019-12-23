Reading XML file

<%@ page import="java.sql.*,java.io.*,java.util.*,javax.xml.parsers.*,org.w3c.dom.*,org.xml.sax.*" %>

<%!
String rdoption,cn,strfrmname,questionID;
String nextquestion,value,DBFld,text;
Node question;
Node controlname;
%>

<%
String filePath = System.getProperty("user.dir");
filePath += "\\temp.xml";

DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
DocumentBuilder domBuilder = null;
Document doc = null;

//Set Validating
factory.setValidating(false);
factory.setIgnoringElementContentWhitespace(false);

domBuilder = factory.newDocumentBuilder();
doc = domBuilder.parse(new File(filePath));

NodeList questionList = doc.getElementsByTagName("question");
int totalQuestions = questionList.getLength();

Element ell = doc.getDocumentElement();
NodeList nll = ell.getElementsByTagName("question");
NamedNodeMap b;
Vector temp = new Vector();
Vector cts = new Vector();
Hashtable ch=new Hashtable();

for(int i = 0; i < nll.getLength(); i++)
     {
     Node nn = nll.item(i);
     b = nn.getAttributes();
     if(b != null)
         {
         questionID = b.item(0).getNodeValue();
         temp.add(questionID);
         NodeList children = nn.getChildNodes();
         if (children != null)
             {
             int len = children.getLength();
             int res = len/2;
             cts.add(new Integer(res));
             ch.put(questionID,res+"");
         }
     }
}

Element el = doc.getDocumentElement();
NodeList nl = el.getElementsByTagName("controlname");
NodeList textFNList = el.getChildNodes();
NamedNodeMap a;

int tot=0;
for(int p = 0; p < temp.size(); p++)
     {
     String qid=(String)temp.get(p);
     out.println("questionID"+qid);
     if(ch.containsKey(qid))
         {
         int count=Integer.parseInt((String)ch.get(qid));
         for(int c = 0; c              {
             text = nl.item(tot).getFirstChild().getNodeValue();
             Node n = nl.item(tot);
             a = n.getAttributes();
             nextquestion = a.item(1).getNodeValue();
             value = a.item(2).getNodeValue();
             out.println("
");
             out.println("nextquestion"+nextquestion);
             out.println("
");
             out.println("value"+value);
             out.println("
");
             out.println("text"+text);
             tot++;
         }
     }
}

%>
//test.xml
<?xml version="1.0" encoding="utf-8"?>
<jobs>
<question id="1">
<controlname nextquestion="q2" value="1">first</controlname>
<controlname nextquestion="quit" value="0">second</controlname>
</question>
<question id="2">
<controlname nextquestion="q4" value="1">third</controlname>
<controlname nextquestion="q4" value="0">fourth</controlname>
<controlname nextquestion="q4" value="2">fifth</controlname>
</question>
</jobs>
