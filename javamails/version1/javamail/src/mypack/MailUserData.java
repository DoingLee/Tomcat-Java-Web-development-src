package mypack;

/**
 * This class is used to store session data for each user's session. It
 * is stored in the HttpSession.
 */
import javax.mail.*;
import javax.mail.internet.*;
import javax.activation.*;

public class MailUserData {
  URLName urlName;
  Session session;
  Store store;
  Folder currFolder;
  Message currMsg;

  public MailUserData() { }

  public URLName getURLName() {
    return urlName;
  }

  public void setURLName(URLName url){
    urlName=url;
  }

  public Session getSession() {
    return session;
  }

  public void setSession(Session s) {
    session = s;
  }

  public Message getCurrMsg() {
    return currMsg;
  }

  public void setCurrMsg(Message s) {
    currMsg = s;
  }

  public Store getStore() {
    return store;
  }

  public void setStore(Store s) {
    store = s;
  }

  public Folder getCurrFolder() {
    return currFolder;
  }

  public void setCurrFolder(Folder f) {
    currFolder = f;
  }

  public void doDeleteFolder(String foldername )throws Exception {

    //can't delete reserved folder
    if(foldername.equalsIgnoreCase("inbox")||
               foldername.equalsIgnoreCase("trash")||
               foldername.equalsIgnoreCase("draft")||
               foldername.equalsIgnoreCase("sendbox")){
      throw new Exception("Cann't delete reserved folder");
    }

    Folder folder=store.getFolder(foldername);
    if(!folder.exists())throw new Exception("This folder does not exists");
    if(folder.isOpen())folder.close(true);
    folder.delete(true);
  }

  public void doCreateFolder(String foldername)throws Exception {
    if(foldername==null || foldername.equals(""))
      throw new Exception("You do not input new folder name when creating folder");
    Folder folder=store.getFolder(foldername);
    if(folder.exists())throw new Exception("This folder already exists");
    folder.create(Folder.HOLDS_MESSAGES);
  }

  public void doRenameFolder(String fromname,String toname)throws Exception {

    if(toname==null || toname.equals(""))
      throw new Exception("You do not input new folder name when renaming folder");
    
    //can't rename reserved folder
    if(fromname.equalsIgnoreCase("inbox")||
         fromname.equalsIgnoreCase("trash")||
         fromname.equalsIgnoreCase("draft")||
         fromname.equalsIgnoreCase("sendbox")||
         toname.equalsIgnoreCase("inbox")||
         toname.equalsIgnoreCase("trash")||
         toname.equalsIgnoreCase("draft")||
         toname.equalsIgnoreCase("sendbox")){
       throw new Exception("Cann't rename reserved folder");
    }

    Folder folderFrom=store.getFolder(fromname);
    Folder folderTo=store.getFolder(toname);
    if(!folderFrom.exists())throw new Exception("This folder does not exists");
    if(folderFrom.isOpen())folderFrom.close(true);

    folderFrom.renameTo(folderTo);
  }

  public void doDeleteMessage(int arrayOpt[],Folder f)throws Exception {
    for(int i=0;i<arrayOpt.length;i++){

      if(arrayOpt[i]==0)continue;
      Message msg=f.getMessage(i+1);
      if(!f.getName().equals("Trash")){
        Message[] m=new Message[1];
        m[0]=msg;
        Folder Trash=store.getFolder("Trash");
        f.copyMessages(m,Trash);
        msg.setFlag(Flags.Flag.DELETED, true);
      }else{
        msg.setFlag(Flags.Flag.DELETED, true);
      }
    }
    f.expunge();
  }

  public Message doAssembleMessage(PMessage msg)throws Exception {
    return doAssembleMessage(msg.getTo(),msg.getCC(),msg.getBCC(),msg.getSubject(),msg.getText());
  }

  public Message doAssembleMessage(String to,String cc,String bcc,String subj,String text)throws Exception {

    Message msg = new MimeMessage(session);
    InternetAddress[] toAddrs = null, ccAddrs = null, bccAddrs=null;

    if (to != null) {
      toAddrs = InternetAddress.parse(to, false);
      msg.setRecipients(Message.RecipientType.TO, toAddrs);
    }else
      throw new MessagingException("No \"To\" address specified");

    if (cc != null) {
	ccAddrs = InternetAddress.parse(cc, false);
	msg.setRecipients(Message.RecipientType.CC, ccAddrs);
    }

    if (bcc != null) {
	bccAddrs = InternetAddress.parse(bcc, false);
	msg.setRecipients(Message.RecipientType.BCC, bccAddrs);
    }

    if (subj != null)
	msg.setSubject(subj);

    msg.setFrom(new InternetAddress(urlName.getUsername() + "@" +
					        urlName.getHost()));

    if (text != null)
	msg.setText(text);

    return msg;
  }
  
  public void doSendMessage(PMessage pmsg)throws Exception {

    Message msg=doAssembleMessage(pmsg);

    //send message
    Transport.send(msg);

    //save message in sendbox folder
    Folder f=store.getFolder("SendBox");
    if(!f.isOpen())f.open(Folder.READ_WRITE);
    doAppendMessage(msg,f);
  }
    
  public void doAppendMessage(Message msg, Folder f)throws Exception{
    Message m[]=new Message[1];
    m[0]=msg;
    f.appendMessages(m);
  }

  public void doSaveMessage(PMessage pmsg)throws Exception {
    Message msg=doAssembleMessage(pmsg);
    //save message in draft folder
    Folder f=store.getFolder("Draft");
    if(!f.isOpen())f.open(Folder.READ_WRITE);
    doAppendMessage(msg,f);
  }

  public void doMoveMessage(String toFolderName)throws Exception {
    Folder folderFrom=currFolder;
    Folder folderTo=store.getFolder(toFolderName);
    if(!folderTo.exists())throw new Exception("Folder does not exist");
    Message[] m=new Message[1];
    m[0]=currMsg;
    folderFrom.copyMessages(m,folderTo);
    currMsg.setFlag(Flags.Flag.DELETED, true);
    folderFrom.expunge();
  }
}





/****************************************************
 * 作者：孙卫琴                                     *
 * 来源：<<Tomcat与Java Web开发技术详解>>           *
 * 技术支持网址：www.javathinker.org                *
 ***************************************************/
