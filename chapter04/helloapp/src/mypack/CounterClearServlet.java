package mypack;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class CounterClearServlet extends HttpServlet {
  public void doGet(HttpServletRequest request,
    HttpServletResponse response)throws ServletException, IOException {

    //���ServletContext������
    ServletContext context = getServletContext();

    context.removeAttribute("counter");  //ɾ��counter����
  
    PrintWriter out=response.getWriter();
    out.println("The counter is removed.");
    out.close();
  }
}




/****************************************************
 * ���ߣ�������                                     *
 * ��Դ��<<Tomcat��Java Web�����������>>           *
 * ����֧����ַ��www.javathinker.org                *
 ***************************************************/
