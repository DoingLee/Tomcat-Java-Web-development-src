package mypack;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.*;

public class GreetServlet extends HttpServlet {
  public void doGet(HttpServletRequest request,HttpServletResponse response)
         throws ServletException, IOException {
    
    /*输出HTML文档*/
    PrintWriter out = response.getWriter();
    out.println("Hi,"+request.getParameter("username")+"<p>");
   }
}




/****************************************************
 * 作者：孙卫琴                                     *
 * 来源：<<Tomcat与Java Web开发技术详解>>           *
 * 技术支持网址：www.javathinker.org                *
 ***************************************************/
