
package mytaglib;
public class Parameter {

    private String name;
    private boolean isDirect;
    private String value;

    public Parameter(String name,  String value, boolean isDirect) {
        this.name = name;
        this.isDirect = isDirect;
        this.value = value;
    }

    public String getName() {
        return name;
    } 

    public boolean isDirect() {
        return isDirect;
    }

    public String getValue() {
        return value;
    }
}




/****************************************************
 * 作者：孙卫琴                                     *
 * 来源：<<Tomcat与Java Web开发技术详解>>           *
 * 技术支持网址：www.javathinker.org                *
 ***************************************************/
