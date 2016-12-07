package mypack;

import javax.servlet.*;
import java.io.*;

public class MyServletContextListener implements ServletContextListener{
  public void contextInitialized(ServletContextEvent sce){
    System.out.println("helloapp application is Initialized.");

    //获取ServletContext对象
    ServletContext context=sce.getServletContext(); 

    try{
      //从文件中读取计数器的数值
      BufferedReader reader=new BufferedReader(new InputStreamReader(context.getResourceAsStream("/count/count.txt")));     
      int count=Integer.parseInt(reader.readLine());
      reader.close();
      //创建计数器对象
      Counter counter=new Counter(count);
      //把计数器对象保存到Web应用范围
      context.setAttribute("counter",counter);
    }catch(IOException e){e.printStackTrace();}
  }

  public void contextDestroyed(ServletContextEvent sce){
    System.out.println("helloapp application is Destroyed.");

    //获取ServletContext对象
    ServletContext context=sce.getServletContext(); 

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
