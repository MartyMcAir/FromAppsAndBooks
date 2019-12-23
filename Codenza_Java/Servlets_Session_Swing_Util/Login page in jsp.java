Login page in jsp

--------------
<%@ page language ="java" import="java.sql.*" %>
<html>
<body bgcolor="pink">
<form name="f1" method="post">
<table>
<tr>
<td>User Name</td><td><input type="text" name="t1" ></td>
</tr>
<td>Password</td>
<td><input type=""password"" name="t2"></td>
</tr>
<tr>
<td></td>
<td><input type="submit" name="b1" value="LogIn"></td>
</tr>
</table>
<%
String user=request.getParameter("t1");
String pass=request.getParameter("t2");

     try{
    
     Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
     Connection con=DriverManager.getConnection("jdbc:odbc:mydsn", "jp", "jp");
     Statement st=con.createStatement();
     ResultSet rs=st.executeQuery("select username,password from userlog");
     while(rs.next())
         {
         String username=rs.getString(1);
         String password=rs.getString(2);
         if(user.equals(username) && pass.equals(password))
             {
             %>
             <jsp:forward page="/Training_solutions/LoginSuccess.jsp" />
         <%}
         else
         out.println("Login Failed,Please try Againe");
         %>
        
         <%
     }
}catch(Exception e1)
{}

%>

</form>
</body>
</html>
================
LoginSuccess.jsp
-----
<hi>U sucessfuly Entered</h1>
