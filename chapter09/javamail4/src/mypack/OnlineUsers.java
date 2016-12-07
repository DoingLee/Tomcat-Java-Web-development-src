package mypack;
import java.util.*;

public class OnlineUsers{
  private static final OnlineUsers onlineUsers=new OnlineUsers();
  private List<String> users=new ArrayList<String>();

  public void add(String name){
    users.add(name);
  }
  
  public void remove(String name){
    users.remove(name);
  }

  public List getUsers(){
    return users;
  }
  
  public int getCount(){
    return users.size();
  }
  public static OnlineUsers getInstance(){
    return onlineUsers; 
  }
}



/****************************************************
 * ���ߣ�������                                     *
 * ��Դ��<<Tomcat��Java Web�����������>>           *
 * ����֧����ַ��www.javathinker.org                *
 ***************************************************/
