package mypack;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.*;
import org.apache.commons.fileupload.*;
import org.apache.commons.fileupload.servlet.*;
import org.apache.commons.fileupload.disk.*;

public class UploadServlet extends HttpServlet {
  private String filePath; //存放上传文件的目录
  private String tempFilePath; //存放临时文件的目录

  public void init(ServletConfig config)throws ServletException {
    super.init(config);
    filePath=config.getInitParameter("filePath");
    tempFilePath=config.getInitParameter("tempFilePath");
    filePath=getServletContext().getRealPath(filePath);
    tempFilePath=getServletContext().getRealPath(tempFilePath);
  }
  public void doPost(HttpServletRequest request,HttpServletResponse response)
         throws ServletException, IOException {
    response.setContentType("text/plain");
    //向客户端发送响应正文
    PrintWriter outNet=response.getWriter(); 
    try{
      //创建一个基于硬盘的FileItem工厂
      DiskFileItemFactory factory = new DiskFileItemFactory();
      //设置向硬盘写数据时所用的缓冲区的大小，此处为4K
      factory.setSizeThreshold(4*1024); 
      //设置临时目录
      factory.setRepository(new File(tempFilePath));

      //创建一个文件上传处理器
      ServletFileUpload upload = new ServletFileUpload(factory);
      //设置允许上传的文件的最大尺寸，此处为4M
      upload.setSizeMax(4*1024*1024); 
    
      List /* FileItem */ items = upload.parseRequest(request);    

      Iterator iter = items.iterator();
      while (iter.hasNext()) {
        FileItem item = (FileItem) iter.next();
        if(item.isFormField()) {
          processFormField(item,outNet); //处理普通的表单域
        }else{
          processUploadedFile(item,outNet); //处理上传文件
        }
      }
      outNet.close();
    }catch(Exception e){
       throw new ServletException(e);
    }
  }

  private void processFormField(FileItem item,PrintWriter outNet){
    String name = item.getFieldName();
    String value = item.getString();
    outNet.println(name+":"+value+"\r\n");
  }
  
  
  private void processUploadedFile(FileItem item,PrintWriter outNet)throws Exception{
    String filename=item.getName();
    int index=filename.lastIndexOf("\\");
    filename=filename.substring(index+1,filename.length());
    long fileSize=item.getSize();
    
    if(filename.equals("") && fileSize==0)return;

    File uploadedFile = new File(filePath+"/"+filename);
    item.write(uploadedFile);
    outNet.println(filename+" is saved.");
    outNet.println("The size of " +filename+" is "+fileSize+"\r\n");
  }
}




/****************************************************
 * 作者：孙卫琴                                     *
 * 来源：<<Tomcat与Java Web开发技术详解>>           *
 * 技术支持网址：www.javathinker.org                *
 ***************************************************/
