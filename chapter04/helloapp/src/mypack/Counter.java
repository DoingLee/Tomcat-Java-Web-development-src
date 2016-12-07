package mypack;
public class Counter{
  private int count; //计数值
  public Counter(){
    this(0);
  }
  public Counter(int count){
    this.count=count;
  }
  public void setCount(int count){
    this.count=count;
  }
  public int getCount(){
    return count;
  }
  
  public void add(int step){
    count+=step;
  }
}



/****************************************************
 * 作者：孙卫琴                                     *
 * 来源：<<Tomcat与Java Web开发技术详解>>           *
 * 技术支持网址：www.javathinker.org                *
 ***************************************************/
