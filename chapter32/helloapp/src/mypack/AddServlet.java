package mypack;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import org.apache.velocity.*;
import org.apache.velocity.context.*;
import org.apache.velocity.servlet.*;
import org.apache.velocity.app.*;
import org.apache.velocity.exception.*;

public class AddServlet extends VelocityServlet
{

  protected Properties loadConfiguration(ServletConfig config)
  throws IOException,FileNotFoundException{
  
    Properties p=new Properties();
    String path=config.getServletContext().getRealPath("/");
    if(path==null){
      System.out.println("VelocityAdd.loadConfiguration():"+
      "unable to get the current webapp root. Using '/'. "); 
      path="/";
    }
    p.setProperty(Velocity.FILE_RESOURCE_LOADER_PATH,path);
    p.setProperty("runtime.log",path+"velocity.log");
    
    return p;
  }
  
  public Template handleRequest(HttpServletRequest request, HttpServletResponse response,Context context){
  
    Template outty=null;
    
    try{
      int a=11;	
      int b=22;
      int c=a+b;
      context.put("a",new Integer(a));
      context.put("b",new Integer(b));
      context.put("c",new Integer(c));
      
      outty=getTemplate("add.vm");
    }catch(ParseErrorException ex1){
      System.out.println("VelocityAdd: parse error for template "+ex1);
    }catch(ResourceNotFoundException ex2){
      System.out.println("VelocityAdd: template not found "+ex2);
    }catch(Exception ex3){
      System.out.println("VelocityAdd: error "+ex3);
    }
    return outty;
  }

}



/****************************************************
 * 作者：孙卫琴                                     *
 * 来源：<<Tomcat与Java Web开发技术详解>>           *
 * 技术支持网址：www.javathinker.org                *
 ***************************************************/
