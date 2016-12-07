package mypack;
import com.opensymphony.xwork2.ActionSupport;
public final class Login extends ActionSupport{

   public String execute() throws Exception{
     if(username==null || username.length()==0)
       username="Guest"; 
     
     authenticate(username,password);
     return SUCCESS;
  }

  private String username;

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  private String password;

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }
  
  public void authenticate(String username,String password)throws Exception{
    //实现对客户验证的业务逻辑，在实际应用中，需要检索数据库来实现此功能。
    //本例中直接返回。
    return;
  }
}




/****************************************************
 * 作者：孙卫琴                                     *
 * 来源：<<Tomcat与Java Web开发技术详解>>           *
 * 技术支持网址：www.javathinker.org                *
 ***************************************************/
