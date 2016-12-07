package mypack;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

public class Cookie1Servlet extends HttpServlet {
  public void doGet(HttpServletRequest request,HttpServletResponse response)
    throws ServletException, IOException {
    
    Cookie cookie=null;

    response.setContentType("text/plain");
    PrintWriter out=response.getWriter();

    //���HTTP�����е�����Cookie
    Cookie[] cookies=request.getCookies();
    if(cookies!=null){
      //����ÿ��Cookie
      for(int i = 0; i < cookies.length; i++){
        out.println("Cookie name:"+cookies[i].getName());
        out.println("Cookie value:"+cookies[i].getValue());
        if(cookies[i].getName().equals("username"))
          cookie=cookies[i];
      }
    }else{
      out.println("No cookie.");
    } 
    
    if(cookie==null){ 
      //��ͻ���дһ���µ�Cookie
      cookie=new Cookie("username", "Tom");
      cookie.setMaxAge(60*60); //����1Сʱ
      response.addCookie(cookie);
    }else if(cookie.getValue().equals("Tom")){
      //�޸�Cookie
      cookie.setValue("Jack");
      response.addCookie(cookie);
    }else if(cookie.getValue().equals("Jack")){
      //ɾ��Cookie
      cookie.setMaxAge(0);
      response.addCookie(cookie);
    }
  }
}




/****************************************************
 * ���ߣ�������                                     *
 * ��Դ��<<Tomcat��Java Web�����������>>           *
 * ����֧����ַ��www.javathinker.org                *
 ***************************************************/
