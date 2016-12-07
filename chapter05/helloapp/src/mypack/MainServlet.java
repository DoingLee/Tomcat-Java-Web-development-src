package mypack;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.*;

public class MainServlet extends HttpServlet {

  public void doGet(HttpServletRequest request,HttpServletResponse response)
         throws ServletException, IOException {
    //����HTTP��Ӧ�����ĵ���������
    response.setContentType("text/html");
    
    /*���HTML�ĵ�*/
    PrintWriter out = response.getWriter();
    out.println("<html><head><title>MainServlet</TITLE></head>");
    out.println("<body>");

    ServletContext context = getServletContext();
    RequestDispatcher headDispatcher =context.getRequestDispatcher("/header.htm");  
    RequestDispatcher greetDispatcher =context.getRequestDispatcher("/greet");  
    RequestDispatcher footerDispatcher =context.getRequestDispatcher("/footer.htm");  
    
    //����header.htm   
    headDispatcher.include(request,response);
    //����GreetServlet�����HTML�ĵ�
    greetDispatcher.include(request,response);
    //����footer.htm
    footerDispatcher.include(request,response);

    out.println("</body></html>");

    //�ر������
    out.close();
  }
}




/****************************************************
 * ���ߣ�������                                     *
 * ��Դ��<<Tomcat��Java Web�����������>>           *
 * ����֧����ַ��www.javathinker.org                *
 ***************************************************/
