<%-- 
    Document   : login.jsp
    Created on : 3 Apr, 2021, 9:20:27 AM
    Author     : m.vishnu.priya
--%>

<%
session.setAttribute("userid", null);
session.invalidate();
response.sendRedirect("index.jsp");
%>