package mypack;
import javax.servlet.http.*;
import javax.servlet.*;
import java.io.*;

public class ReplaceTextWrapper extends HttpServletResponseWrapper {

  private ReplaceTextStream tpStream; //ServletOutputStream�İ�װ����

  public ReplaceTextWrapper(ServletResponse inResp, String searchText,
                              String replaceText)throws java.io.IOException {
    super((HttpServletResponse) inResp);
    tpStream = new ReplaceTextStream(inResp.getOutputStream(),
                                       searchText,replaceText);

  }

  public ServletOutputStream getOutputStream() throws java.io.IOException {
    return tpStream;
  }

}






/****************************************************
 * ���ߣ�������                                     *
 * ��Դ��<<Tomcat��Java Web�����������>>           *
 * ����֧����ַ��www.javathinker.org                *
 ***************************************************/
