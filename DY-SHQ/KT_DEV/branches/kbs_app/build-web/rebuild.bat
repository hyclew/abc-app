cd ..
call mvn clean install -Dmaven.test.skip=true 

del /Q build-web\lib\*

cd kbs-app-web-build

call mvn dependency:copy-dependencies -DoutputDirectory=..\build-web\lib -DincludeScope=runtime -Dsilent=true
cd ..
cd build-web


del /Q lib\spring-boot-*.*
del /Q lib\tomcat-embed-*.*