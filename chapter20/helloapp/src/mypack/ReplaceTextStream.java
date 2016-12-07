package mypack;
import java.io.*;
import javax.servlet.*;

public class ReplaceTextStream extends ServletOutputStream {
  private ServletOutputStream intStream; //由Servlet容器提供的ServletOutputStream对象
  private ByteArrayOutputStream baStream; //充当NoteServlet生成的响应结果的缓存
  private boolean closed = false;

  private String oldStr; //需要被替换的字符串
  private String newStr; //替换后的字符串 

  public ReplaceTextStream(ServletOutputStream outStream,
           String searchStr, String replaceStr) {
    intStream = outStream;
    baStream = new ByteArrayOutputStream();
    oldStr = searchStr;
    newStr = replaceStr;
  }

  public void write(int a)throws IOException{
    baStream.write(a);
  }

  public void println(String s)throws IOException{
    s=s+"\n";
    byte[] bs=s.getBytes();
    baStream.write(bs);
  }

  public void close() throws java.io.IOException {
    if (!closed) {
       processStream();
       intStream.close();
       closed = true;
     }
  }

  public void flush() throws java.io.IOException {
    if (baStream.size() != 0) {
      if (! closed) {
        processStream();   
        baStream = new ByteArrayOutputStream();
      }
    }
  }

  public void processStream() throws java.io.IOException {
  
    /*把缓存中的数据进行替换操作后，
    再把替换后的数据写到Servlet容器提供的ServletOutputStream对象中 */
    intStream.write(replaceContent(baStream.toByteArray()));
    intStream.flush(); //向客户端提交已经生成的响应数据
  }


  public byte []  replaceContent(byte [] inBytes) {
    String retVal ="";
    String firstPart="";

    String tpString = new String(inBytes);
    String srchString = (new String(inBytes)).toLowerCase();

    int endBody = srchString.indexOf(oldStr);

    if (endBody != -1) {
      firstPart = tpString.substring(0, endBody);
      retVal = firstPart + newStr +
      tpString.substring(endBody + oldStr.length());

   } else {
      retVal=tpString;
   }

    return retVal.getBytes();
  }
}











/****************************************************
 * 作者：孙卫琴                                     *
 * 来源：<<Tomcat与Java Web开发技术详解>>           *
 * 技术支持网址：www.javathinker.org                *
 ***************************************************/
