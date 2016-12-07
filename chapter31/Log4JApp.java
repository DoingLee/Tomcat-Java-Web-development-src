
import org.apache.log4j.Logger;
import org.apache.log4j.Priority;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.PropertyConfigurator;

public class Log4JApp {

  // Get an instance of the helloappLogger
  static Logger helloappLogger =
    Logger.getLogger("helloappLogger");
  // Get an instance of the childLogger
  static Logger childLogger =
    Logger.getLogger("helloappLogger.childLogger");

  public static void main(String[] args) {

    // Load the properties using the PropertyConfigurator
    PropertyConfigurator.configure("properties.lcf");

    // Log Messages using the Parent Logger
    helloappLogger.debug("This is a log message from the " +
      helloappLogger.getName());
    helloappLogger.info("This is a log message from the " +
      helloappLogger.getName());
    helloappLogger.warn("This is a log message from the " +
      helloappLogger.getName());
    helloappLogger.error("This is a log message from the " +
      helloappLogger.getName());
    helloappLogger.fatal("This is a log message from the " +
      helloappLogger.getName());


    // Log Messages using the Child Logger
    childLogger.debug("This is a log message from the " +
      childLogger.getName());
    childLogger.info("This is a log message from the " +
      childLogger.getName());
    childLogger.warn("This is a log message from the " +
      childLogger.getName());
    childLogger.error("This is a log message from the " +
      childLogger.getName());
    childLogger.fatal("This is a log message from the " +
      childLogger.getName());
  }
}




/****************************************************
 * 作者：孙卫琴                                     *
 * 来源：<<Tomcat与Java Web开发技术详解>>           *
 * 技术支持网址：www.javathinker.org                *
 ***************************************************/
