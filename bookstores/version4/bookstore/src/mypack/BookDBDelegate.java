package mypack;
import java.util.*;
import org.apache.axis.client.Call;
import org.apache.axis.client.Service;
import org.apache.axis.encoding.ser.BeanDeserializerFactory;
import org.apache.axis.encoding.ser.BeanSerializerFactory;
import javax.xml.namespace.QName;
import javax.xml.rpc.ParameterMode;

public class BookDBDelegate {
  String endpoint;
  Service service;
  String ns="http://soapinterop.org/xsd";
  public BookDBDelegate() throws Exception{
    endpoint="http://localhost:8080/axis/services/bookdbservice";
    service = new Service();
  }

  public int getNumberOfBooks() throws Exception {
    Call call=(Call)service.createCall();
    call.setTargetEndpointAddress( new java.net.URL(endpoint) );
    call.setOperationName(new QName("urn:bookdbservice", "getNumberOfBooks") );
    Integer result = (Integer) call.invoke( new Object[] {} );
    return result.intValue();
  }

  public Collection getBooks()throws Exception{
    Call call=(Call)service.createCall();
    call.setTargetEndpointAddress( new java.net.URL(endpoint) );
    call.setOperationName(new QName("urn:bookdbservice", "getBooks") );

    QName qn = new QName(ns,"BookDetails");
    Class cls = BookDetails.class;
    call.registerTypeMapping(cls, qn,
      new org.apache.axis.encoding.ser.BeanSerializerFactory(cls, qn),
      new org.apache.axis.encoding.ser.BeanDeserializerFactory(cls, qn));


    qn = new QName(ns,"BookDetailsArray");
   
    cls = BookDetails[].class;
    call.registerTypeMapping(cls, qn,
      new org.apache.axis.encoding.ser.ArraySerializerFactory(cls, qn),
      new org.apache.axis.encoding.ser.ArrayDeserializerFactory(qn));

    call.setReturnType(qn,BookDetails[].class);
    BookDetails[] result = (BookDetails[]) call.invoke( new Object[] {} );

    ArrayList list=new ArrayList();
    for(int i=0;i<result.length;i++)
      list.add(result[i]);
    return list;
  }

  public BookDetails getBookDetails(String bookId) throws Exception {
    Call call=(Call)service.createCall();
    call.setTargetEndpointAddress( new java.net.URL(endpoint) );
    call.setOperationName(new QName("urn:bookdbservice", "getBookDetails") );


    QName qn = new QName(ns,"BookDetails");
    Class cls = BookDetails.class;
    call.registerTypeMapping(cls, qn,
      new org.apache.axis.encoding.ser.BeanSerializerFactory(cls, qn),
      new org.apache.axis.encoding.ser.BeanDeserializerFactory(cls, qn));
    
    call.addParameter( "arg1",  org.apache.axis.encoding.XMLType.XSD_STRING , 
              ParameterMode.IN );

    call.setReturnType(qn,BookDetails.class);
    BookDetails result = (BookDetails) call.invoke( new Object[]{bookId} );
    return result;
  }

  public void buyBooks(ShoppingCart cart)throws Exception {
    Call call=(Call)service.createCall();
    call.setTargetEndpointAddress( new java.net.URL(endpoint) );
    call.setOperationName(new QName("urn:bookdbservice", "buyBooks") );
 
    QName qn = new QName(ns,"BookDetails");
    Class cls = BookDetails.class;
    call.registerTypeMapping(cls, qn,
      new org.apache.axis.encoding.ser.BeanSerializerFactory(cls, qn),
      new org.apache.axis.encoding.ser.BeanDeserializerFactory(cls, qn));

    qn = new QName(ns,"ShoppingCartItem");
    cls = ShoppingCartItem.class;
    call.registerTypeMapping(cls, qn,
      new org.apache.axis.encoding.ser.BeanSerializerFactory(cls, qn),
      new org.apache.axis.encoding.ser.BeanDeserializerFactory(cls, qn));

    qn = new QName(ns,"ShoppingCartItemArray");
    cls = ShoppingCartItem[].class;
    call.registerTypeMapping(cls, qn,
      new org.apache.axis.encoding.ser.ArraySerializerFactory(cls, qn),
      new org.apache.axis.encoding.ser.ArrayDeserializerFactory(qn));
    
    Collection c = cart.getItems();
    ShoppingCartItem[] items=new ShoppingCartItem[c.size()];
    Iterator it =c.iterator();
    int i=0;
    while (it.hasNext()) 
      items[i++]=(ShoppingCartItem)it.next();
    
    
    call.invoke(new Object[]{items} );
  }

}




/****************************************************
 * 作者：孙卫琴                                     *
 * 来源：<<Tomcat与Java Web开发技术详解>>           *
 * 技术支持网址：www.javathinker.org                *
 ***************************************************/
