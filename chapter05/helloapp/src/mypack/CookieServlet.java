package mypack;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

public class CookieServlet extends HttpServlet {
  int count=0;

  public void doGet(HttpServletRequest request,HttpServletResponse response)
    throws ServletException, IOException {
    
    response.setContentType("text/plain");
    PrintWriter out=response.getWriter();
    //���HTTP�����е�����Cookie
    Cookie[] cookies=request.getCookies();
    if(cookies!=null){
      //����ÿ��Cookie
      for(int i = 0; i < cookies.length; i++){
        out.println("Cookie name:"+cookies[i].getName());
        out.println("Cookie value:"+cookies[i].getValue());
        out.println("Max Age:"+cookies[i].getMaxAge()+"\r\n");
      }
    }else{
      out.println("No cookie.");
    } 
 
    //��ͻ���дһ��Cookie
    response.addCookie(new Cookie(
            "cookieName" + count, "cookieValue" + count));
    count++;
  }
}




/****************************************************
 * ���ߣ�������                                     *
 * ��Դ��<<Tomcat��Java Web�����������>>           *
 * ����֧����ַ��www.javathinker.org                *
 ***************************************************/
