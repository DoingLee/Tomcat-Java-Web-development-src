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
    
    /*字符编码转换。HTTP请求的默认字符编码为ISO-8859-1，如果请求中包含中文，需要把
    它转换为GB2312中文编码。*/
    if(username!=null)
      username=new String(username.getBytes("ISO-8859-1"),"GB2312");
          
    if(username==null){
      //仅仅为了演示response.sendError()的用法。
      response.sendError(response.SC_FORBIDDEN);
      return;
    }

    //设置HTTP响应的正文的MIME类型及字符编码
    response.setContentType("text/html;charset=GB2312");
   
    /*输出HTML文档*/
    PrintWriter out = response.getWriter();
    out.println("<html><head><title>HelloServlet</TITLE></head>");
    out.println("<body>");
    out.println("你好: "+username);
    out.println("</body></html>");
     
    System.out.println("before close():"+response.isCommitted()); //false
    out.close(); //关闭PrintWriter
    System.out.println("after close():"+response.isCommitted());  //true
  }
}




/****************************************************
 * 作者：孙卫琴                                     *
 * 来源：<<Tomcat与Java Web开发技术详解>>           *
 * 技术支持网址：www.javathinker.org                *
 ***************************************************/
