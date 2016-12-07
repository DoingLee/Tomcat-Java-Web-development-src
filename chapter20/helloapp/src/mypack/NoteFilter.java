package mypack;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class NoteFilter implements Filter {
  private FilterConfig config = null;
  private String blackList=null;
  private String ipblock=null;

  public void init(FilterConfig config) throws ServletException {
    System.out.println("NoteFilter: init()"); 
    this.config = config;

    //读取拒绝IP地址
    ipblock=config.getInitParameter("ipblock");

    //读取blacklist初始化参数
    blackList=config.getInitParameter("blacklist");
  }

  public void doFilter(ServletRequest request, ServletResponse response,
                     FilterChain chain) throws IOException, ServletException {

    System.out.println("NoteFilter: doFilter()"); 

    if(!checkRemoteIP(request,response))return;
    
    if(!checkUsername(request,response))return;
       
    //记录响应客户请求前的时间
    long before = System.currentTimeMillis();
    config.getServletContext().log("NoteFilter:before call chain.doFilter()");

    //把请求转发给后续的过滤器或者Web组件
    chain.doFilter(request, response);

    //记录响应客户请求后的时间
    config.getServletContext().log("NoteFilter:after call chain.doFilter()");
    long after = System.currentTimeMillis();
    
    String name = "";
    if (request instanceof HttpServletRequest) {
        name = ((HttpServletRequest)request).getRequestURI();
    }
    //记录响应客户请求所花的时间
    config.getServletContext().log("NoteFilter:"+name + ": " + (after - before) + "ms");
  }

  private boolean checkRemoteIP(ServletRequest request, ServletResponse response) 
                        throws IOException, ServletException {
    //读取客户的IP地址
    String addr=request.getRemoteAddr();
    if(addr.indexOf(ipblock)==0){
      response.setContentType("text/html;charset=GB2312");
      PrintWriter out = response.getWriter();
      out.println("<h1>对不起,服务器无法为你提供服务。</h1>");
      out.flush();
      return false;
    }else{
      return true;
    }
  }

  private boolean checkUsername(ServletRequest request, ServletResponse response)
                      throws IOException, ServletException {

    String username =((HttpServletRequest) request).getParameter("username");
    if(username!=null)
      username=new String(username.getBytes("ISO-8859-1"),"GB2312");

    if (username!=null && username.indexOf(blackList) != -1  )  {
      //生成拒绝用户留言的网页
      response.setContentType("text/html;charset=GB2312");
      PrintWriter out = response.getWriter();
      out.println("<h1>对不起,"+username + ",你没有权限留言 </h1>");
      out.flush();
      return false;
    }else{
      return true;
    }
  
  }
  public void destroy() {
    System.out.println("NoteFilter: destroy()"); 
    config = null;
  }

}




/****************************************************
 * 作者：孙卫琴                                     *
 * 来源：<<Tomcat与Java Web开发技术详解>>           *
 * 技术支持网址：www.javathinker.org                *
 ***************************************************/
