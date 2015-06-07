cd ..
#svn up

mvn clean install -Dmaven.test.skip=true 
rm -f build-rest/lib/*

cd kbs-app-rest-build
mvn dependency:copy-dependencies -DoutputDirectory=../build-rest/lib -DincludeScope=runtime -Dsilent=true
cd ../build-rest
