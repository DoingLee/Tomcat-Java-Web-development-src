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
    
    //由于在init(ServletConfig config)方法中没有调用super.init(config)方法，
    //因此无法得到ServletContext对象。
    ServletContext context=getServletContext();

    PrintWriter out = response.getWriter();
    //context为null，因此会抛出NullPointerException
    out.println(context.getServerInfo()); 
    out.close();
  }
}




/****************************************************
 * 作者：孙卫琴                                     *
 * 来源：<<Tomcat与Java Web开发技术详解>>           *
 * 技术支持网址：www.javathinker.org                *
 ***************************************************/
