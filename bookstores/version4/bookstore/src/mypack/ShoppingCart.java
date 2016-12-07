package mypack;

import java.util.*;

public class ShoppingCart {
  HashMap items;
  int numberOfItems = 0;

  public ShoppingCart() {
    items = new HashMap();
  }

  public synchronized void add(String bookId, BookDetails book) {
    if(items.containsKey(bookId)) {
        ShoppingCartItem scitem = (ShoppingCartItem) items.get(bookId);
        scitem.incrementQuantity();
    } else {
        ShoppingCartItem newItem = new ShoppingCartItem(book);
        items.put(bookId, newItem);
    }

    numberOfItems++;
  }

  public synchronized void remove(String bookId) {
    if(items.containsKey(bookId)) {
        ShoppingCartItem scitem = (ShoppingCartItem) items.get(bookId);
        scitem.decrementQuantity();

        if(scitem.getQuantity() <= 0)
            items.remove(bookId);

        numberOfItems--;
    }
  }

  public synchronized Collection getItems() {
      return items.values();
  }

  protected void finalize() throws Throwable {
      items.clear();
  }

  public synchronized int getNumberOfItems() {
      return numberOfItems;
  }
  public synchronized double getTotal() {
    double amount = 0.0;

    for(Iterator i = getItems().iterator(); i.hasNext(); ) {
        ShoppingCartItem item = (ShoppingCartItem) i.next();
        BookDetails bookDetails = (BookDetails) item.getItem();

        amount += item.getQuantity() * bookDetails.getPrice();
    }
    return roundOff(amount);
  }

  private double roundOff(double x) {
      long val = Math.round(x*100); // cents
      return val/100.0;
  }

  public synchronized void clear() {
      items.clear();
      numberOfItems = 0;
  }

  public void setItems(HashMap items){
     this.items=items;
  }
   
  public void setNumberOfItems(int numberOfItems){
    this.numberOfItems=numberOfItems;
  }

}





/****************************************************
 * 作者：孙卫琴                                     *
 * 来源：<<Tomcat与Java Web开发技术详解>>           *
 * 技术支持网址：www.javathinker.org                *
 ***************************************************/
