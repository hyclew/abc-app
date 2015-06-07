cd ..
svn up
mvn clean install 
mvn clean install -Dmaven.test.skip=true 
rm -f build-server/lib/*
cd package
mvn dependency:copy-dependencies -DoutputDirectory=../build-server/lib -DincludeScope=runtime -Dsilent=true
cd ../build-server
