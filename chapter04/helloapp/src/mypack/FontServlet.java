package mypack;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

public class FontServlet extends HttpServlet {
  /** ��Ӧ�ͻ�����*/
  public void doGet(HttpServletRequest request,HttpServletResponse response)
    throws ServletException, IOException {
    //���word������� 
    String word=request.getParameter("word");
    if(word==null)word="Hello";
    
    //��ȡ��ʼ������
    String color=getInitParameter("color");
    String size=getInitParameter("size");
    System.out.println("servletName: "+getServletName());

    //����HTTP��Ӧ�����ĵ�MIME���ͼ��ַ�����
    response.setContentType("text/html;charset=GB2312");
   
    /*���HTML�ĵ�*/
    PrintWriter out = response.getWriter();
    out.println("<html><head><title>FontServlet</TITLE></head>");
    out.println("<body>");
    out.println("<font size='"+size+"' color='"+color+"'>"+word+"</font>");
    out.println("</body></html>");
     
    out.close(); //�ر�PrintWriter
  }
}





/****************************************************
 * ���ߣ�������                                     *
 * ��Դ��<<Tomcat��Java Web�����������>>           *
 * ����֧����ַ��www.javathinker.org                *
 ***************************************************/
