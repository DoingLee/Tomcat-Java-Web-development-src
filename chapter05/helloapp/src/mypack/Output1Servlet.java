package mypack;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.*;

public class Output1Servlet extends HttpServlet {

   /** ��Ӧ�ͻ�����*/
  public void doGet(HttpServletRequest request,HttpServletResponse response)
    throws ServletException, IOException {

    //��ȡCheck1Servlet���������Χ�ڵ���Ϣ
    String message = (String)request.getAttribute("msg");
    System.out.println("����Χ�ڵ���Ϣ:"+message);
    message=request.getParameter("msg");
    System.out.println("��������е���Ϣ:"+message);
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
