package mypack;
import java.util.*;
import java.sql.*;
import javax.sql.*;
import javax.naming.*;
import javax.ejb.*;

public class BookDBEJBImpl implements SessionBean {
  private Connection con = null;
  private String dbUrl =  "jdbc:mysql://localhost:3306/BookDB";
  private String dbUser="dbuser";
  private String dbPwd="1234";

  public void ejbCreate() throws CreateException {
    try{
      Class.forName("com.mysql.jdbc.Driver");
      con = java.sql.DriverManager.getConnection(dbUrl,dbUser,dbPwd);

    }catch(Exception ex) {
      throw new CreateException("Couldn't create bean: " + ex.getMessage());
    }
  }

  public void ejbRemove() throws EJBException {
    try{
      con.close();
    }catch(SQLException ex) {
      throw new EJBException("unsetEntityContext: " + ex.getMessage());
    }
    con = null;
  }

  public BookDBEJBImpl() {}
  public void ejbActivate() {}
  public void ejbPassivate() {}
  public void setSessionContext(SessionContext sc) {}


  public int getNumberOfBooks()  {
    int count=0;
    try {
      String selectStatement = "select count(*) " + "from BOOKS";
      PreparedStatement prepStmt = con.prepareStatement(selectStatement);
      ResultSet rs = prepStmt.executeQuery();

      if (rs.next())
        count=rs.getInt(1);

      prepStmt.close();
    }catch(SQLException ex) {
      ex.printStackTrace();
    }

    return count;
  }

  public Collection getBooks() {
    ArrayList books = new ArrayList();
    try{
      String selectStatement = "select * " + "from BOOKS";
      PreparedStatement prepStmt = con.prepareStatement(selectStatement);
      ResultSet rs = prepStmt.executeQuery();

      while (rs.next()) {

        BookDetails bd = new BookDetails(rs.getString(1), rs.getString(2), rs.getString(3),
           rs.getFloat(4), rs.getInt(5), rs.getString(6),rs.getInt(7));
        books.add(bd);
      }

      prepStmt.close();
    }catch(SQLException ex) {
      ex.printStackTrace();
    }

    Collections.sort(books);
    return books;
  }

  public BookDetails getBookDetails(String bookId)  {
    try{
      String selectStatement = "select * " + "from BOOKS where ID = ? ";
      PreparedStatement prepStmt = con.prepareStatement(selectStatement);
      prepStmt.setString(1, bookId);
      ResultSet rs = prepStmt.executeQuery();

      if (rs.next()) {
        BookDetails bd = new BookDetails(rs.getString(1), rs.getString(2), rs.getString(3),
          rs.getFloat(4), rs.getInt(5), rs.getString(6),rs.getInt(7));
        prepStmt.close();

        return bd;
      }
      else {
        prepStmt.close();
        return null;
      }
    }catch(SQLException ex) {
      return null;
    }
  }

  public void buyBooks(ShoppingCart cart) {
    Collection items = cart.getItems();
    Iterator i = items.iterator();
    try{
      con.setAutoCommit(false);
      while (i.hasNext()) {
        ShoppingCartItem sci = (ShoppingCartItem)i.next();
        BookDetails bd = (BookDetails)sci.getItem();
        String id = bd.getBookId();
        int quantity = sci.getQuantity();
        buyBook(id, quantity);
      }
      con.commit();
      con.setAutoCommit(true);

    }catch(Exception ex) {
      ex.printStackTrace();
    }
  }


  public boolean buyBook(String bookId, int quantity)  {
    try{
      String selectStatement = "select * " + "from BOOKS where ID = ? ";
      PreparedStatement prepStmt = con.prepareStatement(selectStatement);
      prepStmt.setString(1, bookId);
      ResultSet rs = prepStmt.executeQuery();
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
    }catch(Exception ex) {ex.printStackTrace();}

    return false;
  }

}







/****************************************************
 * 作者：孙卫琴                                     *
 * 来源：<<Tomcat与Java Web开发技术详解>>           *
 * 技术支持网址：www.javathinker.org                *
 ***************************************************/
