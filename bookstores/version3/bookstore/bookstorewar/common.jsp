<%@ page import="mypack.*" %>
<%@ page import="java.util.Properties" %>
<%@ page errorPage="errorpage.jsp" %>
<%@ page import="javax.ejb.*, javax.naming.*, javax.rmi.PortableRemoteObject, java.rmi.RemoteException" %>
<%!
    private BookDBEJB bookDB;

    public void jspInit() {

      bookDB =
          (BookDBEJB)getServletContext().getAttribute("bookDB");

      if (bookDB == null) {
        try {
          InitialContext ic = new InitialContext();
          Object objRef = ic.lookup("java:comp/env/ejb/BookDBEJB");
          BookDBEJBHome home = (BookDBEJBHome)PortableRemoteObject.narrow(objRef,
          	mypack.BookDBEJBHome.class);
          bookDB = home.create();
          getServletContext().setAttribute("bookDB", bookDB);
        } catch (RemoteException ex) {
            System.out.println("Couldn't create database bean." + ex.getMessage());
        } catch (CreateException ex) {
            System.out.println("Couldn't create database bean." + ex.getMessage());
        } catch (NamingException ex) {
            System.out.println("Unable to lookup home: "+ "java:comp/env/ejb/BookDBEJB."+ ex.getMessage());
        }
      }
    }

   public void jspDestroy() {
      bookDB = null;
   }

 public String convert(String s){
    try{
	return new String(s.getBytes("ISO-8859-1"),"GB2312");
    }catch(Exception e){return null;}
   }


%>
