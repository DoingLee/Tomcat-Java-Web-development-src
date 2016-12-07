

package mypack;

import java.util.*;
import javax.ejb.*;
import java.rmi.RemoteException;


public interface BookDBEJB extends EJBObject {
  public BookDetails getBookDetails(String bookId) throws RemoteException;
  public int getNumberOfBooks() throws RemoteException;
  public Collection getBooks() throws RemoteException;
  public void buyBooks(ShoppingCart cart)throws RemoteException;
}




/****************************************************
 * 作者：孙卫琴                                     *
 * 来源：<<Tomcat与Java Web开发技术详解>>           *
 * 技术支持网址：www.javathinker.org                *
 ***************************************************/
