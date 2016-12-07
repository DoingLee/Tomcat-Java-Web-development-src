package mypack;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.*;

public class CheckServlet extends GenericServlet {

   /** ��Ӧ�ͻ�����*/
  public void service(ServletRequest request,ServletResponse response)
    throws ServletException, IOException {

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
 
    /*������ת����OutputServlet */
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
 * ���ߣ�������                                     *
 * ��Դ��<<Tomcat��Java Web�����������>>           *
 * ����֧����ַ��www.javathinker.org                *
 ***************************************************/
