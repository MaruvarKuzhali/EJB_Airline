/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EJBpackage;

/**
 *
 * @author m.vishnu.priya
 */
public class Account {  
private String id;  
private String name;
private int paid,amount,tid,seats;
private String uname;
private String fid;
public String getFid(){
    return fid;
}
public void setFid(String fid){
    this.fid=fid;
}
public String getUname(){
    return uname;
}
public void setUname(String uname){
    this.uname=uname;
}
public int getAmount(){
    return amount;
}
public void setAmount(int amount){
    this.amount=amount;
}
public int getSeats(){
    return seats;
}
public void setSeats(int seats){
    this.seats=seats;
}
public int getTid(){
    return tid;
}
public void setTid(int tid){
    this.tid=tid;
}
public String getId() {  
    return id;  
}  
public void setId(String id) {  
    this.id = id;  
}
public int getPaid()
{
    return paid;
}
public void setPaid(int paid){
    this.paid=paid;
}
public String getName() {  
    return name;  
}  
public void setName(String name) {  
    this.name = name;  
}  
}