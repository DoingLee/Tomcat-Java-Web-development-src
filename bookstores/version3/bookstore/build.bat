set jboss_home=C:\jboss
set path=%path%;C:\jdk\bin

set currpath=.\
if "%OS%" == "Windows_NT" set currpath=%~dp0%

set src=%currpath%src
set dest=%currpath%bookdbejb
set classpath=%classpath%;%jboss_home%\server\default\lib\jboss-j2ee.jar

javac  -classpath %classpath% -sourcepath %src%  -d %dest% %src%\mypack\BookDetails.java

javac  -classpath %classpath% -sourcepath %src%  -d %dest% %src%\mypack\ShoppingCartItem.java

javac  -classpath %classpath% -sourcepath %src%  -d %dest% %src%\mypack\ShoppingCart.java

javac  -classpath %classpath% -sourcepath %src%  -d %dest% %src%\mypack\BookDBEJB.java

javac  -classpath %classpath% -sourcepath %src%  -d %dest% %src%\mypack\BookDBEJBHome.java

javac  -classpath %classpath% -sourcepath %src%  -d %dest% %src%\mypack\BookDBEJBImpl.java


copy %dest%\mypack  %currpath%\bookstorewar\WEB-INF\classes\mypack

cd %currpath%\bookdbejb
jar cvf %currpath%\bookstoreear\bookdbejb.jar *.*
cd ..
cd bookstorewar
jar cvf %currpath%\bookstoreear\bookstore.war *.*
cd ..
cd bookstoreear
jar cvf %currpath%\bookstore.ear *.*
