package mypack;

import javax.servlet.*;
import java.io.*;

public class AdderServlet3 extends GenericServlet implements SingleThreadModel{
  private int sum=100;  //sumΪʵ������
  
  /** ��Ӧ�ͻ�����*/
  public void service(ServletRequest request,ServletResponse response)
    throws ServletException, IOException {
    
    //���increase������� 
    int increase=Integer.parseInt(request.getParameter("increase"));
      
    //����HTTP��Ӧ�����ĵ�MIME���ͼ��ַ�����
    response.setContentType("text/html;charset=GB2312");
   
    /*���HTML�ĵ�*/
    PrintWriter out = response.getWriter();
    out.println("<html><head><title>AdderServlet</TITLE></head>");
    out.println("<body>");
    out.println(sum+"+"+increase+"=");
 
    try{
      Thread.sleep(3000); //�����ӳ���Ӧ�ͻ������ʱ��
    }catch(Exception e){e.printStackTrace();}

    sum+=increase;
    out.println(sum);
    out.println("</body></html>");
     
    out.close(); //�ر�PrintWriter
   }
}




/****************************************************
 * ���ߣ�������                                     *
 * ��Դ��<<Tomcat��Java Web�����������>>           *
 * ����֧����ַ��www.javathinker.org                *
 ***************************************************/
