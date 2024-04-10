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
import java.time.LocalDate;
import java.time.Month;
  
import javax.servlet.ServletException;  
import javax.servlet.annotation.WebServlet;  
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;  
import javax.servlet.http.HttpSession; 
@WebServlet("/TicketServlet")  
public class TicketServlet extends HttpServlet {  
    @EJB
    AccountDao ol;
    FlightDao of;
    public void service(HttpServletRequest request, HttpServletResponse response) 
   throws ServletException, IOException {
        response.setContentType("text/html");  
        PrintWriter out=response.getWriter();  
        LocalDate currentdate = LocalDate.now();
        Month currentMonth = currentdate.getMonth();
        int currentYear = currentdate.getYear();
        HttpSession session=request.getSession(); 
        String uname = (String)session.getAttribute("userid");
        Account e = ol.getByUname(uname);
        Flight f = of.Search(e.getFid());
        out.print("<style>body{\n" +
"  background-image: url(\"http://i.imgur.com/aBayW5C.png\");\n" +
"}   div { "
                + "width:50%;\n" +
"  border-radius: 5px;\n" +
"  background-color: #ffff;\n" +
"  padding: 20px;\n" +
"}</style>");
        if(e.getFid()!="0" && e.getTid() > 0){
       out.print("<center><div><h2><u>Ticket Details</u></h2>");
       out.print("<h3>Ticket ID : "+e.getTid()+"</h3>");
       out.print("<h3>Number of Seats : "+e.getSeats()+"</h3>");
       out.print("<h3>Ticket Class : "+f.getClasss()+"</h3>");
       out.print("<h3>Ticket Cost : "+e.getPaid()+"</h3>");
       out.print("<hr><h2><u>Flight Details</u></h2>");
       out.print("<h3>Flight ID : "+f.getId()+"</h3>");
       out.print("<h3>Flight Name : "+f.getName()+"</h3>");
       out.print("<h3>Source : "+f.getSource()+"</h3>");
       out.print("<h3>Destination : "+f.getDestination()+"</h3>");
       out.print("<h3>Flight Date : "+f.getTiming()+" "+currentMonth+" "+currentYear+"</h3>");
       out.print("</div></center>");
        }
        else{
            out.print("<center><div><h2>No Tickets have been booked under this username</h2></div></center>");
        }
    }
    
  
}

