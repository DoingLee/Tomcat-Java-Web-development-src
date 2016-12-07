
package mypack;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;

public class DispatcherServlet extends HttpServlet {
   public void doGet(HttpServletRequest request, HttpServletResponse response) {
      request.setAttribute("selectedScreen", request.getServletPath().substring(1));
      try {
         request.getRequestDispatcher("/template.jsp").forward(request, response);
      } catch(Exception ex) {
         ex.printStackTrace();
      }
   }
 
   public void doPost(HttpServletRequest request, HttpServletResponse response) {
      doGet(request,response);
   }
}




/****************************************************
 * 作者：孙卫琴                                     *
 * 来源：<<Tomcat与Java Web开发技术详解>>           *
 * 技术支持网址：www.javathinker.org                *
 ***************************************************/
