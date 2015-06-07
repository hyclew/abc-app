#!/bin/sh
PID_FILE=bks-server.pid
kill `cat $PID_FILE`
echo 'shutdown kingteller spp  server success.'
