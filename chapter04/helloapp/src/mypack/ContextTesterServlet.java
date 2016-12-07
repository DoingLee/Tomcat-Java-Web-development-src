package mypack;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

public class ContextTesterServlet extends HttpServlet {
  /** ��Ӧ�ͻ�����*/
  public void doGet(HttpServletRequest request,HttpServletResponse response)
    throws ServletException, IOException {
    ServletContext context=getServletContext(); 

    //����HTTP��Ӧ�����ĵ�MIME���ͼ��ַ�����
    response.setContentType("text/html;charset=GB2312");
   
    /*���HTML�ĵ�*/
    PrintWriter out = response.getWriter();
    out.println("<html><head><title>FontServlet</TITLE></head>");
    out.println("<body>");
    out.println("<br>Email: "+context.getInitParameter("emailOfwebmaster"));
    out.println("<br>Path: "+context.getRealPath("/WEB-INF"));
    out.println("<br>MimeType: "+context.getMimeType("/WEB-INF/web.xml"));
    out.println("<br>MajorVersion: "+context.getMajorVersion()); 
    out.println("<br>ServerInfo: "+context.getServerInfo()); 
    out.println("</body></html>");
    
    //�����־
    context.log("����ContextTesterServlet�������־��"); 
    out.close(); //�ر�PrintWriter
  }
}





/****************************************************
 * ���ߣ�������                                     *
 * ��Դ��<<Tomcat��Java Web�����������>>           *
 * ����֧����ַ��www.javathinker.org                *
 ***************************************************/
