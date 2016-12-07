package mypack;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspTagException;
import javax.servlet.jsp.tagext.TagSupport;
import javax.servlet.http.HttpSession;
import java.util.*;
import java.io.*;

public class MessageTag extends TagSupport{
  private String key=null;

  public String getKey(){
    return this.key;
  }

  public void setKey(String key){
    this.key=key;
  }

  public int doEndTag() throws JspException {
    try {
      //获得英文资源文本
      Properties ps=(Properties)pageContext.getAttribute("ps",pageContext.APPLICATION_SCOPE);
      //获得中文资源文件
      Properties ps_ch=(Properties)pageContext.getAttribute("ps_ch",pageContext.APPLICATION_SCOPE);
      
      HttpSession session=pageContext.getSession();
      //读取当前使用的语言
      String language=(String)session.getAttribute("language");
      
      //决定与key匹配的文本
      String message=null;
      if(language!=null && language.equals("Chinese")){
        message=(String)ps_ch.get(key);
	message=new String(message.getBytes("ISO-8859-1"),"GB2312");
      }else{
         message=(String)ps.get(key);
      } 
      
      //打印静态文本
      pageContext.getOut().print(message);
    
    }catch (Exception e) {
      throw new JspTagException(e);
    }
   
    return EVAL_PAGE;
  }
}




/****************************************************
 * 作者：孙卫琴                                     *
 * 来源：<<Tomcat与Java Web开发技术详解>>           *
 * 技术支持网址：www.javathinker.org                *
 ***************************************************/
