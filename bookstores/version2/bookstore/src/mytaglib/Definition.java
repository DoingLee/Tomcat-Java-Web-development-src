
package mytaglib;
import java.util.HashMap;

public class Definition {
   private HashMap params = new HashMap();

   public void setParam(Parameter p) {
      params.put(p.getName(), p);
   }
   public Parameter getParam(String name) {
      return (Parameter) params.get(name);
   }
}




/****************************************************
 * ���ߣ�������                                     *
 * ��Դ��<<Tomcat��Java Web�����������>>           *
 * ����֧����ַ��www.javathinker.org                *
 ***************************************************/
