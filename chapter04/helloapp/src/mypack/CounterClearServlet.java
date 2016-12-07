package mypack;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class CounterClearServlet extends HttpServlet {
  public void doGet(HttpServletRequest request,
    HttpServletResponse response)throws ServletException, IOException {

    //获得ServletContext的引用
    ServletContext context = getServletContext();

    context.removeAttribute("counter");  //删除counter属性
  
    PrintWriter out=response.getWriter();
    out.println("The counter is removed.");
    out.close();
  }
}




/****************************************************
 * 作者：孙卫琴                                     *
 * 来源：<<Tomcat与Java Web开发技术详解>>           *
 * 技术支持网址：www.javathinker.org                *
 ***************************************************/
