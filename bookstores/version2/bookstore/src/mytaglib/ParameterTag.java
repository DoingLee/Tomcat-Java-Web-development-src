
package mytaglib;
import javax.servlet.jsp.JspTagException;
import javax.servlet.jsp.tagext.*;
import java.util.*;

public class ParameterTag extends TagSupport {
   private String paramName = null;
   private String paramValue = null;
   private String isDirectString = null;

   public ParameterTag() {
      super();
   }
   public void setName(String paramName) {
      this.paramName = paramName;
   }
   public void setValue(String paramValue) {
      this.paramValue = paramValue;
   }
   public void setDirect(String isDirectString) {
      this.isDirectString = isDirectString;
   }
   public int doStartTag() {
      boolean isDirect = false;

      if ((isDirectString != null) &&
         isDirectString.toLowerCase().equals("true"))
         isDirect = true;

      try {
         // retrieve the parameters list
         if (paramName != null) {
            ArrayList parameters = (ArrayList)((TagSupport)getParent()).getValue("parameters");
            if (parameters != null) {
               Parameter param = new Parameter(paramName, paramValue, isDirect);
               parameters.add(param);
            }
         }
      } catch (Exception e) {
         e.printStackTrace();
      }
      return SKIP_BODY;
   }
   public void release() {
      paramName = null;
      paramValue = null;
      isDirectString = null;
      super.release();
   }
}




/****************************************************
 * 作者：孙卫琴                                     *
 * 来源：<<Tomcat与Java Web开发技术详解>>           *
 * 技术支持网址：www.javathinker.org                *
 ***************************************************/
