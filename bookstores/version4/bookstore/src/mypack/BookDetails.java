package mypack;
public class BookDetails implements Comparable {
    private String bookId = null;
    private String title = null;
    private String name = null;
    private float price = 0.0F;
    private int year = 0;
    private String description = null;
    private int saleAmount;
    
    public BookDetails(){}

    public BookDetails(String bookId, String name,  String title,
                       float price, int year, String description,int saleAmount) {
        this.bookId = bookId;
        this.title = title;
        this.name = name;
        this.price = price;
        this.year = year;
        this.description = description;
        this.saleAmount=saleAmount;
    }

    public String getTitle() {
        return title;
    }

    public float getPrice() {
       return price;
    }

    public int getYear() {
        return year;
    }

    public String getDescription() {
        return description;
    }

    public String getBookId() {
        return this.bookId;
    }

    public String getName() {
        return this.name;
    }

    public int getSaleAmount() {
      return saleAmount;
    }

    public void setTitle(String title) {
      this.title=title;
    }

    public void setPrice(float price) {
      this.price=price;
    }

    public void setYear(int year) {
      this.year=year;
    }

    public void setDescription(String description) {
      this.description=description;
    }

    public void setBookId(String bookId) {
      this.bookId=bookId;
    }

    public void setName(String name) {
      this.name=name;
    }

    public void setSaleAmount(int saleAmount){
      this.saleAmount=saleAmount;
    }

    public int compareTo(Object o) {
         BookDetails n = (BookDetails)o;
         int lastCmp = title.compareTo(n.title);
            return (lastCmp);
    }
}





/****************************************************
 * 作者：孙卫琴                                     *
 * 来源：<<Tomcat与Java Web开发技术详解>>           *
 * 技术支持网址：www.javathinker.org                *
 ***************************************************/
