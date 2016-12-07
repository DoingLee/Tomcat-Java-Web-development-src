package mypack;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.*;

import org.apache.log4j.PropertyConfigurator;

public class Log4JServlet extends HttpServlet {

  public void init()
    throws ServletException {

    // 获取属性文件的完整路径
    String path = getServletContext().getRealPath("/");
    String propfile = path + getInitParameter("propfile");

    // 初始化Log4J
    PropertyConfigurator.configure(propfile);
  }

}





/****************************************************
 * 作者：孙卫琴                                     *
 * 来源：<<Tomcat与Java Web开发技术详解>>           *
 * 技术支持网址：www.javathinker.org                *
 ***************************************************/
