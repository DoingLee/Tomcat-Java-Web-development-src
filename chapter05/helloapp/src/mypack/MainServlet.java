package mypack;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.*;

public class MainServlet extends HttpServlet {

  public void doGet(HttpServletRequest request,HttpServletResponse response)
         throws ServletException, IOException {
    //设置HTTP响应的正文的数据类型
    response.setContentType("text/html");
    
    /*输出HTML文档*/
    PrintWriter out = response.getWriter();
    out.println("<html><head><title>MainServlet</TITLE></head>");
    out.println("<body>");

    ServletContext context = getServletContext();
    RequestDispatcher headDispatcher =context.getRequestDispatcher("/header.htm");  
    RequestDispatcher greetDispatcher =context.getRequestDispatcher("/greet");  
    RequestDispatcher footerDispatcher =context.getRequestDispatcher("/footer.htm");  
    
    //包含header.htm   
    headDispatcher.include(request,response);
    //包含GreetServlet输出的HTML文档
    greetDispatcher.include(request,response);
    //包含footer.htm
    footerDispatcher.include(request,response);

    out.println("</body></html>");

    //关闭输出流
    out.close();
  }
}




/****************************************************
 * 作者：孙卫琴                                     *
 * 来源：<<Tomcat与Java Web开发技术详解>>           *
 * 技术支持网址：www.javathinker.org                *
 ***************************************************/
