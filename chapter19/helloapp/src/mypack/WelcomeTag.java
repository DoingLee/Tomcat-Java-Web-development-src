package mypack;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import javax.servlet.jsp.tagext.JspFragment;
import java.io.IOException;
 
public class WelcomeTag extends SimpleTagSupport {  
     
  private String username;
  public void setUsername(String username){
    this.username=username;
  }

  public void doTag() throws JspException, IOException {    
    getJspContext().getOut().print(username+",");    

    JspFragment jspBody=getJspBody();
    //将标签主体的执行结果输出到当前输出流中。
    jspBody.invoke(null);  
  }
}







/****************************************************
 * 作者：孙卫琴                                     *
 * 来源：<<Tomcat与Java Web开发技术详解>>           *
 * 技术支持网址：www.javathinker.org                *
 ***************************************************/
