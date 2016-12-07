
package mypack;
import javax.mail.*;
import javax.mail.internet.*;
import java.util.*;
import java.text.*;

public class PMessage{

  private String subject="";  //邮件标题
  private String from=""; //邮件发送者地址
  private String to="";  //邮件接收地址列表
  private String cc="";  //邮件抄送地址列表
  private String bcc=""; //邮件广播地址列表
  private String date=new Date().toString(); //邮件发送或接收日期
  private int size=0; //邮件大小
  private String text=""; //邮件正文
  private boolean readFlag; //邮件是否已读标志

  public PMessage(){}

  public PMessage(Message msg)throws Exception{
    if(msg!=null){
      SimpleDateFormat df = new SimpleDateFormat("yy.MM.dd 'at' HH:mm:ss ");
      try{
        date=df.format(
          (msg.getSentDate()!=null) ? msg.getSentDate() : msg.getReceivedDate());
      }catch(Exception e){date=new Date().toString();}
        
      subject=msg.getSubject();
      size=msg.getSize();
      Object content=null;
      try{
        content=msg.getContent();
      }catch(Exception e){}
        
      if(msg.isMimeType("text/plain") && content!=null)
        text=(String)content;
        
      from=assembleAddress(msg.getFrom());
      to=assembleAddress(msg.getRecipients(Message.RecipientType.TO));
      cc=assembleAddress(msg.getRecipients(Message.RecipientType.CC));
      bcc=assembleAddress(msg.getRecipients(Message.RecipientType.BCC));
    }
  }

  public PMessage(String to,String cc,String bcc,String subj,String text){
    to.replace(';',',');
    cc.replace(';',',');
    bcc.replace(';',',');
    this.to=to;
    this.cc=cc;
    this.bcc=bcc;
    this.subject=subj;
    this.text=text;
  }

  //把Address数组中的邮件地址列表转换为字符串 ，邮件地址之间以逗号分割 
  private String assembleAddress(Address[] addr){
    if(addr==null)return "";

    String addrString="";
    boolean tf = true;
    for(int i = 0; i < addr.length; i++) {
      addrString=addrString+((tf) ? " " : ", ") + getDisplayAddress(addr[i]);
      tf = false;
    }
    
    return addrString;
  }

  //返回字符串形式的邮件地址，用于输出到网页上
  private String getDisplayAddress(Address a) {
    String pers = null;
    String addr = null;
    if(a instanceof InternetAddress &&
            ((pers = ((InternetAddress)a).getPersonal()) != null)) {
      addr = pers + "  "+"&lt;"+((InternetAddress)a).getAddress()+"&gt;";
    }else
      addr = a.toString();

    return addr;
  }

  public String getFrom(){return from;}

  public void setFrom(String from){
    this.from=from==null ? "" : from;
   }

  public String getTo(){return to;}

  public void setTo(String to){
    this.to=to==null ? "" : to;
  }

  public String getCC(){return cc;}
  
  public void setCC(String cc){
    this.cc=cc==null ? "" : cc;
  }

  public String getBCC(){return bcc;}

  public void setBCC(String bcc){
    this.bcc=bcc==null ? "" : bcc;
  }

  public int getSize(){return size;}

  public void setSize(int size){this.size=size;}

  public String getDate(){return date;}

  public void setDate(String date){this.date=date;}

  public String getSubject(){return subject;}

  public void setSubject(String subject){
    this.subject=subject==null ? "" : subject;
  }

  public String getText(){return text;}

  public void setText(String text){
   this.text=text==null ? "" : text;
  }

  public boolean getReadFlag(){return readFlag;}

  public void setReadFlag(boolean readFlag){
    this.readFlag=readFlag;
  }
}




/****************************************************
 * 作者：孙卫琴                                     *
 * 来源：<<Tomcat与Java Web开发技术详解>>           *
 * 技术支持网址：www.javathinker.org                *
 ***************************************************/
