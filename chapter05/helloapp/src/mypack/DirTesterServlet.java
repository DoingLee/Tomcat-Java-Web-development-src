package mypack;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.*;

public class DirTesterServlet extends HttpServlet {
  public void doGet(HttpServletRequest request,HttpServletResponse response)
         throws ServletException, IOException {
    ServletContext context=getServletContext();
    
    response.setContentType("text/html;charset=GB2312");
    PrintWriter out = response.getWriter();
    Enumeration eu=context.getAttributeNames();
    while(eu.hasMoreElements()){
      String attributeName=(String)eu.nextElement();
      out.println("<br>"+attributeName+": "+context.getAttribute(attributeName));
    }
    out.close();
    
    //获得工作目录属性
    File workDir=(File)context.getAttribute("javax.servlet.context.tempdir");
    //在工作目录下生成一个文件
    FileOutputStream fileOut=new FileOutputStream(workDir+"/temp.txt");
    fileOut.write("Hello World".getBytes());  
    fileOut.close();
  }
}




/****************************************************
 * 作者：孙卫琴                                     *
 * 来源：<<Tomcat与Java Web开发技术详解>>           *
 * 技术支持网址：www.javathinker.org                *
 ***************************************************/
