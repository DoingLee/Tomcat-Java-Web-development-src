package mypack;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

public class ContextTesterServlet extends HttpServlet {
  /** 响应客户请求*/
  public void doGet(HttpServletRequest request,HttpServletResponse response)
    throws ServletException, IOException {
    ServletContext context=getServletContext(); 

    //设置HTTP响应的正文的MIME类型及字符编码
    response.setContentType("text/html;charset=GB2312");
   
    /*输出HTML文档*/
    PrintWriter out = response.getWriter();
    out.println("<html><head><title>FontServlet</TITLE></head>");
    out.println("<body>");
    out.println("<br>Email: "+context.getInitParameter("emailOfwebmaster"));
    out.println("<br>Path: "+context.getRealPath("/WEB-INF"));
    out.println("<br>MimeType: "+context.getMimeType("/WEB-INF/web.xml"));
    out.println("<br>MajorVersion: "+context.getMajorVersion()); 
    out.println("<br>ServerInfo: "+context.getServerInfo()); 
    out.println("</body></html>");
    
    //输出日志
    context.log("这是ContextTesterServlet输出的日志。"); 
    out.close(); //关闭PrintWriter
  }
}





/****************************************************
 * 作者：孙卫琴                                     *
 * 来源：<<Tomcat与Java Web开发技术详解>>           *
 * 技术支持网址：www.javathinker.org                *
 ***************************************************/
