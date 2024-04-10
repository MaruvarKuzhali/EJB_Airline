/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author m.vishnu.priya
 */
import EJBpackage.FlightDao;
import EJBpackage.Flight;
import java.io.IOException;  
import java.io.PrintWriter;  
import java.util.List;  
import javax.ejb.EJB;
  
import javax.servlet.ServletException;  
import javax.servlet.annotation.WebServlet;  
import javax.servlet.http.HttpServlet;  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;  
@WebServlet("/ViewServlet")

public class ViewServlet extends HttpServlet {
    @EJB
    FlightDao ol;
    protected void doGet(HttpServletRequest request, HttpServletResponse response)   
               throws ServletException, IOException { 
        String source = request.getParameter("source");
        String destination = request.getParameter("destination");
        response.setContentType("text/html");  
        PrintWriter out=response.getWriter();  
        //out.println("<a href='index.html'>Add New Employee</a>");  
        out.println("<center><h1>Flights List</h1></center>");  
        //String result = ol.result();
        //out.println(result);
        //Flight m = new Flight();
        //m.setDestination("vishnupriya");
        //out.println(m.getDestination());
        List<Flight> list = ol.getAllFlights(source,destination); 
        
        
        out.print("<style>\n" +
"#customers {\n" +
"  font-family: Arial, Helvetica, sans-serif;\n" +
"  border-collapse: collapse;\n" +
"  width: 70%;\n" +
"}\n" +
"\n" +
"#customers td, #customers th {\n" +
"  border: 1px solid #ddd;\n" +
"  padding: 8px;\n" +
"}\n" +
"\n" +
"#customers tr:nth-child(even){background-color: #f2f2f2;}\n" +
"\n" +
"#customers tr:hover {background-color: #ddd;}\n" +
"\n" +
"#customers th {\n" +
"  padding-top: 12px;\n" +
"  padding-bottom: 12px;\n" +
"  text-align: left;\n" +
"  background-color: #4CAF50;\n" +
"  color: white;\n" +
"}\n" +
"</style>");
        out.print("<style>input[type=button], input[type=submit], input[type=reset],button {\n" +
"  background-color: #4CAF50;\n" +
"  border: none;\n" +
"  color: white;\n" +
"  padding: 16px 32px;\n" +
"  text-decoration: none;\n" +
"  margin: 4px 2px;\n" +
"  cursor: pointer;\n" +
"}</style>");
        out.print("<center><table id='customers' border='1' width='100%'");  
        out.print("<tr><th>Flight Id</th><th>Flight Name</th><th>Source</th><th>Destination</th><th>Date</th><th>Class</th><th>Number of Seats to be Booked</th></tr>");  
        for(Flight e:list){  
         out.print("<tr><td>"+e.getId()+"</td><td>"+e.getName()+"</td><td>"+e.getSource()+"</td><td>"+e.getDestination()+"</td><td>"+e.getTiming()+"</td><td>"+e.getClasss()+"</td><td><form action='BookServlet1' method='get'><input type='hidden' name='id' value='"+e.getId()+"'><input type='text' name='seats'>&nbsp;&nbsp;<input type='submit' name='submit' value='BOOK'></form></tr>");  
         }  
        out.print("</table></center>");  
        out.println("<br/><br/><br/><center><button><a href='success.jsp'>BACK</a></button></center>");
          
        out.close();  
    }  
}  
