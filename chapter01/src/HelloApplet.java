import java.awt.*;
import java.awt.event.*;
import java.applet.Applet;

public class HelloApplet extends Applet implements Runnable{
  private int fontSize=8; //�����С
  private Thread changer; //��̬�ı������С���̣߳��γɶ���Ч��
  private boolean stopFlag=true;  //�����߳�������رյı�־
  private Button contrlButton=new Button("  ��ʼ��̬��ʾ�� ");

  public void init() {
    contrlButton.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent e){
        if(stopFlag)start();
        else stop();
    }});
    
    setBackground(Color.WHITE);
    add(contrlButton);
    setSize(100,100);
  }

  public void start(){
    changer=new Thread(this);
    stopFlag=false;
    fontSize=8;
    contrlButton.setLabel("  ֹͣ��̬��ʾ�� ");
    changer.start();
  }

  public void paint(Graphics g) {
    super.paint(g);
    g.setFont(new Font("newFont",Font.BOLD,fontSize));
    g.drawString("Hello",30,80);
  }

  public void stop(){
    stopFlag=true;
    contrlButton.setLabel("  ��ʼ��̬��ʾ�� ");
  }

  public void run(){
    while(!stopFlag){
      repaint(); 
      try{
        Thread.sleep(1000);
      }catch(InterruptedException e){e.printStackTrace();}

      if(fontSize++>40) fontSize=8;
    }
  }
}




/****************************************************
 * ���ߣ�������                                     *
 * ��Դ��<<Tomcat��Java Web�����������>>           *
 * ����֧����ַ��www.javathinker.org                *
 ***************************************************/
