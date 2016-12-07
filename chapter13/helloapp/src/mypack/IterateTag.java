package mypack;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.TagSupport;
import java.util.*;

public class IterateTag extends TagSupport{
  private Iterator items;  //待遍历的集合
  private String var;  //存放在页面范围内的集合中元素的属性名
  private Object item;  //集合中的一个元素

  public void setItems(Collection items){
    if(items.size()>0)
      this.items=items.iterator();
  }

  public void setVar(String var){
    this.var=var;
  }
  
  public int doStartTag()throws JspException{
    if(items.hasNext()){
      item=items.next();  //从集合中读取一个元素 
      saveItem(); //把元素存放在页面范围内
      return EVAL_BODY_INCLUDE;
    }else{
      return SKIP_BODY;
    }
    
  }

  public int doAfterBody()throws JspException{
    //如果集合中还有元素，就把元素存放在页面范围内，再重复执行标签主体
    if(items.hasNext()){
      item=items.next();
      saveItem();
      return EVAL_BODY_AGAIN;
    }else{
      return SKIP_BODY;
    }
  }
 
  /**如果元素不为null，就把它存放在页面范围内 */
  private void saveItem(){
    if(item==null)
      pageContext.removeAttribute(var,PageContext.PAGE_SCOPE);
    else
      pageContext.setAttribute(var,item);
  }

}




/****************************************************
 * 作者：孙卫琴                                     *
 * 来源：<<Tomcat与Java Web开发技术详解>>           *
 * 技术支持网址：www.javathinker.org                *
 ***************************************************/
