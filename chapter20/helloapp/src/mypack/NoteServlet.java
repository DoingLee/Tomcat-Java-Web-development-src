package mypack;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.*;

public class NoteServlet extends HttpServlet {

  public void service(HttpServletRequest request, HttpServletResponse response) 
              throws ServletException, IOException {
    System.out.println("NoteServlet: service()"); 
    
    response.setContentType("text/html; charset=GB2312");
    ServletOutputStream out = response.getOutputStream();

    out.println("<html>");
    out.println("<head><title>留言薄</title></head>");
    out.println("<body>");

    String username=request.getParameter("username");
    String content=request.getParameter("content");
    if(username!=null)
      username=new String(username.getBytes("ISO-8859-1"),"GB2312");
    if(content!=null)
      content=new String(content.getBytes("ISO-8859-1"),"GB2312");

    if(content!=null && !content.equals(""))
      out.println("<p>"+username+"的留言为："+content+"</p>");

    out.println("<form action="+request.getContextPath()
                 +"/note method=POST>");

    out.println("<b>姓名:</b>");
    out.println("<input type=text size=10 name=username><br>");
    out.println("<b>留言:</b><br>");
    out.println("<textarea name=content rows=5 cols=20></textarea><br><br>");
    out.println("<input type=submit  value=提交>");
    out.println("</form>");
    out.println("</body></html>");
  }
}




/****************************************************
 * 作者：孙卫琴                                     *
 * 来源：<<Tomcat与Java Web开发技术详解>>           *
 * 技术支持网址：www.javathinker.org                *
 ***************************************************/
