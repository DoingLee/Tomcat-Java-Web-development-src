package mypack;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.*;

public class Servlet2 extends GenericServlet {

   /** ��Ӧ�ͻ�����*/
  public void service(ServletRequest request,ServletResponse response)
    throws ServletException, IOException {

    //��ȡ���������Χ�ڵ�num1��num2
    Integer num1 =(Integer)request.getAttribute("num1");
    Integer num2 =(Integer)request.getAttribute("num2");
    Integer sum=num1+num2;
    //������Χ�ڴ��sum
    request.setAttribute("sum",sum);

    /*������ת����Servlet3 */
    ServletContext context = getServletContext();
    RequestDispatcher dispatcher =context.getRequestDispatcher("/servlet3");  
    dispatcher.forward(request, response);

  }
}




/****************************************************
 * ���ߣ�������                                     *
 * ��Դ��<<Tomcat��Java Web�����������>>           *
 * ����֧����ַ��www.javathinker.org                *
 ***************************************************/
