/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author m.vishnu.priya
 */
import java.io.IOException;  
import java.io.PrintWriter; 
import EJBpackage.*;
import javax.ejb.EJB;
  
import javax.servlet.ServletException;  
import javax.servlet.annotation.WebServlet;  
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;  
@WebServlet("/BookServlet1")  
public class BookServlet1 extends HttpServlet { 
    @EJB
    FlightDao ol;
    protected void doGet(HttpServletRequest request, HttpServletResponse response)   
         throws ServletException, IOException {  
        response.setContentType("text/html");  
        PrintWriter out=response.getWriter();  
          
        String id=request.getParameter("id");  
        
        String seat=request.getParameter("seats");
         int seats=Integer.parseInt(seat);  
        Flight e= ol.Search(id);  
        int m = e.calculate(e.getAmount(),seats);
        
        out.print("<style>"
                + "body {\n" +
"  background-image: url('https://s3-us-west-2.amazonaws.com/s.cdpn.io/38816/image-from-rawpixel-id-2044837-jpeg.jpg');\n" +
"}</style>");
        out.print("<style>\n" +
"#customers {\n" +
"  font-family: Arial, Helvetica, sans-serif;\n" +
"  border-collapse: collapse;\n" +
"  width: 50%;\n" +
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
"  background-color: #04AA6D;\n" +
"  color: white;\n" +
"}\n" +
"</style>");
        out.print("<style>input[type=submit]:hover {\n" +
"  background-color: #45a049;\n" +
"}"
                + "div {width: 50%;\n" +
"  border-radius: 5px;\n" +
"  background-color: #ffff;\n" +
"  padding: 20px;\n" +
"}</style>");
        
        //Flight e=FlightDao.Search(id,source,destination);
         out.println("<h1>Flight Details</h1>");  
          
          
        out.print("<table border='1' id='customers' width='60%'>");  
        out.print("<tr><td>AMOUNT</td><td>"+m+"</td></tr>");   
         out.print("<tr><td>TICKET ID</td><td>"+e.getTid()+"</td></tr></table>");
         
         out.println("<br/><br/><br/><div>");
         out.println("<h1>Payment</h1>");
         out.println("<form action='PayServlet' method='get'>");
         out.println("Card Number:<input type='text' name='id'><br/><br/>");
         out.println("Card Name:<input type='text' name='name'><br/><br/>");
         out.println("<input type='hidden' name='fid' value='"+e.getId()+"'>");
         out.println("Number of Seats:<input type='text' name='seats' value='"+seats+"'><br/><br/>");
         out.println("Amount :<input type='text' name='amount' value='"+m+"'>");
         out.println("Ticket ID:<input type='text' name='tid' value='"+e.getTid()+"'>");
         out.println("<br/><br/><input type='submit' name='submit' value='PAY'>");
         out.print("</div>");
        out.close();  
    }  
  
}