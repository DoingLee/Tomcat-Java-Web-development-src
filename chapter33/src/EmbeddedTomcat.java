import java.net.URL;
import java.net.InetAddress ;
import org.apache.catalina.connector.Connector;
import org.apache.catalina.Context;
import org.apache.catalina.Engine;
import org.apache.catalina.Host;
import org.apache.catalina.startup.Embedded;
import org.apache.catalina.Container;

public class EmbeddedTomcat {

  private String path = null;
  private Embedded embedded = null;
  private Host host = null;

  public EmbeddedTomcat() { }

  /** 设置Tomcat的根路径 */
  public void setPath(String path) {
    this.path = path;
  }

  /** 返回Tomcat的根路径 */
  public String getPath() {
    return path;
  }

  /** 启动Tomcat服务器 */
  public void startTomcat() throws Exception {

    Engine engine = null;

    //设置catalina.home系统属性
    System.setProperty("catalina.home", getPath());

    //创建嵌入式Tomcat服务器
    embedded = new Embedded();

    //创建Engine实例
    engine = embedded.createEngine();
    engine.setDefaultHost("localhost");

    //创建默认的Host实例
    host = embedded.createHost("localhost", getPath() + "/webapps");
    engine.addChild(host);

    //创建ROOT context
    Context context = embedded.createContext("",  getPath() + "webapps/ROOT");
    host.addChild(context);

    //创建examples context
    Context examplesContext = embedded.createContext("/examples",
     getPath() + "webapps/examples");
    host.addChild(examplesContext);

    //把Engine实例加入到嵌入式Tomcat服务器
    embedded.addEngine(engine);

    //创建和安装默认的HTTP connector
    InetAddress addr=null;
    Connector connector = embedded.createConnector(addr, 8080, false);
    embedded.addConnector(connector);

    //启动嵌入式Tomcat服务器
    embedded.start();
  }

  /** 终止嵌入式Tomcat服务器  */
  public void stopTomcat() throws Exception {
    embedded.stop();
  }

  public static void main(String args[]) {
    try {
      EmbeddedTomcat tomcat = new EmbeddedTomcat();
      String rootpath=null;
	if(args.length>0)
	   rootpath=args[0];
	else
         throw new Exception("Tomcat's root path is unknown.");
      tomcat.setPath(rootpath);
      tomcat.startTomcat();
      Thread.sleep(1000*60*60); //睡眠1小时
      tomcat.stopTomcat();
      System.exit(0);
    }
    catch( Exception e ) {
      e.printStackTrace();
    }
  }
}




/****************************************************
 * 作者：孙卫琴                                     *
 * 来源：<<Tomcat与Java Web开发技术详解>>           *
 * 技术支持网址：www.javathinker.org                *
 ***************************************************/
