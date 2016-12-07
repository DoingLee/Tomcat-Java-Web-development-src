package mypack;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class CounterServlet1 extends HttpServlet {
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

  public void init(){
    System.out.println("CounterServlet1 is Initialized.");

    //��ȡServletContext����
    ServletContext context=getServletContext(); 

    try{
      //���ļ��ж�ȡ����������ֵ
      BufferedReader reader=new BufferedReader(
        new   InputStreamReader(context.getResourceAsStream("/count/count.txt")));     
      int count=Integer.parseInt(reader.readLine());
      reader.close();
      //��������������
      Counter counter=new Counter(count);
      //�Ѽ��������󱣴浽WebӦ�÷�Χ
      context.setAttribute("counter",counter);
    }catch(IOException e){e.printStackTrace();}
  }

  public void destroy(){
    System.out.println("CounterServlet1 is Destroyed.");

    //��ȡServletContext����
    ServletContext context=getServletContext(); 

    //��WebӦ�÷�Χ��ü���������
    Counter counter=(Counter)context.getAttribute("counter");

    if(counter!=null){
      try{
        //�Ѽ���������ֵд��count.txt�ļ���
        String filepath=context.getRealPath("/count");
        filepath=filepath+"/count.txt";
        PrintWriter pw=new PrintWriter(filepath);  
        pw.println(counter.getCount());
        pw.close();
      }catch(IOException e){e.printStackTrace();}
    }
  }
}




/****************************************************
 * ���ߣ�������                                     *
 * ��Դ��<<Tomcat��Java Web�����������>>           *
 * ����֧����ַ��www.javathinker.org                *
 ***************************************************/
