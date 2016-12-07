package mypack;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.*;

public class Servlet3 extends GenericServlet {

   /** 响应客户请求*/
  public void service(ServletRequest request,ServletResponse response)
    throws ServletException, IOException {
    
    //读取存放在请求范围内的num1,num2和sum
    Integer num1 =(Integer)request.getAttribute("num1");
    Integer num2 =(Integer)request.getAttribute("num2");
    Integer sum =(Integer)request.getAttribute("sum");
    PrintWriter out=response.getWriter();

    out.println(num1+"+"+num2+"="+sum); 
    out.close();
  }
}




/****************************************************
 * 作者：孙卫琴                                     *
 * 来源：<<Tomcat与Java Web开发技术详解>>           *
 * 技术支持网址：www.javathinker.org                *
 ***************************************************/
