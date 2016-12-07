package mypack;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.*;

public class Output1Servlet extends HttpServlet {

   /** 响应客户请求*/
  public void doGet(HttpServletRequest request,HttpServletResponse response)
    throws ServletException, IOException {

    //读取Check1Servlet存放在请求范围内的消息
    String message = (String)request.getAttribute("msg");
    System.out.println("请求范围内的消息:"+message);
    message=request.getParameter("msg");
    System.out.println("请求参数中的消息:"+message);
    PrintWriter out=response.getWriter();

    out.println(message); 
    out.close();
  }
}




/****************************************************
 * 作者：孙卫琴                                     *
 * 来源：<<Tomcat与Java Web开发技术详解>>           *
 * 技术支持网址：www.javathinker.org                *
 ***************************************************/
