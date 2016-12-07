
package mypack;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.*;

public class LoadServlet extends HttpServlet {

  public void init()throws ServletException {
    
    Properties ps=new Properties();
    Properties ps_ch=new Properties();
    try{
      ServletContext context=getServletContext();
      InputStream in=context.getResourceAsStream("/WEB-INF/messageresource.properties");
      ps.load(in);
      InputStream in_ch=context.getResourceAsStream("/WEB-INF/messageresource_ch.properties");
      ps_ch.load(in_ch);

      in.close();
      in_ch.close();

      context.setAttribute("ps",ps);
      context.setAttribute("ps_ch",ps_ch);
    }catch(Exception e){
      e.printStackTrace();
    }
  }

   public void doGet(HttpServletRequest request,HttpServletResponse response)
         throws ServletException, IOException {
     init(); //���¼�����Դ�ļ�
     PrintWriter out = response.getWriter();
     out.println("The resouce file is reloaded.");

   } 
}




/****************************************************
 * ���ߣ�������                                     *
 * ��Դ��<<Tomcat��Java Web�����������>>           *
 * ����֧����ַ��www.javathinker.org                *
 ***************************************************/
