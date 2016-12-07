package mypack;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.*;

public class Servlet1 extends GenericServlet {

   /** 响应客户请求*/
  public void service(ServletRequest request,ServletResponse response)
    throws ServletException, IOException {

    PrintWriter out=response.getWriter();
 
    //读取num1和num2
    String num1Str = request.getParameter("num1");
    String num2Str = request.getParameter("num2");
    if(num1Str==null || num2Str==null){
      out.println("Please input num1 and num2.");
      return;
    }

    Integer num1=null;
    Integer num2=null;
    try{
      num1=new Integer(num1Str);
      num2=new Integer(num2Str);
    }catch(NumberFormatException e){
      out.println("The num1 and num2 must be numeric.");
      return;
    }
 
    //在request对象中添加num1和num2属性
    request.setAttribute("num1", num1);
    request.setAttribute("num2", num2);
 
    /*把请求转发给Servlet2 */
    ServletContext context = getServletContext();
    RequestDispatcher dispatcher =context.getRequestDispatcher("/servlet2");  
    dispatcher.forward(request, response);
  }
}




/****************************************************
 * 作者：孙卫琴                                     *
 * 来源：<<Tomcat与Java Web开发技术详解>>           *
 * 技术支持网址：www.javathinker.org                *
 ***************************************************/
