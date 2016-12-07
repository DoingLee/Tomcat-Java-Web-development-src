package mypack;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class CounterServlet1 extends HttpServlet {
  public void doGet(HttpServletRequest request,
    HttpServletResponse response)throws ServletException, IOException {

    //获得ServletContext的引用
    ServletContext context = getServletContext();

    // 从ServletContext中读取counter属性
    Counter counter = (Counter)context.getAttribute("counter");

    // 如果ServletContext中没有counter属性，就创建counter属性
    if ( counter == null ) {
      counter = new Counter(1);
      context.setAttribute("counter", counter);
    }
    
    response.setContentType("text/html;charset=GB2312");
    PrintWriter out = response.getWriter();
    out.println("<html><head><title>CounterServlet</TITLE></head>");
    out.println("<body>");
    // 输出当前的counter属性
    out.println("<h1>欢迎光临本站。您是第 " + counter.getCount()+" 位访问者。</h1>");
    out.println("</body></html>");
  
    //将计数器递增1   
    counter.add(1);
    out.close();
  }

  public void init(){
    System.out.println("CounterServlet1 is Initialized.");

    //获取ServletContext对象
    ServletContext context=getServletContext(); 

    try{
      //从文件中读取计数器的数值
      BufferedReader reader=new BufferedReader(
        new   InputStreamReader(context.getResourceAsStream("/count/count.txt")));     
      int count=Integer.parseInt(reader.readLine());
      reader.close();
      //创建计数器对象
      Counter counter=new Counter(count);
      //把计数器对象保存到Web应用范围
      context.setAttribute("counter",counter);
    }catch(IOException e){e.printStackTrace();}
  }

  public void destroy(){
    System.out.println("CounterServlet1 is Destroyed.");

    //获取ServletContext对象
    ServletContext context=getServletContext(); 

    //从Web应用范围获得计数器对象
    Counter counter=(Counter)context.getAttribute("counter");

    if(counter!=null){
      try{
        //把计数器的数值写到count.txt文件中
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
 * 作者：孙卫琴                                     *
 * 来源：<<Tomcat与Java Web开发技术详解>>           *
 * 技术支持网址：www.javathinker.org                *
 ***************************************************/
