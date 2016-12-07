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
    //获得HTTP请求中的所有Cookie
    Cookie[] cookies=request.getCookies();
    if(cookies!=null){
      //访问每个Cookie
      for(int i = 0; i < cookies.length; i++){
        out.println("Cookie name:"+cookies[i].getName());
        out.println("Cookie value:"+cookies[i].getValue());
        out.println("Max Age:"+cookies[i].getMaxAge()+"\r\n");
      }
    }else{
      out.println("No cookie.");
    } 
 
    //向客户端写一个Cookie
    response.addCookie(new Cookie(
            "cookieName" + count, "cookieValue" + count));
    count++;
  }
}




/****************************************************
 * 作者：孙卫琴                                     *
 * 来源：<<Tomcat与Java Web开发技术详解>>           *
 * 技术支持网址：www.javathinker.org                *
 ***************************************************/
