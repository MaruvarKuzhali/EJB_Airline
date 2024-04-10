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
import javax.servlet.http.HttpServlet;  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;  
@WebServlet("/CancelServlet")  
public class CancelServlet extends HttpServlet {  
    @EJB
    AccountDao ol;
    FlightDao of;
    protected void doGet(HttpServletRequest request, HttpServletResponse response)   
         throws ServletException, IOException {  
        response.setContentType("text/html");  
        PrintWriter out=response.getWriter();  
          
        String name=request.getParameter("name");  
        String id=request.getParameter("id"); 
        String fid = request.getParameter("fid");
        //String tids=request.getParameter("tid");
        //int tid=Integer.parseInt("tids");
        int tid = 0;
        if(request.getParameter("tid")!=null && !request.getParameter("tid").equals("")){
            tid=Integer.parseInt(request.getParameter("tid"));
        }
        Flight f=of.Search(fid);
         Account e = ol.getById(id,name,tid);
         int tids = f.getTid()-e.getSeats();
         f.setTid(tids);
         int seats=f.getSeats() ;
                 seats+= e.getSeats();
         f.setSeats(seats);
         //out.print(f.getSeats());
         
         int sts=of.save(f);
             int amount=e.getAmount() + e.getPaid();
             e.setAmount(amount);
             e.setPaid(0);
             e.setTid(0);
             e.setSeats(0);
             e.setFid("0");
             //e.setUname("");
        int status=ol.save(e);  
        if(status>0 && sts>0){  
            out.print("<p>Amount Refund Successful!!!</p>");  
            request.getRequestDispatcher("index.jsp").include(request, response);  
        }else{  
            out.println("Sorry! Server Error! Unable to cancel Tickets!");  
        }  
          
        out.close();  
    }  
  
}