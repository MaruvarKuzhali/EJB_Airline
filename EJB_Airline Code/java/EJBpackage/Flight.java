/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author m.vishnu.priya
 */
package EJBpackage;
public class Flight {  
private String id;  
private String name,source,destination,classs;
private int timing,amount,tid,seats;
public int getSeats(){
    return seats;
}
public void setSeats(int seats){
    this.seats=seats;
}
public int getAmount(){
    return amount;
}
public void setAmount(int amount){
    this.amount=amount;
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
public int getTiming()
{
    return timing;
}
public void setTiming(int timing){
    this.timing=timing;
}
public String getName() {  
    return name;  
}  
public void setName(String name) {  
    this.name = name;  
}  
public String getSource() {  
    return source;  
}  
public void setSource(String source) {  
    this.source = source;  
}  
public String getClasss() {  
    return classs;  
}  
public void setClasss(String classs) {  
    this.classs = classs;  
} 
public void setDestination(String destination)
{
    this.destination=destination;
}
public String getDestination()
{
    return destination;
}
public int calculate(int a,int b){
    return a*b;
}
}
