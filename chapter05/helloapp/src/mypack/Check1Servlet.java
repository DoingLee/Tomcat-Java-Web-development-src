package mypack;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.*;

public class Check1Servlet extends HttpServlet {

   /** ��Ӧ�ͻ�����*/
  public void doGet(HttpServletRequest request,HttpServletResponse response)
    throws ServletException, IOException {
    
    PrintWriter out=response.getWriter();

    //��ȡ�û���
    String username = request.getParameter("username");
    String message=null;
    if(username==null){
      message="Please input username.";
    }else{
      message="Hello,"+username;
    }

    //��request���������msg����
    request.setAttribute("msg", message);

    out.println("Output from Check1Servlet before redirecting."); 
    System.out.println("Output from Check1Servlet before redirecting.");

    response.sendRedirect("/helloapp/output1?msg="+message); //ok
    //response.sendRedirect("/output1?msg="+message"); //wrong
   // response.sendRedirect("http://localhost:8080/helloapp/output1?msg="+message); //ok
   //response.sendRedirect("http://www.javathinker.org"); //ok


    out.println("Output from Check1Servlet after redirecting."); 
    System.out.println("Output from Check1Servlet after redirecting.");
  }
}




/****************************************************
 * ���ߣ�������                                     *
 * ��Դ��<<Tomcat��Java Web�����������>>           *
 * ����֧����ַ��www.javathinker.org                *
 ***************************************************/
