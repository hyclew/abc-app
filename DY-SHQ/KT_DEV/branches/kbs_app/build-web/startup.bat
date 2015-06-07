@echo off
set libpath=./restlib
for /R %~dp0 %%c in (*.jar) do call getlibpath %%c

echo on
java -Xmx512m -XX:NewRatio=3 -XX:SurvivorRatio=4 -XX:+PrintGCDetails -XX:+PrintGCTimeStamps -cp %libpath% com.kingteller.bs.rest.setup.AppRestSetup
pause