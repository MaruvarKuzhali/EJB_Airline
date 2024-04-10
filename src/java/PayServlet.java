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
import javax.servlet.http.HttpSession; 
@WebServlet("/PayServlet")  
public class PayServlet extends HttpServlet {  
    @EJB
    AccountDao ol;
    FlightDao of;
    protected void doGet(HttpServletRequest request, HttpServletResponse response)   
         throws ServletException, IOException {  
        response.setContentType("text/html");  
        PrintWriter out=response.getWriter();  
        
        Cookie ck[]=request.getCookies();  
        if(ck!=null){  
         String fname=ck[0].getValue();  
        if(!fname.equals("")||fname!=null){  
              
            //out.print("<br>Thank you for booking your tickets on "+fname+" airline");  
        }  
        }
        
        String name=request.getParameter("name");  
        String id=request.getParameter("id"); 
        int seats = 0;
        if(request.getParameter("seats")!=null && !request.getParameter("seats").equals("")){
            seats=Integer.parseInt(request.getParameter("seats"));
        }
        
        //String seat=request.getParameter("seats");
        //int seats=Integer.parseInt("seat");
        String paids=request.getParameter("amount");
         int paid=Integer.parseInt(paids);
        
        //String tids=request.getParameter("tid");
        //int tid=Integer.parseInt("tids");
         
         String fid = request.getParameter("fid");
         //out.print(fid);
        
        int tid = 0;
        if(request.getParameter("tid")!=null && !request.getParameter("tid").equals("")){
            tid=Integer.parseInt(request.getParameter("tid"));
        }
        HttpSession session=request.getSession(); 
         Account e = ol.Search(id, name);
         Flight f =of.Search(fid);
         int sts=0,status=0;
         if(e.getAmount()>paid)
         {
             int seatss=f.getSeats()-seats;
             f.setSeats(seatss);
             int tids = f.getTid()+seats;
             f.setTid(tids);
             int amount=e.getAmount()-paid;
             e.setAmount(amount);
             e.setPaid(paid);
             e.setTid(tid);
             e.setSeats(seats);
             e.setFid(fid);
             String s = (String)session.getAttribute("userid");
             e.setUname(s);
             status=ol.save(e);
             sts=of.save(f);
         }
         else
         {
             out.println("<p>Amount in your Account is low. Cannot book Tickets.</p>");
         }
        
        if(status>0 && sts>0){
            out.print("<p>Tickets Booked Successfully!!!</p>");  
            request.getRequestDispatcher("index.jsp").include(request, response);  
        }else{  
           // out.println("Sorry! Server Error! Unable to book Tickets!");  
        }  
          
        out.close();  
    }  
  
}
