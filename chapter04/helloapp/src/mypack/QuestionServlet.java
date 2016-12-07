package mypack;
import java.io.*;
import javax.servlet.*;

public class QuestionServlet extends GenericServlet{
   
  public void init (ServletConfig config)throws ServletException{
    System.out.println("Servlet is initialized");
  }
  public void service(ServletRequest request,
		ServletResponse response)
		throws IOException ,ServletException{
    
    //������init(ServletConfig config)������û�е���super.init(config)������
    //����޷��õ�ServletContext����
    ServletContext context=getServletContext();

    PrintWriter out = response.getWriter();
    //contextΪnull����˻��׳�NullPointerException
    out.println(context.getServerInfo()); 
    out.close();
  }
}




/****************************************************
 * ���ߣ�������                                     *
 * ��Դ��<<Tomcat��Java Web�����������>>           *
 * ����֧����ַ��www.javathinker.org                *
 ***************************************************/
