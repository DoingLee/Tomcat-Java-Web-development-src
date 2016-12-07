package mypack;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class CounterServlet extends HttpServlet {
  public void doGet(HttpServletRequest request,
    HttpServletResponse response)throws ServletException, IOException {

    //获得ServletContext的引用
    ServletContext context = getServletContext();

    // 从ServletContext中读取counter属性
    Counter counter = (Counter)context.getAttribute("counter");

    // 如果ServletContext中没有counter属性，就创建counter属性
    if ( counter == null ) {
      counter = new Counter(1);
      context.setAttribute("counter", counter);
    }
    
    response.setContentType("text/html;charset=GB2312");
    PrintWriter out = response.getWriter();
    out.println("<html><head><title>CounterServlet</TITLE></head>");
    out.println("<body>");
    // 输出当前的counter属性
    out.println("<h1>欢迎光临本站。您是第 " + counter.getCount()+" 位访问者。</h1>");
    out.println("</body></html>");
  
    //将计数器递增1   
    counter.add(1);
    out.close();
  }
}




/****************************************************
 * 作者：孙卫琴                                     *
 * 来源：<<Tomcat与Java Web开发技术详解>>           *
 * 技术支持网址：www.javathinker.org                *
 ***************************************************/
