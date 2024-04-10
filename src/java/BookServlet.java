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
@WebServlet("/BookServlet")  
public class BookServlet extends HttpServlet { 
    @EJB
    FlightDao ol;
    protected void doGet(HttpServletRequest request, HttpServletResponse response)   
         throws ServletException, IOException {  
        response.setContentType("text/html");  
        PrintWriter out=response.getWriter();  
          
        String name=request.getParameter("name");
        Cookie ck=new Cookie("name",name);  
        response.addCookie(ck);
        String id=request.getParameter("id");  
        String source=request.getParameter("source");
        String destination=request.getParameter("destination");
        String classs=request.getParameter("classs");  
        String seat=request.getParameter("seats");
         int seats=Integer.parseInt(seat);  
        Flight e= ol.getById(name,id,source,destination,classs);  
        int m = e.calculate(e.getAmount(),seats);
        
        //Flight e=FlightDao.Search(id,source,destination);
         out.println("<h1>Flight Details</h1>");  
          
          
        out.print("<table border='1' width='100%'>");  
        out.print("<tr><td>AMOUNT</td><td>"+m+"</td></tr>");   
         out.print("<tr><td>TICKET ID</td><td>"+e.getTid()+"</td></tr></table>");  
         out.println("<h1>Payment</h1>");
         out.println("<form action='PayServlet' method='get'>");
         out.println("Card Number:<input type='text' name='id'><br/><br/>");
         out.println("Card Name:<input type='text' name='name'><br/><br/>");
         out.println("<input type='hidden' name='fid' value='"+e.getId()+"'>");
         out.println("Number of Seats:<input type='text' name='seats' value='"+seats+"'><br/><br/>");
         out.println("Amount :<input type='text' name='amount' value='"+m+"'>");
         out.println("Ticket ID:<input type='text' name='tid' value='"+e.getTid()+"'>");
         out.println("<input type='submit' name='submit' value='PAY'>");
        out.close();  
    }  
  
}  