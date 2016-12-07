package mypack;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

public class DownloadServlet extends HttpServlet {
  public void doGet(HttpServletRequest request,HttpServletResponse response)
         throws ServletException, IOException {
    OutputStream out; //�����Ӧ���ĵ������
    InputStream in;  //��ȡ�����ļ���������
    //���filename������� 
    String filename=request.getParameter("filename");
     
    if(filename==null){
      out=response.getOutputStream(); 
      out.write("Please input filename.".getBytes());
      out.close();
      return;
    }
    
    //������ȡ�����ļ���������
    in= getServletContext().getResourceAsStream("/store/"+filename);
    int length=in.available();
    //������Ӧ���ĵ�MIME����
    response.setContentType("application/force-download"); 
    response.setHeader("Content-Length",String.valueOf(length));
    response.setHeader("Content-Disposition", "attachment;filename=\""+filename +"\" "); 
    
    /** �ѱ����ļ��е����ݷ��͸��ͻ� */
    out=response.getOutputStream(); 
    int bytesRead = 0;
    byte[] buffer = new byte[512];
    while ((bytesRead = in.read(buffer)) != -1){
      out.write(buffer, 0, bytesRead);
    } 
       
    in.close();
    out.close();
  }
}




/****************************************************
 * ���ߣ�������                                     *
 * ��Դ��<<Tomcat��Java Web�����������>>           *
 * ����֧����ַ��www.javathinker.org                *
 ***************************************************/
