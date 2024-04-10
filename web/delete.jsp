<%-- 
    Document   : delete
    Created on : 3 Apr, 2021, 9:24:21 AM
    Author     : m.vishnu.priya
--%>

<%@ page import ="java.sql.*" %>
<%
    String userid = request.getParameter("uname");    
    String pwd = request.getParameter("pass");
    Class.forName("com.mysql.jdbc.Driver");
    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/placement?zeroDateTimeBehavior=convertToNull","root","");
    int status = 0;
    PreparedStatement ps=con.prepareStatement("delete from members where uname='" + userid + "' and pass='" + pwd + "'");
    status=ps.executeUpdate();
    //Statement st = con.createStatement();
    //ResultSet rs;
    //rs = st.executeQuery("delete from members where uname='" + userid + "' and pass='" + pwd + "'");
    out.print("Account deleted successfully");
    response.sendRedirect("index.jsp");
%>
