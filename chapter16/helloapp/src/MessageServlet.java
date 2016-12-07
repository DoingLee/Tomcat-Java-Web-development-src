import java.io.IOException;
import java.io.PrintWriter;
import java.util.ResourceBundle;
import java.util.Locale;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.MessageFormat;

public class MessageServlet extends HttpServlet {
  private static final String CONTENT_TYPE = "text/html;charset=GB2312";

  public void doGet(HttpServletRequest request, HttpServletResponse response)
  throws ServletException, IOException {
    response.setContentType(CONTENT_TYPE);
    PrintWriter out = response.getWriter(  );

    out.println("<html>");
    out.println("<head><title>The Example Message Servlet</title></head>");
    out.println("<body>");

   //����Resource Bundle
    ResourceBundle bundle = ResourceBundle.getBundle( "resource" );

    // ��ȡ��Ϣģ��
    String requiredFieldMessage = bundle.getString( "error.requiredfield" );

    // ���������Ϣ����������
    Object[] messageArgs = new Object[1];

    //��ȡlabel.name��Ӧ���ı�
    messageArgs[0] = bundle.getString( "label.name" );

    // ��ʽ����Ϣ
    String formattedNameMessage =
      MessageFormat.format( requiredFieldMessage, messageArgs );

    out.println( formattedNameMessage +"<br>");

    // ��ȡlabel.phone��Ӧ���ı�
    messageArgs[0] = bundle.getString( "label.phone" );

    // ��ʽ����Ϣ
    String formattedPhoneMessage =
      MessageFormat.format( requiredFieldMessage, messageArgs );

    out.println( formattedPhoneMessage +"<br>");

    out.println("</body></html>");
  }
}




/****************************************************
 * ���ߣ�������                                     *
 * ��Դ��<<Tomcat��Java Web�����������>>           *
 * ����֧����ַ��www.javathinker.org                *
 ***************************************************/
