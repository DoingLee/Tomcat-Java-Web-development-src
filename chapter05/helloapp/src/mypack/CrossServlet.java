package mypack;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.*;

public class CrossServlet extends GenericServlet {

   /** 响应客户请求*/
  public void service(ServletRequest request,ServletResponse response)
    throws ServletException, IOException {

    //读取用户名
    String username = request.getParameter("username");
    String message=null;
    if(username==null){
      message="Please input username.";
    }else{
      message="Hello,"+username;
    }
    //在request对象中添加msg属性
    request.setAttribute("msg", message);
 
    /*把请求转发给helloapp1应用中的OutputServlet */
    ServletContext context = getServletContext();
    ServletContext crossContext = context.getContext("/helloapp1");
    RequestDispatcher dispatcher =crossContext.getRequestDispatcher("/output");  //ok
 
    PrintWriter out=response.getWriter();
    dispatcher.forward(request, response);
  }
}




/****************************************************
 * 作者：孙卫琴                                     *
 * 来源：<<Tomcat与Java Web开发技术详解>>           *
 * 技术支持网址：www.javathinker.org                *
 ***************************************************/
