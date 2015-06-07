#!/bin/sh
PID_FILE=bks-rest.pid
kill `cat $PID_FILE`
echo 'shutdown kingteller spp  server success.'
