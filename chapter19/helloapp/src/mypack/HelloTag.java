package mypack;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;
 
public class HelloTag extends SimpleTagSupport {       
  public void doTag() throws JspException, IOException {    
    getJspContext().getOut().write("This is my first tag!");     
  }
}







/****************************************************
 * 作者：孙卫琴                                     *
 * 来源：<<Tomcat与Java Web开发技术详解>>           *
 * 技术支持网址：www.javathinker.org                *
 ***************************************************/
