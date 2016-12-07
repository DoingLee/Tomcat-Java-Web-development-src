import java.io.IOException;
import java.io.PrintWriter;
import java.util.ResourceBundle;
import java.util.Locale;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BundleServlet extends HttpServlet {
  private static final String CONTENT_TYPE = "text/html;charset=GB2312";

  public void doGet(HttpServletRequest request, HttpServletResponse response)
  throws ServletException, IOException {
    response.setContentType(CONTENT_TYPE);
    PrintWriter out = response.getWriter(  );

    out.println("<html>");
    out.println("<head><title>The Example Bundle Servlet</title></head>");
    out.println("<body>");

    ResourceBundle bundle=ResourceBundle.getBundle("resource"); 
    String key="hello";
    //������keyƥ����ı���
    String message=bundle.getString(key);
    out.println("key="+key+"<br>");
    out.println("message="+message+"<br>");
    out.println("</body></html>");
  }
}




/****************************************************
 * ���ߣ�������                                     *
 * ��Դ��<<Tomcat��Java Web�����������>>           *
 * ����֧����ַ��www.javathinker.org                *
 ***************************************************/
