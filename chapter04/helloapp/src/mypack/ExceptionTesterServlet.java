package mypack;
import java.io.*;
import javax.servlet.*;

public class ExceptionTesterServlet extends GenericServlet{
  public void service(ServletRequest request,
		ServletResponse response)
		throws IOException,ServletException{
    
    String condition=request.getParameter("condition");
    if(condition==null)condition="ok";

    if(condition.equals("1")){
      throw new ServletException("condition1");
    }else if(condition.equals("2")){
       throw new UnavailableException("condition2",2);
    }else if(condition.equals("3")){
       throw new UnavailableException("condition3");
    }
    PrintWriter out=response.getWriter();
    out.println("It's ok.");
    out.close();
  }
}




/****************************************************
 * ���ߣ�������                                     *
 * ��Դ��<<Tomcat��Java Web�����������>>           *
 * ����֧����ַ��www.javathinker.org                *
 ***************************************************/
