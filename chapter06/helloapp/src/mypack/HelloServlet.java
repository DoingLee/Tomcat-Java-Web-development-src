package mypack;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

public class HelloServlet extends HttpServlet {
  /** ��Ӧ�ͻ�����*/
  public void doGet(HttpServletRequest request,HttpServletResponse response)
    throws ServletException, IOException {

    //���username������� 
    String username=request.getParameter("username");
  
    /*���HTML�ĵ�*/
    PrintWriter out = response.getWriter();
    out.println("<html><head><title>helloApp</TITLE></head>");
    out.println("<body>");
    out.println("<b>Hello,"+username+"</b>");
    out.println("</body></html>");
     
    out.close(); //�ر�PrintWriter

  }
}




/****************************************************
 * ���ߣ�������                                     *
 * ��Դ��<<Tomcat��Java Web�����������>>           *
 * ����֧����ַ��www.javathinker.org                *
 ***************************************************/
