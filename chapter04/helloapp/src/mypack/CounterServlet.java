package mypack;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class CounterServlet extends HttpServlet {
  public void doGet(HttpServletRequest request,
    HttpServletResponse response)throws ServletException, IOException {

    //���ServletContext������
    ServletContext context = getServletContext();

    // ��ServletContext�ж�ȡcounter����
    Counter counter = (Counter)context.getAttribute("counter");

    // ���ServletContext��û��counter���ԣ��ʹ���counter����
    if ( counter == null ) {
      counter = new Counter(1);
      context.setAttribute("counter", counter);
    }
    
    response.setContentType("text/html;charset=GB2312");
    PrintWriter out = response.getWriter();
    out.println("<html><head><title>CounterServlet</TITLE></head>");
    out.println("<body>");
    // �����ǰ��counter����
    out.println("<h1>��ӭ���ٱ�վ�����ǵ� " + counter.getCount()+" λ�����ߡ�</h1>");
    out.println("</body></html>");
  
    //������������1   
    counter.add(1);
    out.close();
  }
}




/****************************************************
 * ���ߣ�������                                     *
 * ��Դ��<<Tomcat��Java Web�����������>>           *
 * ����֧����ַ��www.javathinker.org                *
 ***************************************************/
