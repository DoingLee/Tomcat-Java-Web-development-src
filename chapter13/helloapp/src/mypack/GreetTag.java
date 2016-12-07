package mypack;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.io.IOException;

public class GreetTag extends BodyTagSupport{
  private int count;  //表示循环次数 
  private String username; //表示请求参数username
  public void setCount(int count){
    this.count=count;
  }
  
  public int doStartTag()throws JspException{
    System.out.println("call doStartTag()");

    if(count>0){
      return EVAL_BODY_BUFFERED;
    }else{
      return SKIP_BODY;
    }
  }
  
  public void setBodyContent(BodyContent bc){
    System.out.println("call setBodyContent()");
    super.setBodyContent(bc);
  }

  public void doInitBody()throws JspException{
    System.out.println("call doInitBody()");
    username=pageContext.getRequest().getParameter("username");
  }

  public int doAfterBody()throws JspException{
    System.out.println("call doAfterBody()");
    
          

    if(count>1){
      count--;
      return EVAL_BODY_AGAIN;
    }else{
      return SKIP_BODY;
    }
  }

  public int doEndTag()throws JspException{
    System.out.println("call doEndTag()");
    JspWriter out=bodyContent.getEnclosingWriter(); 
    try{
      String content=bodyContent.getString();
      System.out.println(bodyContent.getString());      
      
      //修改标签主体的输出结果
      if(username!=null && username.equals("Monster")){
        content="Go away,Monster!" ;
      }
      
      out.println(content);
      
    }catch(IOException e){e.printStackTrace();} 

    return EVAL_PAGE;
  }

}




/****************************************************
 * 作者：孙卫琴                                     *
 * 来源：<<Tomcat与Java Web开发技术详解>>           *
 * 技术支持网址：www.javathinker.org                *
 ***************************************************/
