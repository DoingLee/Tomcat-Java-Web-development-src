package mypack;
import javax.servlet.http.*;
import javax.servlet.*;
import java.io.*;

public class ReplaceTextWrapper extends HttpServletResponseWrapper {

  private ReplaceTextStream tpStream; //ServletOutputStream的包装对象

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
 * 作者：孙卫琴                                     *
 * 来源：<<Tomcat与Java Web开发技术详解>>           *
 * 技术支持网址：www.javathinker.org                *
 ***************************************************/
