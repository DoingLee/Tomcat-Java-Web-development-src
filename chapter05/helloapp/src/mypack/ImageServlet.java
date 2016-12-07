package mypack;
import  java.io.*;
import  com.sun.image.codec.jpeg.*;
import  javax.servlet.*;
import  javax.servlet.http.*;
import  java.awt.*;
import  java.awt.image.*;

public class ImageServlet extends HttpServlet{
  private Font font=new Font("Courier", Font.BOLD,12); //����
  
  public void doGet(HttpServletRequest request,HttpServletResponse response)
         throws ServletException,IOException{
    //�õ�����ʾ������
    String count=request.getParameter("count");
    if(count==null) count="1";

    int len=count.length(); //���ֵĳ���

    response.setContentType("image/jpeg");
    ServletOutputStream  out=response.getOutputStream();
    //����һ��λ�ڻ����е�ͼ�񣬳�Ϊ11*len����Ϊ16
    BufferedImage  image=new  BufferedImage(11*len,16,BufferedImage.TYPE_INT_RGB);

    //���Graphics����
    Graphics  g=image.getGraphics();
    g.setColor(Color.black);
    //��һ����ɫ�ľ��Σ���Ϊ11*len����Ϊ16
    g.fillRect(0,0,11*len,16);  

    g.setColor(Color.white);
    g.setFont(font);

    char c;
    for(int  i=0;i<len;i++)  {
      c=count.charAt(i);
      g.drawString(c+"",i*11+1,12); //дһ����ɫ������
      g.drawLine((i+1)*11-1,0,(i+1)*11-1,16); //��һ����ɫ������
    }

    //���JPEG��ʽ��ͼƬ 
    JPEGImageEncoder encoder=JPEGCodec.createJPEGEncoder(out);
    encoder.encode(image);
    out.close();
  }

  public void doPost(HttpServletRequest request,HttpServletResponse response)
         throws ServletException,IOException  {

    doGet(request,response);
  }
}



/****************************************************
 * ���ߣ�������                                     *
 * ��Դ��<<Tomcat��Java Web�����������>>           *
 * ����֧����ַ��www.javathinker.org                *
 ***************************************************/
