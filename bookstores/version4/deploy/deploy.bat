set currpath=.\
if "%OS%" == "Windows_NT" set currpath=%~dp0%
cd %currpath%

set classpath=lib/axis.jar;lib/axis-ant.jar;lib/commons-discovery-0.2.jar;lib/commons-logging-1.0.4.jar;lib/jaxrpc.jar;lib/saaj.jar;lib/log4j-1.2.8.jar;lib/wsdl4j-1.5.1.jar;lib/xerces.jar;lib/mail.jar;lib/activation.jar


rem this assumes webserver is running on port 8080

@echo .
@echo 1. deploy bookdbservice
java org.apache.axis.client.AdminClient deploy.wsdd 

