/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EJBpackage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.ejb.Schedule;
import javax.ejb.Stateless;

/**
 *
 * @author m.vishnu.priya
 */
@Stateless
public class FlightDao {
    static Connection con=null;
    
    @Schedule(dayOfWeek = "Mon-Fri", month = "*", hour = "9-17", dayOfMonth = "*", year = "*", minute = "*", second = "0", persistent = false)
    
    public void myTimer() {
        System.out.println("Timer event: " + new Date());
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    
     public static Connection getConnection(){  
        //Connection con=null;  
        try{  
            Class.forName("com.mysql.jdbc.Driver");  
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/placement?zeroDateTimeBehavior=convertToNull","root","");  
        }catch(Exception e){System.out.println(e);}  
        return con;  
    }  
    
    public static List<Flight> getAllFlights(String source, String destination){  
        List<Flight> list=new ArrayList <Flight>();  
          
        try{  
            Connection con=FlightDao.getConnection();  
            PreparedStatement ps=con.prepareStatement("select * from flight where source=? && destination=?"); 
            
            ps.setString(1, source);
            ps.setString(2, destination);
            ResultSet rs=ps.executeQuery();  
            while(rs.next()){  
                Flight e = new Flight();
                String m = rs.getString(1);
                e.setId(m);  
                e.setName(rs.getString(2));  
                e.setSource(rs.getString(3));  
                e.setDestination(rs.getString(4));  
                e.setTiming(rs.getInt(5));
                e.setClasss(rs.getString(6));e.setAmount(rs.getInt(7));
                e.setTid(rs.getInt(8));
                e.setSeats(rs.getInt(9));
                list.add(e);  
            }  
            con.close();  
        }catch(Exception e){e.printStackTrace();}  
          
        return list;  
    } 
    
    public static Flight getById(String name,String id,String source,String destination,String classs){  
        Flight e=new Flight();  
          
        try{  
            Connection con=FlightDao.getConnection();  
            PreparedStatement ps=con.prepareStatement("select * from flight where id=? AND name=? AND source=? AND destination=? AND classs=?");  
            ps.setString(1,id);
            ps.setString(2, name);
            ps.setString(3, source);
            ps.setString(4, destination);
            ps.setString(5, classs);
            ResultSet rs=ps.executeQuery();  
            if(rs.next()){  
                e.setId(rs.getString(1));  
                e.setName(rs.getString(2));  
                e.setSource(rs.getString(3));  
                e.setDestination(rs.getString(4));
                e.setTiming(rs.getInt(5));
                e.setClasss(rs.getString(6));
                e.setAmount(rs.getInt(7));
                e.setTid(rs.getInt(8));
                e.setSeats(rs.getInt(9));
            }  
            con.close();  
        }catch(Exception ex){ex.printStackTrace();}  
          
        return e;  
    }  
    
    public static Flight Search(String id,int tid){  
        Flight e=new Flight();  
          
        try{  
            Connection con=FlightDao.getConnection();  
            PreparedStatement ps=con.prepareStatement("select * from flight where tid=? AND id=?");  
            ps.setInt(1,tid);
            ps.setString(2, id);
            ResultSet rs=ps.executeQuery();  
            if(rs.next()){  
                e.setId(rs.getString(1));  
                e.setName(rs.getString(2));  
                e.setSource(rs.getString(3));  
                e.setDestination(rs.getString(4));
                e.setTiming(rs.getInt(5));
                e.setClasss(rs.getString(6));
                e.setAmount(rs.getInt(7));
                e.setTid(rs.getInt(8));
                e.setSeats(rs.getInt(9));
            }  
            con.close();  
        }catch(Exception ex){ex.printStackTrace();}  
          
        return e;  
    } 
    
    public static Flight Search(String id){  
        Flight e=new Flight();  
          
        try{  
            Connection con=FlightDao.getConnection();  
            PreparedStatement ps=con.prepareStatement("select * from flight where id=?");  
            
            ps.setString(1, id);
            ResultSet rs=ps.executeQuery();  
            if(rs.next()){  
                e.setId(rs.getString(1));  
                e.setName(rs.getString(2));  
                e.setSource(rs.getString(3));  
                e.setDestination(rs.getString(4));
                e.setTiming(rs.getInt(5));
                e.setClasss(rs.getString(6));
                e.setAmount(rs.getInt(7));
                e.setTid(rs.getInt(8));
                e.setSeats(rs.getInt(9));
            }  
            con.close();  
        }catch(Exception ex){ex.printStackTrace();}  
          
        return e;  
    } 
    
    public static int save(Flight e){  
        int status=0;  
        try{  
            Connection con=FlightDao.getConnection();  
            PreparedStatement ps=con.prepareStatement(  
                         "update flight set tid=?,seats =? where name=? AND id=?");  
            ps.setString(3,e.getName());  
            ps.setString(4,e.getId());  
            //ps.setString(3,e.getSource());  
            //ps.setString(4,e.getDestination());  
            //ps.setInt(5,e.getTiming());
            //ps.setString(6,e.getClasss());
            //ps.setInt(7, e.getAmount());
            ps.setInt(1, e.getTid());
            ps.setInt(2,e.getSeats());
            status=ps.executeUpdate();  
              
            con.close();  
        }catch(Exception ex){ex.printStackTrace();}  
          
        return status;  
    } 
    
    public static Flight SearchById(int tid){  
        Flight e=new Flight();  
          
        try{  
            Connection con=FlightDao.getConnection();  
            PreparedStatement ps=con.prepareStatement("select * from flight where tid=?");  
            ps.setInt(1,tid);
            ResultSet rs=ps.executeQuery();  
            if(rs.next()){  
                e.setId(rs.getString(1));  
                e.setName(rs.getString(2));  
                e.setSource(rs.getString(3));  
                e.setDestination(rs.getString(4));
                e.setTiming(rs.getInt(5));
                e.setClasss(rs.getString(6));
                e.setAmount(rs.getInt(7));
                e.setTid(rs.getInt(8));
                e.setSeats(rs.getInt(9));
            }  
            con.close();  
        }catch(Exception ex){ex.printStackTrace();}  
          
        return e;  
    }

    public String result() {
        return ("this is ejb");
    }
}
