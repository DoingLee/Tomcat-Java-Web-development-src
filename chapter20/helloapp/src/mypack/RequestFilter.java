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
 * ���ߣ�������                                     *
 * ��Դ��<<Tomcat��Java Web�����������>>           *
 * ����֧����ַ��www.javathinker.org                *
 ***************************************************/
