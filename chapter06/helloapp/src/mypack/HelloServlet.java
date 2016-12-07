package mypack;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

public class HelloServlet extends HttpServlet {
  /** 响应客户请求*/
  public void doGet(HttpServletRequest request,HttpServletResponse response)
    throws ServletException, IOException {

    //获得username请求参数 
    String username=request.getParameter("username");
  
    /*输出HTML文档*/
    PrintWriter out = response.getWriter();
    out.println("<html><head><title>helloApp</TITLE></head>");
    out.println("<body>");
    out.println("<b>Hello,"+username+"</b>");
    out.println("</body></html>");
     
    out.close(); //关闭PrintWriter

  }
}




/****************************************************
 * 作者：孙卫琴                                     *
 * 来源：<<Tomcat与Java Web开发技术详解>>           *
 * 技术支持网址：www.javathinker.org                *
 ***************************************************/
