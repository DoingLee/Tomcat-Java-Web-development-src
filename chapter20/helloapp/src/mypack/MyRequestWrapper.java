package mypack;
import javax.servlet.http.*;
import javax.servlet.*;
import java.io.*;

public class MyRequestWrapper extends HttpServletRequestWrapper {
  public MyRequestWrapper(HttpServletRequest request) {
    super(request);
  }

  public String getParameter(String name){
    String value=super.getParameter(name);
    if(value==null){
      value="none";
    }else{
      try{
        value=new String(value.getBytes("ISO-8859-1"),"GB2312");
      }catch(Exception e){}
    }
    return value;
  }
}






/****************************************************
 * ���ߣ�������                                     *
 * ��Դ��<<Tomcat��Java Web�����������>>           *
 * ����֧����ַ��www.javathinker.org                *
 ***************************************************/
