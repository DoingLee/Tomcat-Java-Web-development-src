package mypack;
import javax.servlet.http.*;
import java.io.Serializable;
                          
public class MyData implements HttpSessionBindingListener,HttpSessionActivationListener,Serializable{
  private int data;

  public MyData(){}

  public MyData(int data){
    this.data=data;
  }
  
  public int getData(){
    return data;
  }
  
  public void setData(){
    this.data=data;
  }
 
  public void valueBound(HttpSessionBindingEvent event){
    System.out.println("MyData is bound with a session.");
  }

  public void valueUnbound(HttpSessionBindingEvent event){
    System.out.println("MyData is unbound with a session.");
  }

  public void sessionDidActivate(HttpSessionEvent se){
    System.out.println("A session is activate.");
  } 

  public void sessionWillPassivate(HttpSessionEvent se){
    System.out.println("A session will be passivate.");
  }  

}



/****************************************************
 * ���ߣ�������                                     *
 * ��Դ��<<Tomcat��Java Web�����������>>           *
 * ����֧����ַ��www.javathinker.org                *
 ***************************************************/
