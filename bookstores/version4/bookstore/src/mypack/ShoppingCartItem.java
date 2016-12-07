package mypack;

public class ShoppingCartItem {
    BookDetails item;
    int quantity;
    
    public ShoppingCartItem(){}

    public ShoppingCartItem(BookDetails anItem) {
        item = anItem;
        quantity = 1;
    }

    public void incrementQuantity() {
        quantity++;
    }

    public void decrementQuantity() {
        quantity--;
    }

    public BookDetails getItem() {
        return item;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setItem(BookDetails item) {
        this.item=item;
    }

    public void setQuantity(int quantity) {
        this.quantity=quantity;
    }
}













/****************************************************
 * 作者：孙卫琴                                     *
 * 来源：<<Tomcat与Java Web开发技术详解>>           *
 * 技术支持网址：www.javathinker.org                *
 ***************************************************/
