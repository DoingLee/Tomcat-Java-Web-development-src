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
    
    //��ù���Ŀ¼����
    File workDir=(File)context.getAttribute("javax.servlet.context.tempdir");
    //�ڹ���Ŀ¼������һ���ļ�
    FileOutputStream fileOut=new FileOutputStream(workDir+"/temp.txt");
    fileOut.write("Hello World".getBytes());  
    fileOut.close();
  }
}




/****************************************************
 * ���ߣ�������                                     *
 * ��Դ��<<Tomcat��Java Web�����������>>           *
 * ����֧����ַ��www.javathinker.org                *
 ***************************************************/
