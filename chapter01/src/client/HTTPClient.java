package client;
import java.net.*;
import java.io.*;
import java.util.*;

public class HTTPClient {
  public static void main(String args[]){
    //ȷ��HTTP�����uri
    String uri="index.htm";
    if(args.length !=0)uri=args[0]; 
    
    doGet("localhost",8080,uri); //����GET����ʽ����HTTPServer 
  }
  
  /** ����GET����ʽ����HTTPServer */
  public static void doGet(String host,int port,String uri){
    Socket socket=null;
    
    try{
      socket=new Socket(host,port); //��HTTPServer����FTP����
    }catch(Exception e){e.printStackTrace();}
  
    try{
      /*����HTTP���� */
      StringBuffer sb=new StringBuffer("GET "+uri+" HTTP/1.1\r\n");
      sb.append("Accept: */*\r\n");
      sb.append("Accept-Language: zh-cn\r\n");
      sb.append("Accept-Encoding: gzip, deflate\r\n");
      sb.append("User-Agent: HTTPClient\r\n");
      sb.append("Host: localhost:8080\r\n");
      sb.append("Connection: Keep-Alive\r\n\r\n");
    
      /*����HTTP����*/
      OutputStream socketOut=socket.getOutputStream(); //��������  
      socketOut.write(sb.toString().getBytes());
    
      Thread.sleep(2000); //˯��2�룬�ȴ���Ӧ���
    
      /*������Ӧ���*/
      InputStream socketIn=socket.getInputStream(); //���������
      int size=socketIn.available();
      byte[] buffer=new byte[size];
      socketIn.read(buffer);
      System.out.println(new String(buffer)); //��ӡ��Ӧ���
      
    }catch(Exception e){ 
      e.printStackTrace();
    }finally{
      try{
        socket.close();  
      }catch(Exception e){e.printStackTrace();}
    }
  } //#doGet()
}




/****************************************************
 * ���ߣ�������                                     *
 * ��Դ��<<Tomcat��Java Web�����������>>           *
 * ����֧����ַ��www.javathinker.org                *
 ***************************************************/
