package mypack;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.*;

public class CheckServlet extends GenericServlet {

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
 
    /*把请求转发给OutputServlet */
    ServletContext context = getServletContext();
    RequestDispatcher dispatcher =context.getRequestDispatcher("/output");  //ok
    //RequestDispatcher dispatcher =context.getRequestDispatcher("output"); //wrong
    //RequestDispatcher dispatcher =request.getRequestDispatcher("output"); //ok
 
    PrintWriter out=response.getWriter();

    out.println("Output from CheckServlet before forwarding request."); 
    System.out.println("Output from CheckServlet before forwarding request.");
    
    //out.close(); //throw IllegalArgumentException
    dispatcher.forward(request, response);

    out.println("Output from CheckServlet after forwarding request."); 
    System.out.println("Output from CheckServlet after forwarding request.");
  }
}




/****************************************************
 * 作者：孙卫琴                                     *
 * 来源：<<Tomcat与Java Web开发技术详解>>           *
 * 技术支持网址：www.javathinker.org                *
 ***************************************************/
