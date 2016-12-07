package client;
import java.net.*;
import java.io.*;
import java.util.*;

public class HTTPClient {
  public static void main(String args[]){
    //确定HTTP请求的uri
    String uri="index.htm";
    if(args.length !=0)uri=args[0]; 
    
    doGet("localhost",8080,uri); //按照GET请求方式访问HTTPServer 
  }
  
  /** 按照GET请求方式访问HTTPServer */
  public static void doGet(String host,int port,String uri){
    Socket socket=null;
    
    try{
      socket=new Socket(host,port); //与HTTPServer建立FTP连接
    }catch(Exception e){e.printStackTrace();}
  
    try{
      /*创建HTTP请求 */
      StringBuffer sb=new StringBuffer("GET "+uri+" HTTP/1.1\r\n");
      sb.append("Accept: */*\r\n");
      sb.append("Accept-Language: zh-cn\r\n");
      sb.append("Accept-Encoding: gzip, deflate\r\n");
      sb.append("User-Agent: HTTPClient\r\n");
      sb.append("Host: localhost:8080\r\n");
      sb.append("Connection: Keep-Alive\r\n\r\n");
    
      /*发送HTTP请求*/
      OutputStream socketOut=socket.getOutputStream(); //获得输出流  
      socketOut.write(sb.toString().getBytes());
    
      Thread.sleep(2000); //睡眠2秒，等待响应结果
    
      /*接收响应结果*/
      InputStream socketIn=socket.getInputStream(); //获得输入流
      int size=socketIn.available();
      byte[] buffer=new byte[size];
      socketIn.read(buffer);
      System.out.println(new String(buffer)); //打印响应结果
      
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
 * 作者：孙卫琴                                     *
 * 来源：<<Tomcat与Java Web开发技术详解>>           *
 * 技术支持网址：www.javathinker.org                *
 ***************************************************/
