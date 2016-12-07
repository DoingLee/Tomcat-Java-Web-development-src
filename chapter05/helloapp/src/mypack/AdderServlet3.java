package mypack;

import javax.servlet.*;
import java.io.*;

public class AdderServlet3 extends GenericServlet implements SingleThreadModel{
  private int sum=100;  //sum为实例变量
  
  /** 响应客户请求*/
  public void service(ServletRequest request,ServletResponse response)
    throws ServletException, IOException {
    
    //获得increase请求参数 
    int increase=Integer.parseInt(request.getParameter("increase"));
      
    //设置HTTP响应的正文的MIME类型及字符编码
    response.setContentType("text/html;charset=GB2312");
   
    /*输出HTML文档*/
    PrintWriter out = response.getWriter();
    out.println("<html><head><title>AdderServlet</TITLE></head>");
    out.println("<body>");
    out.println(sum+"+"+increase+"=");
 
    try{
      Thread.sleep(3000); //特意延长响应客户请求的时间
    }catch(Exception e){e.printStackTrace();}

    sum+=increase;
    out.println(sum);
    out.println("</body></html>");
     
    out.close(); //关闭PrintWriter
   }
}




/****************************************************
 * 作者：孙卫琴                                     *
 * 来源：<<Tomcat与Java Web开发技术详解>>           *
 * 技术支持网址：www.javathinker.org                *
 ***************************************************/
