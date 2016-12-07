package mypack;
import java.util.*;
import java.io.*;

public class ShoppingCart implements Serializable {
  Map<String,Integer> items = new HashMap<String,Integer>();
  int numberOfItems = 0;

  public synchronized void add(String itemName) {
    if(items.containsKey(itemName)) {
        Integer itemCount = (Integer) items.get(itemName);
        items.put(itemName,new Integer(itemCount+1));
    } else {
        items.put(itemName, new Integer(1));
    }

    numberOfItems++;
  }

  public synchronized int getNumberOfItems() {
      return numberOfItems;
  }

  public synchronized Map<String,Integer> getItems() {
      return items;
  }

}





/****************************************************
 * 作者：孙卫琴                                     *
 * 来源：<<Tomcat与Java Web开发技术详解>>           *
 * 技术支持网址：www.javathinker.org                *
 ***************************************************/
