package mypack;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class RequestFilter implements Filter {

  public void init(FilterConfig config) throws ServletException {}

  public void doFilter(ServletRequest request, ServletResponse response,
                     FilterChain chain) throws IOException, ServletException {
    MyRequestWrapper requestWrapper=new MyRequestWrapper((HttpServletRequest)request);
    chain.doFilter(requestWrapper, response);
  }
  public void destroy() {}
}




/****************************************************
 * 作者：孙卫琴                                     *
 * 来源：<<Tomcat与Java Web开发技术详解>>           *
 * 技术支持网址：www.javathinker.org                *
 ***************************************************/
