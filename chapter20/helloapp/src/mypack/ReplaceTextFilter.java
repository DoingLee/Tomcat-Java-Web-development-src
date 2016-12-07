package mypack;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class ReplaceTextFilter implements Filter {
  private FilterConfig config = null;
  private String searchStr=null;
  private String replaceStr=null;

  public void init(FilterConfig config) throws ServletException {
    System.out.println("ReplaceTextFilter:init()");

    this.config = config;
    searchStr=config.getInitParameter("search");
    replaceStr=config.getInitParameter("replace");
  }

  public void doFilter(ServletRequest request, ServletResponse response,
                     FilterChain chain) throws IOException, ServletException {
    System.out.println("ReplaceTextFilter:doFilter()");
    
    //������Servlet�����ṩ��ServletResponse����İ�װ�����
    ReplaceTextWrapper myWrappedResp= 
              new ReplaceTextWrapper( response,searchStr, replaceStr);
    config.getServletContext().log("ReplaceTextFilter:before call chain.doFilter()");

    //��ServletResponse����İ�װ����󴫸�����Web���
    chain.doFilter(request,  myWrappedResp);

    config.getServletContext().log("ReplaceTextFilter:after call chain.doFilter()");
    myWrappedResp.getOutputStream().close();
  }

  public void destroy() {
    System.out.println("ReplaceTextFilter:destroy()");
    config = null;
  }
}




/****************************************************
 * ���ߣ�������                                     *
 * ��Դ��<<Tomcat��Java Web�����������>>           *
 * ����֧����ַ��www.javathinker.org                *
 ***************************************************/
