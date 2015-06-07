#!/bin/sh
PID_FILE=bks-server.pid
# resolve links - $0 may be a softlink
PRG="$0"

while [ -h "$PRG" ]; do
  ls='ls -ld "$PRG"'
  link='expr "$ls" : '.*-> \(.*\)$''
  if expr "$link" : '/.*' > /dev/null; then
    PRG="$link"
  else
    PRG='dirname "$PRG"'/"$link"
  fi
done

# Get standard environment variables
KBS_HOME="/home/kbs_app_project/kingteller-app-projects/kbs-app/build-server"
PRGDIR='dirname "$PRG"'

# Only set CATALINA_HOME if not already set
[ -z "$KBS_HOME" ] && KBS_HOME=' cd "$PRGDIR" >/dev/null; pwd '

KBS_CP=.:$KBS_HOME/conf

export KBS_CP
echo "KBS_HOME: $KBS_HOME"
	

for file in $(find $KBS_HOME/lib -name *jar | sort) ;
do
        KBS_CP=$KBS_CP:$file;
done;

echo "KBS_CP: $KBS_CP"
export KBS_CP

shift
mv kbs.log kbs.log.'date +%y-%m-%d-%H-%M' 2> /dev/null
java -Xms2048m -Xmx2048m -XX:NewRatio=3 -XX:SurvivorRatio=4 -XX:MaxTenuringThreshold=4 -XX:TargetSurvivorRatio=90 -XX:+PrintTenuringDistribution -XX:+PrintGCDetails -XX:+PrintGCTimeStamps -cp $KBS_CP com.kingteller.bs.service.impl.setup.AppServiceSetup
echo $! > $PID_FILE
exit 0;
