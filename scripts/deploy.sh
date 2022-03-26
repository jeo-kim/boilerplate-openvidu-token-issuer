#!/usr/bin/env bash

sudo iptables -t nat -A PREROUTING -i eth0 -p tcp --dport 80 -j REDIRECT --to-port 8080

REPOSITORY=/home/ubuntu/app


APP_NAME=bople-openvidu-client-session-token-0.0.1-SNAPSHOT.jar

CURRENT_PID=$(pgrep -fl  $APP_NAME | grep java | awk '{print $1}')
if [ -z $CURRENT_PID ]
then
 echo "> 종료할것 없음."

else
 echo "> kill -15 $CURRENT_PID"
 sudo  kill -15 $CURRENT_PID
 sleep 5
fi


rm  -rf $REPOSITORY/bople-openvidu-client-session-token-0.0.1-SNAPSHOT-plain.jar

JAR_NAME=$(ls -tr $REPOSITORY/*.jar | tail -n 1)
echo "> JAR Name: $JAR_NAME"
chmod +x $JAR_NAME

sudo nohup java -jar  $JAR_NAME >  $REPOSITORY/nohup.out 2>&1 &
