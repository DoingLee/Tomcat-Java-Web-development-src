package mypack;
import javax.servlet.*; 
import javax.servlet.http.*; 

public class MySessionLifeListener implements HttpSessionListener,HttpSessionAttributeListener{ 
  public void sessionCreated(HttpSessionEvent event) { 
    System.out.println("A new session is created.");
  } 

  public void sessionDestroyed(HttpSessionEvent event) { 
    System.out.println("A new session is to be destroyed.");
  } 
  

  public void attributeAdded(HttpSessionBindingEvent event){
    System.out.println("Attribute("+event.getName()+"/"+event.getValue()+") is added into a session.");
  } 
   
  public void attributeRemoved(HttpSessionBindingEvent event){
    System.out.println("Attribute("+event.getName()+"/"+event.getValue()+") is removed from a session.");
  } 
   
  public void attributeReplaced(HttpSessionBindingEvent event){
    System.out.println("Attribute("+event.getName()+"/"+event.getValue()+") is replaced in a session.");
  } 

} 



/****************************************************
 * 作者：孙卫琴                                     *
 * 来源：<<Tomcat与Java Web开发技术详解>>           *
 * 技术支持网址：www.javathinker.org                *
 ***************************************************/
