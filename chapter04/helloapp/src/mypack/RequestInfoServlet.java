package mypack;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.*;

public class RequestInfoServlet extends HttpServlet {

  /** ��Ӧ�ͻ�����*/
  public void doGet(HttpServletRequest request,HttpServletResponse response)
         throws ServletException, IOException {
    //����HTTP��Ӧ�����ĵ���������
    response.setContentType("text/html;charset=GB2312");
    
    /*���HTML�ĵ�*/
    PrintWriter out = response.getWriter();
    out.println("<html><head><title>RequestInfo</TITLE></head>");
    out.println("<body>");
    //��ӡ�������˵�IP��ַ
    out.println("<br>LocalAddr: "+request.getLocalAddr());
    //��ӡ�������˵ĵ�������
    out.println("<br>LocalName: "+request.getLocalName());
    //��ӡ�������˵ĵ�FTP�˿ں�
    out.println("<br>LocalPort: "+request.getLocalPort());
    //��ӡ�ͻ������������ͨ�����õ�Э��������Լ��汾��
    out.println("<br>Protocol: "+request.getProtocol());
    //��ӡ�ͻ��˵�IP��ַ
    out.println("<br>RemoteAddr: "+request.getRemoteAddr());
    //��ӡ�ͻ��˵�������
    out.println("<br>RemoteHost: "+request.getRemoteHost());
    //��ӡ�ͻ��˵�FTP�˿ں�
    out.println("<br>RemotePort: "+request.getRemotePort());

    //��ӡHTTP����ʽ
    out.println("<br>Method: "+request.getMethod());
    //��ӡHTTP�����е�URI
    out.println("<br>URI: "+request.getRequestURI());
    //��ӡ�ͻ�����������ʵ�WebӦ�õ�URL���
    out.println("<br>ContextPath: "+request.getContextPath());
    //��ӡHTTP�����еĲ�ѯ�ַ���
    out.println("<br>QueryString: "+request.getQueryString());

    /**��ӡHTTP����ͷ*/
    out.println("<br>***��ӡHTTP����ͷ***");
    Enumeration eu=request.getHeaderNames();
    while(eu.hasMoreElements()){
      String headerName=(String)eu.nextElement();
      out.println("<br>"+headerName+": "+request.getHeader(headerName));
    }
    out.println("<br>***��ӡHTTP����ͷ����***<br>");
    //��ӡ�������username
    out.println("<br>username: "+request.getParameter("username"));
    out.println("</body></html>");

    //�ر������
    out.close();
  }
}




/****************************************************
 * ���ߣ�������                                     *
 * ��Դ��<<Tomcat��Java Web�����������>>           *
 * ����֧����ַ��www.javathinker.org                *
 ***************************************************/
