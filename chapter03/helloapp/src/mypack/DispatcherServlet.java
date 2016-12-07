package mypack;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.*;

public class DispatcherServlet extends GenericServlet {

  private String target = "/hello.jsp";

  /** 响应客户请求*/
  public void service(ServletRequest request,ServletResponse response)
    throws ServletException, IOException {

    //读取表单中的用户名
    String username = request.getParameter("username");
    //读取表单中的口令
    String password = request.getParameter("password");

    //在request对象中添加USER属性
    request.setAttribute("USER", username);
    //在request对象中添加PASSWORD属性
    request.setAttribute("PASSWORD", password);

    /*把请求转发给hello.jsp */
    ServletContext context = getServletContext();
    RequestDispatcher dispatcher =context.getRequestDispatcher(target);
    dispatcher.forward(request, response);
  }
}




/****************************************************
 * 作者：孙卫琴                                     *
 * 来源：<<Tomcat与Java Web开发技术详解>>           *
 * 技术支持网址：www.javathinker.org                *
 ***************************************************/
