package mypack;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.*;

public class Servlet3 extends GenericServlet {

   /** ��Ӧ�ͻ�����*/
  public void service(ServletRequest request,ServletResponse response)
    throws ServletException, IOException {
    
    //��ȡ���������Χ�ڵ�num1,num2��sum
    Integer num1 =(Integer)request.getAttribute("num1");
    Integer num2 =(Integer)request.getAttribute("num2");
    Integer sum =(Integer)request.getAttribute("sum");
    PrintWriter out=response.getWriter();

    out.println(num1+"+"+num2+"="+sum); 
    out.close();
  }
}




/****************************************************
 * ���ߣ�������                                     *
 * ��Դ��<<Tomcat��Java Web�����������>>           *
 * ����֧����ַ��www.javathinker.org                *
 ***************************************************/
