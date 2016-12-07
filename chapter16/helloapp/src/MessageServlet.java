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

   //加载Resource Bundle
    ResourceBundle bundle = ResourceBundle.getBundle( "resource" );

    // 获取消息模版
    String requiredFieldMessage = bundle.getString( "error.requiredfield" );

    // 创建存放消息参数的数组
    Object[] messageArgs = new Object[1];

    //读取label.name对应的文本
    messageArgs[0] = bundle.getString( "label.name" );

    // 格式化消息
    String formattedNameMessage =
      MessageFormat.format( requiredFieldMessage, messageArgs );

    out.println( formattedNameMessage +"<br>");

    // 读取label.phone对应的文本
    messageArgs[0] = bundle.getString( "label.phone" );

    // 格式化消息
    String formattedPhoneMessage =
      MessageFormat.format( requiredFieldMessage, messageArgs );

    out.println( formattedPhoneMessage +"<br>");

    out.println("</body></html>");
  }
}




/****************************************************
 * 作者：孙卫琴                                     *
 * 来源：<<Tomcat与Java Web开发技术详解>>           *
 * 技术支持网址：www.javathinker.org                *
 ***************************************************/
