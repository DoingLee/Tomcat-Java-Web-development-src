package server;
import java.io.*;
public interface Servlet{
  public void init()throws Exception;
  public void service(byte[] requestBuffer, OutputStream out)throws Exception;
}



/****************************************************
 * 作者：孙卫琴                                     *
 * 来源：<<Tomcat与Java Web开发技术详解>>           *
 * 技术支持网址：www.javathinker.org                *
 ***************************************************/
