package mypack;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.*;

public class ShoppingServlet extends HttpServlet{
  public void doGet(HttpServletRequest req, HttpServletResponse res)
  throws ServletException, java.io.IOException{
    String[] itemNames={"糖果","收音机","练习簿"};
    //获取会话对象
    HttpSession session=req.getSession(true);
     //获取会话范围内的ShoppingCart对象
    ShoppingCart cart=(ShoppingCart) session.getAttribute("cart");
    //如果会话范围没有ShoppingCart对象，就创建它，并把它存入会话范围
    if (cart==null){
      cart=new ShoppingCart();
      session.setAttribute("cart",cart);
    }

    res.setContentType("text/html;charset=GB2312");
    PrintWriter out=res.getWriter();

    //读取表单数据
    String[] itemsSelected;
    String itemIndex; //商品的索引
    String itemName;  //商品的名字
    itemsSelected=req.getParameterValues("item"); //读取复选框的数据
    
    if(itemsSelected !=null){
      for(int i=0;i<itemsSelected.length;i++){
        itemIndex=itemsSelected[i];  //获得选中的商品的索引
        itemName=itemNames[Integer.parseInt(itemIndex)];   
        //将选中的商品加入购物车
        cart.add(itemName);
      }

    }

    //打印购物车的内容
    out.println("<html>");
    out.println("<head>");
    out.println("<title>购物车的内容</title>");
    out.println("</head>");
    out.println("<body>");
    out.println("Session ID:"+session.getId()+"<br>");
 
    out.println("<center><h1>你的购物车有"+cart.getNumberOfItems()+"个商品： </h1></center>");
    
    Map<String,Integer> items=cart.getItems();
    Iterator<Map.Entry<String,Integer>> it=items.entrySet().iterator();    
    while(it.hasNext()){
      Map.Entry entry=it.next();  //entry表示Map中的一对键与值
      out.println(entry.getKey()+": "+entry.getValue()+"<br>");
    }
    out.println("<br><a href='shopping.htm'>继续购物</a><br>");

    out.println("</body>");
    out.println("</html>");
    out.close();
  }

  public void doPost(HttpServletRequest req, HttpServletResponse res)
  throws ServletException, java.io.IOException{
    doGet(req,res);
  }
}




/****************************************************
 * 作者：孙卫琴                                     *
 * 来源：<<Tomcat与Java Web开发技术详解>>           *
 * 技术支持网址：www.javathinker.org                *
 ***************************************************/
