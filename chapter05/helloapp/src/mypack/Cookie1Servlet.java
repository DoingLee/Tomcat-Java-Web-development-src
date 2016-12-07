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

    //获得HTTP请求中的所有Cookie
    Cookie[] cookies=request.getCookies();
    if(cookies!=null){
      //访问每个Cookie
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
      //向客户端写一个新的Cookie
      cookie=new Cookie("username", "Tom");
      cookie.setMaxAge(60*60); //保存1小时
      response.addCookie(cookie);
    }else if(cookie.getValue().equals("Tom")){
      //修改Cookie
      cookie.setValue("Jack");
      response.addCookie(cookie);
    }else if(cookie.getValue().equals("Jack")){
      //删除Cookie
      cookie.setMaxAge(0);
      response.addCookie(cookie);
    }
  }
}




/****************************************************
 * 作者：孙卫琴                                     *
 * 来源：<<Tomcat与Java Web开发技术详解>>           *
 * 技术支持网址：www.javathinker.org                *
 ***************************************************/
