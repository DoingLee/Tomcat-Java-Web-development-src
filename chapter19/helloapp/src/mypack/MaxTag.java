package mypack;

import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.io.IOException;
import java.util.ArrayList;
 
public class MaxTag extends SimpleTagSupport implements DynamicAttributes{  
     
  private ArrayList<String> al=new ArrayList<String>();
  
  public void setDynamicAttribute(String uri,String localeName,Object value)throws JspException{
    //将所有属性保存到ArrayList中
    al.add((String)value);
  }
    
  public void doTag() throws JspException, IOException {    
    JspContext context=getJspContext();    
    
    int max=0;
    for(int i=0;i<al.size();i++){
      int num=Integer.parseInt(al.get(i));
      max= num > max ? num : max;
    }
    //将最大值保存到页面范围内
    context.setAttribute("max",new Integer(max));
  }
}







/****************************************************
 * 作者：孙卫琴                                     *
 * 来源：<<Tomcat与Java Web开发技术详解>>           *
 * 技术支持网址：www.javathinker.org                *
 ***************************************************/
