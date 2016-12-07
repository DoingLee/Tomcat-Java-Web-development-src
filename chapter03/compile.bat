set catalina_home=C:\tomcat
set path=%path%;C:\jdk\bin

set currpath=.\
if "%OS%" == "Windows_NT" set currpath=%~dp0%


set src=%currpath%helloapp\src
set dest=%currpath%helloapp\WEB-INF\classes
set classpath=%catalina_home%\lib\servlet-api.jar;%catalina_home%\lib\jsp-api.jar

javac   -sourcepath %src%  -d %dest% %src%\mypack\DispatcherServlet.java

javac   -sourcepath %src%  -d %dest% %src%\mypack\HelloTag.java
