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
 * ���ߣ�������                                     *
 * ��Դ��<<Tomcat��Java Web�����������>>           *
 * ����֧����ַ��www.javathinker.org                *
 ***************************************************/
