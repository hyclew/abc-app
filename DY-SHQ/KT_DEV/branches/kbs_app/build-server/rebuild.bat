cd ..
call mvn clean install -Dmaven.test.skip=true 

del /Q build-server\lib\*

cd kbs-app-service-build

call mvn dependency:copy-dependencies -DoutputDirectory=..\build-server\lib -DincludeScope=runtime -Dsilent=true
cd ..
cd build-server

