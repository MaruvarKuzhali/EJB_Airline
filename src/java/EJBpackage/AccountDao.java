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
import java.util.Date;
import javax.ejb.Schedule;
import javax.ejb.Stateless;

/**
 *
 * @author m.vishnu.priya
 */
@Stateless
public class AccountDao {

    @Schedule(dayOfWeek = "Mon-Fri", month = "*", hour = "9-17", dayOfMonth = "*", year = "*", minute = "*", second = "0", persistent = false)
    
    public void myTimer() {
        System.out.println("Timer event: " + new Date());
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    
    public static Connection getConnection(){  
        Connection con=null;  
        try{  
            Class.forName("com.mysql.jdbc.Driver");  
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/placement?zeroDateTimeBehavior=convertToNull","root","");  
        }catch(Exception e){System.out.println(e);}  
        return con;  
    } 
    
    public static Account getById(String id,String name,int tid){  
        Account e=new Account();  
          
        try{  
            Connection con=FlightDao.getConnection();  
            PreparedStatement ps=con.prepareStatement("select * from account where id=? AND name=? AND tid=?");
            ps.setString(1, id);
            ps.setString(2, name);
            ps.setInt(3,tid);
            ResultSet rs=ps.executeQuery();  
            if(rs.next()){  
                e.setId(rs.getString(2));  
                e.setName(rs.getString(1));  
                e.setSeats(rs.getInt(6));
                e.setAmount(rs.getInt(3));
                e.setTid(rs.getInt(4));
                e.setPaid(rs.getInt(5));
                e.setUname(rs.getString(7));
                e.setFid(rs.getString(8));
            }  
            con.close();  
        }catch(Exception ex){ex.printStackTrace();}  
          
        return e;  
    }
    
    public static Account getByUname(String uname){  
        Account e=new Account();  
          
        try{  
            Connection con=FlightDao.getConnection();  
            PreparedStatement ps=con.prepareStatement("select * from account where uname=?");
            ps.setString(1, uname);
            ResultSet rs=ps.executeQuery();  
            if(rs.next()){  
                e.setId(rs.getString(2));  
                e.setName(rs.getString(1));  
                e.setSeats(rs.getInt(6));
                e.setAmount(rs.getInt(3));
                e.setTid(rs.getInt(4));
                e.setPaid(rs.getInt(5));
                e.setUname(rs.getString(7));
                e.setFid(rs.getString(8));
            }  
            con.close();  
        }catch(Exception ex){ex.printStackTrace();}  
          
        return e;  
    } 
    
    public static int save(Account e){  
        int status=0;  
        try{  
            Connection con=AccountDao.getConnection();
            PreparedStatement ps=con.prepareStatement(  
                         "update account set amount=?,tid=?,paid=?,seats=?,uname=?,fid=? where name =? AND id=?");  
            ps.setString(7,e.getName());  
            ps.setString(8,e.getId());
            ps.setString(6, e.getFid());
            ps.setString(5,e.getUname());
            ps.setInt(4, e.getSeats());
            ps.setInt(1,e.getAmount());  
            ps.setInt(2,e.getTid());  
            ps.setInt(3,e.getPaid());
            status=ps.executeUpdate();  
              
            con.close();  
        }catch(Exception ex){ex.printStackTrace();}  
          
        return status;  
    } 
    
    public static Account Search(String id,String name){  
        Account e=new Account();  
          
        try{  
            Connection con=FlightDao.getConnection();  
            PreparedStatement ps=con.prepareStatement("select * from account where id=? AND name=?");  
            ps.setString(1,id);
            ps.setString(2, name);
            ResultSet rs=ps.executeQuery();  
            if(rs.next()){  
                e.setId(rs.getString(2));  
                e.setName(rs.getString(1));  
                
                e.setAmount(rs.getInt(3));
                e.setTid(rs.getInt(4));
                e.setPaid(rs.getInt(5));
                e.setUname(rs.getString(7));
            }  
            con.close();  
        }catch(Exception ex){ex.printStackTrace();}  
          
        return e;  
    }
}
