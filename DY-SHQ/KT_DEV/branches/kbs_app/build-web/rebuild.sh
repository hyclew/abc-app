cd ..
svn up
mvn clean install 
mvn clean install -Dmaven.test.skip=true 
rm -f build-rest/lib/*

cd kbs-app-web-build
mvn dependency:copy-dependencies -DoutputDirectory=../build-web/lib -DincludeScope=runtime -Dsilent=true
cd ../build-web
call deploy
