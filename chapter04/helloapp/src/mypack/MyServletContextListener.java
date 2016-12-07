package mypack;

import javax.servlet.*;
import java.io.*;

public class MyServletContextListener implements ServletContextListener{
  public void contextInitialized(ServletContextEvent sce){
    System.out.println("helloapp application is Initialized.");

    //��ȡServletContext����
    ServletContext context=sce.getServletContext(); 

    try{
      //���ļ��ж�ȡ����������ֵ
      BufferedReader reader=new BufferedReader(new InputStreamReader(context.getResourceAsStream("/count/count.txt")));     
      int count=Integer.parseInt(reader.readLine());
      reader.close();
      //��������������
      Counter counter=new Counter(count);
      //�Ѽ��������󱣴浽WebӦ�÷�Χ
      context.setAttribute("counter",counter);
    }catch(IOException e){e.printStackTrace();}
  }

  public void contextDestroyed(ServletContextEvent sce){
    System.out.println("helloapp application is Destroyed.");

    //��ȡServletContext����
    ServletContext context=sce.getServletContext(); 

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
