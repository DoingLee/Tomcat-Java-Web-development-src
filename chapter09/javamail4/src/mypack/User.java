package mypack;
import javax.servlet.http.*;
import java.io.Serializable;
                          
public class User implements HttpSessionBindingListener,Serializable{
  private OnlineUsers onlineUsers=OnlineUsers.getInstance();
  private String name=null;

  public User(String name){
    this.name=name;
  }
  
  public void setName(String name){
    this.name=name;
  }
   
  public String getName(){
    return name;
  }
  
  public void valueBound(HttpSessionBindingEvent event){
    onlineUsers.add(name);
    System.out.println(name+" is bound with a session");
  }

  public void valueUnbound(HttpSessionBindingEvent event){
    onlineUsers.remove(name); 
    System.out.println(name+" is unbound with a session");
  }
}



/****************************************************
 * ���ߣ�������                                     *
 * ��Դ��<<Tomcat��Java Web�����������>>           *
 * ����֧����ַ��www.javathinker.org                *
 ***************************************************/
