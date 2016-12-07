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

    //��ȡ�ܾ�IP��ַ
    ipblock=config.getInitParameter("ipblock");

    //��ȡblacklist��ʼ������
    blackList=config.getInitParameter("blacklist");
  }

  public void doFilter(ServletRequest request, ServletResponse response,
                     FilterChain chain) throws IOException, ServletException {

    System.out.println("NoteFilter: doFilter()"); 

    if(!checkRemoteIP(request,response))return;
    
    if(!checkUsername(request,response))return;
       
    //��¼��Ӧ�ͻ�����ǰ��ʱ��
    long before = System.currentTimeMillis();
    config.getServletContext().log("NoteFilter:before call chain.doFilter()");

    //������ת���������Ĺ���������Web���
    chain.doFilter(request, response);

    //��¼��Ӧ�ͻ�������ʱ��
    config.getServletContext().log("NoteFilter:after call chain.doFilter()");
    long after = System.currentTimeMillis();
    
    String name = "";
    if (request instanceof HttpServletRequest) {
        name = ((HttpServletRequest)request).getRequestURI();
    }
    //��¼��Ӧ�ͻ�����������ʱ��
    config.getServletContext().log("NoteFilter:"+name + ": " + (after - before) + "ms");
  }

  private boolean checkRemoteIP(ServletRequest request, ServletResponse response) 
                        throws IOException, ServletException {
    //��ȡ�ͻ���IP��ַ
    String addr=request.getRemoteAddr();
    if(addr.indexOf(ipblock)==0){
      response.setContentType("text/html;charset=GB2312");
      PrintWriter out = response.getWriter();
      out.println("<h1>�Բ���,�������޷�Ϊ���ṩ����</h1>");
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
      //���ɾܾ��û����Ե���ҳ
      response.setContentType("text/html;charset=GB2312");
      PrintWriter out = response.getWriter();
      out.println("<h1>�Բ���,"+username + ",��û��Ȩ������ </h1>");
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
 * ���ߣ�������                                     *
 * ��Դ��<<Tomcat��Java Web�����������>>           *
 * ����֧����ַ��www.javathinker.org                *
 ***************************************************/
