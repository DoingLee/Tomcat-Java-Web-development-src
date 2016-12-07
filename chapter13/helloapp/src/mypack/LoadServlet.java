
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
     init(); //重新加载资源文件
     PrintWriter out = response.getWriter();
     out.println("The resouce file is reloaded.");

   } 
}




/****************************************************
 * 作者：孙卫琴                                     *
 * 来源：<<Tomcat与Java Web开发技术详解>>           *
 * 技术支持网址：www.javathinker.org                *
 ***************************************************/
