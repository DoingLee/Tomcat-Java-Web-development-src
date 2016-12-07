package server;
import java.io.*;
public class UploadServlet implements Servlet{
  public void init()throws Exception{
    System.out.println("UploadServlet is inited");
  }
  public void service(byte[] requestBuffer, OutputStream out)throws Exception{
    String request=new String(requestBuffer);

    //获得HTTP请求的头
    String headerOfRequest=request.substring(request.indexOf("\r\n")+2,request.indexOf("\r\n\r\n"));

    BufferedReader br=new BufferedReader(new StringReader(headerOfRequest));
    String data=null;
    //获取boundary
    String boundary=null;
    while((data=br.readLine())!=null){
      if(data.indexOf("Content-Type")!=-1){
        boundary=data.substring(data.indexOf("boundary=")+9,data.length())+"\r\n";
        break;
      }
    }
    
    if(boundary==null){
      out.write("HTTP/1.1 200 OK\r\n".getBytes());
      //发送HTTP响应头
      out.write("Content-Type:text/html\r\n\r\n".getBytes());
      //发送HTTP响应正文
      out.write("Uploading is failed".getBytes());
      return;
    }
    
    //第一个boundary出现的位置
    int index1OfBoundary=request.indexOf(boundary);    
    //第二个boundary出现的位置
    int index2OfBoundary=request.indexOf(boundary,index1OfBoundary+boundary.length());
    //第三个boundary出现的位置
    int index3OfBoundary=request.indexOf(boundary,index2OfBoundary+boundary.length());
    //文件部分的正文部分的开始前的位置    
    int beforeOfFilePart=request.indexOf("\r\n\r\n",index2OfBoundary)+3;
    //文件部分的正文部分的结束后的位置
    int afterOfFilePart=index3OfBoundary-4;
    //文件部分的头的第一行结束后的位置
    int afterOfFilePartLine1=request.indexOf("\r\n",index2OfBoundary+boundary.length());
    //文件部分的头的第二行   
    String header2OfFilePart=request.substring(index2OfBoundary+boundary.length(),afterOfFilePartLine1);
    //上传文件的名字
    String fileName=header2OfFilePart.substring(header2OfFilePart.lastIndexOf("\\")+1,header2OfFilePart.length()-1);
    //文件部分的正文部分之前的字符串的字节长度
    int len1=request.substring(0,beforeOfFilePart+1).getBytes().length;
    //文件部分的正文部分之后的字符串的字节长度
    int len2=request.substring(afterOfFilePart,request.length()).getBytes().length; 
    //文件部分的正文部分的字节长度
    int fileLen=requestBuffer.length-len1-len2;

    /* 把文件部分的正文部分保存到本地文件系统中 */
    FileOutputStream f=new FileOutputStream("server\\root\\"+fileName);
    f.write(requestBuffer,len1,fileLen);
    f.close();  
   
    /*创建并发送HTTP响应*/
    //发送HTTP响应第一行
    out.write("HTTP/1.1 200 OK\r\n".getBytes());
    //发送HTTP响应头
    out.write("Content-Type:text/html\r\n\r\n".getBytes());
    //发送HTTP响应正文
    out.write("<html><head><title>HelloWorld</title></head><body>".getBytes());
    out.write(new String("<h1>Uploading is finished.<br></h1>").getBytes());
    out.write(new String("<h1>FileName:"+fileName+"<br></h1>").getBytes());
    out.write(new String("<h1>FileSize:"+fileLen+"<br></h1></body><head>").getBytes());

  }
}



/****************************************************
 * 作者：孙卫琴                                     *
 * 来源：<<Tomcat与Java Web开发技术详解>>           *
 * 技术支持网址：www.javathinker.org                *
 ***************************************************/
