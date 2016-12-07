import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.Locale;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LocaleServlet extends HttpServlet {
  private static final String CONTENT_TYPE = "text/html;charset=GB2312";

  public void doGet(HttpServletRequest request, HttpServletResponse response)
  throws ServletException, IOException {
    response.setContentType(CONTENT_TYPE);
    PrintWriter out = response.getWriter(  );

    out.println("<html>");
    out.println("<head><title>The Example Locale Servlet</title></head>");
    out.println("<body>");

    //��ȡ�ͻ�������ʹ�õ�Locale
    Locale preferredLocale = request.getLocale(  );
    out.println("<p>The user's preffered Locale is " + preferredLocale + "</p>");

    //�����ͻ���֧�ֵ�����Locale
    out.println("<p>A list of preferred Locales in descreasing order</p>");
    Enumeration allUserSupportedLocales = request.getLocales(  );
    out.println("<ul>");
    while( allUserSupportedLocales.hasMoreElements(  ) ){
      Locale supportedLocale = (Locale)allUserSupportedLocales.nextElement(  );
      StringBuffer buf = new StringBuffer(  );
      buf.append("<li>");
      buf.append("Locale: ");
      buf.append( supportedLocale );
      buf.append( " - " );
      buf.append( supportedLocale.getDisplayName(  ) );
      buf.append("</li>");
      out.println( buf.toString(  ) );
    }	
    out.println("</ul>");

    //��ȡServlet����ʹ�õ�Ĭ��Locale
    Locale servletContainerLocale = Locale.getDefault(  );
    out.println("<p>The container's Locale " + servletContainerLocale + "</p>");

    out.println("</body></html>");
  }
}




/****************************************************
 * ���ߣ�������                                     *
 * ��Դ��<<Tomcat��Java Web�����������>>           *
 * ����֧����ַ��www.javathinker.org                *
 ***************************************************/
