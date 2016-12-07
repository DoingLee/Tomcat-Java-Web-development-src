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
    
    //创建由Servlet容器提供的ServletResponse对象的包装类对象
    ReplaceTextWrapper myWrappedResp= 
              new ReplaceTextWrapper( response,searchStr, replaceStr);
    config.getServletContext().log("ReplaceTextFilter:before call chain.doFilter()");

    //把ServletResponse对象的包装类对象传给后续Web组件
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
 * 作者：孙卫琴                                     *
 * 来源：<<Tomcat与Java Web开发技术详解>>           *
 * 技术支持网址：www.javathinker.org                *
 ***************************************************/
