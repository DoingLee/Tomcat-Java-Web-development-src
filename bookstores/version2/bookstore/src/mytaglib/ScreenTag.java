
package mytaglib;
import javax.servlet.jsp.JspTagException;
import javax.servlet.jsp.tagext.*;
import java.util.*;
public class ScreenTag extends TagSupport {

   public ScreenTag() {
      super();
   }
   public int doStartTag() {

      setValue("parameters", new ArrayList());
      HashMap screens = (HashMap) pageContext.getAttribute("screens", pageContext.APPLICATION_SCOPE);
      if (screens == null) {
          return SKIP_BODY;
      }
      else {
          if (!screens.containsKey(getId())) {
               screens.put(getId(), getValue("parameters"));
               return EVAL_BODY_INCLUDE;
          }else{
               return SKIP_BODY;
          }  
      }
   }

   public void release() {
      super.release();
   }
}




/****************************************************
 * 作者：孙卫琴                                     *
 * 来源：<<Tomcat与Java Web开发技术详解>>           *
 * 技术支持网址：www.javathinker.org                *
 ***************************************************/
