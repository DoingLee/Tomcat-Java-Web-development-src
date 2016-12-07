package mypack;
import java.io.*;
import javax.servlet.*;

public class ReplaceTextStream extends ServletOutputStream {
  private ServletOutputStream intStream; //��Servlet�����ṩ��ServletOutputStream����
  private ByteArrayOutputStream baStream; //�䵱NoteServlet���ɵ���Ӧ����Ļ���
  private boolean closed = false;

  private String oldStr; //��Ҫ���滻���ַ���
  private String newStr; //�滻����ַ��� 

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
  
    /*�ѻ����е����ݽ����滻������
    �ٰ��滻�������д��Servlet�����ṩ��ServletOutputStream������ */
    intStream.write(replaceContent(baStream.toByteArray()));
    intStream.flush(); //��ͻ����ύ�Ѿ����ɵ���Ӧ����
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
 * ���ߣ�������                                     *
 * ��Դ��<<Tomcat��Java Web�����������>>           *
 * ����֧����ַ��www.javathinker.org                *
 ***************************************************/
