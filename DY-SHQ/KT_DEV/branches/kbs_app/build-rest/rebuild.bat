cd ..
call mvn clean install -Dmaven.test.skip=true 

del /Q build-rest\lib\*

cd kbs-app-rest-build

call mvn dependency:copy-dependencies -DoutputDirectory=..\build-rest\lib -DincludeScope=runtime -Dsilent=true
cd ..
cd build-rest