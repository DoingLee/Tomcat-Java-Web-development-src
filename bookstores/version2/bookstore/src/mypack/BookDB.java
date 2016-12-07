/** access mysql database through JDBC Driver */
package mypack;
import java.sql.*;
import javax.naming.*;
import javax.sql.*;
import java.util.*;

public class BookDB {

  private String dbUrl =  "jdbc:mysql://localhost:3306/BookDB";
  private String dbUser="dbuser";
  private String dbPwd="1234";

  public BookDB () throws Exception{
     Class.forName("com.mysql.jdbc.Driver");
  }

  public Connection getConnection()throws Exception{
      return java.sql.DriverManager.getConnection(dbUrl,dbUser,dbPwd);
  }

  public void closeConnection(Connection con){
    try{
        if(con!=null) con.close();
      }catch(Exception e){
        e.printStackTrace();
      }
  }

  public void closePrepStmt(PreparedStatement prepStmt){
    try{
        if(prepStmt!=null) prepStmt.close();
      }catch(Exception e){
        e.printStackTrace();
      }
  }

  public void closeResultSet(ResultSet rs){
    try{
        if(rs!=null) rs.close();
      }catch(Exception e){
        e.printStackTrace();
      }
  }

  public int getNumberOfBooks() throws Exception {
    Connection con=null;
    PreparedStatement prepStmt=null;
    ResultSet rs=null;
    int count=0;

    try {
      con=getConnection();
      String selectStatement = "select count(*) " + "from BOOKS";
      prepStmt = con.prepareStatement(selectStatement);
      rs = prepStmt.executeQuery();

      if (rs.next()) 
        count = rs.getInt(1);
 
    }finally{
      closeResultSet(rs);
      closePrepStmt(prepStmt);
      closeConnection(con);
    }
    return count;
  }

  public Collection getBooks()throws Exception{
    Connection con=null;
    PreparedStatement prepStmt=null;
    ResultSet rs =null;
    ArrayList books = new ArrayList();
    try {
      con=getConnection();
      String selectStatement = "select * " + "from BOOKS";
      prepStmt = con.prepareStatement(selectStatement);
      rs = prepStmt.executeQuery();

      while (rs.next()) {

        BookDetails bd = new BookDetails(rs.getString(1), rs.getString(2), rs.getString(3),
           rs.getFloat(4), rs.getInt(5), rs.getString(6),rs.getInt(7));
        books.add(bd);
      }

    }finally{
      closeResultSet(rs);
      closePrepStmt(prepStmt);
      closeConnection(con);
    }

    Collections.sort(books);
    return books;
  }

  public BookDetails getBookDetails(String bookId) throws Exception {
    Connection con=null;
    PreparedStatement prepStmt=null;
    ResultSet rs =null;
    try {
      con=getConnection();
      String selectStatement = "select * " + "from BOOKS where ID = ? ";
      prepStmt = con.prepareStatement(selectStatement);
      prepStmt.setString(1, bookId);
      rs = prepStmt.executeQuery();

      if (rs.next()) {
        BookDetails bd = new BookDetails(rs.getString(1), rs.getString(2), rs.getString(3),
          rs.getFloat(4), rs.getInt(5), rs.getString(6),rs.getInt(7));
        prepStmt.close();

        return bd;
      }
      else {
        return null;
      }
    }finally{
      closeResultSet(rs);
      closePrepStmt(prepStmt);
      closeConnection(con);
    }
  }

  public void buyBooks(ShoppingCart cart)throws Exception {
    Connection con=null;
    Collection items = cart.getItems();
    Iterator i = items.iterator();
    try {
      con=getConnection();
      con.setAutoCommit(false);
      while (i.hasNext()) {
        ShoppingCartItem sci = (ShoppingCartItem)i.next();
        BookDetails bd = (BookDetails)sci.getItem();
        String id = bd.getBookId();
        int quantity = sci.getQuantity();
        buyBook(id, quantity,con);
      }
      con.commit();
      con.setAutoCommit(true);

    } catch (Exception ex) {
      con.rollback();
      throw ex;
    }finally{
       closeConnection(con);
    }
  }


  public void buyBook(String bookId, int quantity,Connection con) throws Exception {
    PreparedStatement prepStmt=null;
    ResultSet rs=null;
    try{
      String selectStatement = "select * " + "from BOOKS where ID = ? ";
      prepStmt = con.prepareStatement(selectStatement);
      prepStmt.setString(1, bookId);
      rs = prepStmt.executeQuery();

      if (rs.next()) {
          prepStmt.close();
          String updateStatement =
                  "update BOOKS set SALE_AMOUNT = SALE_AMOUNT + ? where ID = ?";
          prepStmt = con.prepareStatement(updateStatement);
          prepStmt.setInt(1, quantity);
          prepStmt.setString(2, bookId);
          prepStmt.executeUpdate();
          prepStmt.close();
       }

    }finally{
      closeResultSet(rs);
      closePrepStmt(prepStmt);
    }
  }

}




/****************************************************
 * 作者：孙卫琴                                     *
 * 来源：<<Tomcat与Java Web开发技术详解>>           *
 * 技术支持网址：www.javathinker.org                *
 ***************************************************/
