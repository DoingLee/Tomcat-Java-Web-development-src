package mypack;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.*;

import org.apache.log4j.PropertyConfigurator;

public class Log4JServlet extends HttpServlet {

  public void init()
    throws ServletException {

    // ��ȡ�����ļ�������·��
    String path = getServletContext().getRealPath("/");
    String propfile = path + getInitParameter("propfile");

    // ��ʼ��Log4J
    PropertyConfigurator.configure(propfile);
  }

}





/****************************************************
 * ���ߣ�������                                     *
 * ��Դ��<<Tomcat��Java Web�����������>>           *
 * ����֧����ַ��www.javathinker.org                *
 ***************************************************/
