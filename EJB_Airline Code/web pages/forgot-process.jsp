<%-- 
    Document   : forgot-process
    Created on : 5 May, 2021, 8:33:37 AM
    Author     : m.vishnu.priya
--%>


<%@ page language="java" contentType="text/html;" pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<%@ page import = "java.io.*,java.util.*,javax.mail.*"%>
<%@ page import = "javax.mail.internet.*,javax.activation.*"%>
<%@ page import = "javax.servlet.http.*,javax.servlet.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Count Rows JSP</title>
</head>
<body>
<%
try
{
Class.forName("com.mysql.jdbc.Driver").newInstance();
Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/placement","root","");
Statement st=con.createStatement();
String email=request.getParameter("email");
String uname = request.getParameter("uname");
String strQuery = "SELECT * FROM members where email='"+email+"' AND uname='"+uname+"'";
ResultSet rs = st.executeQuery(strQuery);
rs.next();
String Countrow = rs.getString(5);
String mail = rs.getString(3);
if(!Countrow.equals("")){

    String result;
    
   final String SSL_FACTORY = "javax.net.ssl.SSLSocketFactory";
   // Recipient's email ID needs to be mentioned.
   String to = email;

   // Sender's email ID needs to be mentioned
   String from = "neofisheries@gmail.com";

   // Assuming you are sending email from localhost
   String host = "localhost";

   Properties props = System.getProperties();
    props.setProperty("mail.smtp.host", "smtp.gmail.com");
    props.setProperty("mail.smtp.socketFactory.class", SSL_FACTORY);
    props.setProperty("mail.smtp.socketFactory.fallback", "false");
    props.setProperty("mail.smtp.port", "465");
    props.setProperty("mail.smtp.socketFactory.port", "465");
    props.put("mail.smtp.auth", "true");
    props.put("mail.debug", "true");
    props.put("mail.store.protocol", "pop3");
    props.put("mail.transport.protocol", "smtp");
    final String username = "neofisheries@gmail.com";//
    final String password = "fishermen";
    try{
      Session session1 = Session.getInstance(props, 
                          new Authenticator(){
                             protected PasswordAuthentication getPasswordAuthentication() {
                                return new PasswordAuthentication(username, password);
                             }});

   // -- Create a new message --
      Message msg = new MimeMessage(session1);

   // -- Set the FROM and TO fields --
      msg.setFrom(new InternetAddress("neofisheries@gmail.com"));
      msg.setRecipients(Message.RecipientType.TO, 
                        InternetAddress.parse(mail,false));
      msg.setSubject("Hello");
      msg.setText("Your password is "+Countrow);
      msg.setSentDate(new java.util.Date());
      Transport.send(msg);
      out.println("<br/><b>Password Sent to your email id Successfully.</b>");
      request.getRequestDispatcher("index.jsp").include(request, response); 
    }catch (MessagingException e){ 
      System.out.println("Error, cause: " + e);
    }
   
}
else{
out.println("Invalid Email Id !");
}
}
catch (Exception e){
e.printStackTrace();
}
%>
</body>
</html>
