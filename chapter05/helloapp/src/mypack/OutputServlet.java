package mypack;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.*;

public class OutputServlet extends GenericServlet {

   /** ��Ӧ�ͻ�����*/
  public void service(ServletRequest request,ServletResponse response)
    throws ServletException, IOException {

    //��ȡCheckServlet���������Χ�ڵ���Ϣ
    String message = (String)request.getAttribute("msg");
    PrintWriter out=response.getWriter();

    out.println(message); 
    out.close();
  }
}




/****************************************************
 * ���ߣ�������                                     *
 * ��Դ��<<Tomcat��Java Web�����������>>           *
 * ����֧����ַ��www.javathinker.org                *
 ***************************************************/
