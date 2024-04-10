<%-- 
    Document   : registration
    Created on : 3 Apr, 2021, 10:17:58 AM
    Author     : m.vishnu.priya
--%>

<%@ page import ="java.sql.*"%>

<%
    String user = request.getParameter("uname");    
    String pwd = request.getParameter("pass");
    String fname = request.getParameter("fname");
    String lname = request.getParameter("lname");
    String email = request.getParameter("email");
     
    Class.forName("com.mysql.jdbc.Driver");
    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/placement?zeroDateTimeBehavior=convertToNull","root","");
    Statement st = con.createStatement();
    //ResultSet rs;
    try{
    int i = st.executeUpdate("insert into members(first_name, last_name, email, uname, pass, regdate) values ('" + fname + "','" + lname + "','" + email + "','" + user + "','" + pwd + "', CURDATE())");
    if (i > 0) {
        //session.setAttribute("userid", user);
        response.sendRedirect("welcome.jsp");
       // out.print("Registration Successfull!"+"<a href='index.jsp'>Go to Login</a>");
    } else {
        
        response.sendRedirect("index.jsp");
    }
    }
    catch(Exception e){
        out.print("<br><h2>Username not available...</h2>");
        RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
        rd.include(request, response);
    }
%>