#!/bin/bash

main()
{
  clear

  echo "#==================================================#"
  echo "#                   AURORA                         #"
  echo "#==================================================#"

  echo -e
  echo "What the operation [0-GIT, 1-MVN, 2-APP] : ";
  read option;

  echo "Option selected: $option";
  echo -e;

  case $option in
    0) git_operation;;
    2) app_operation;;
    *) echo "No valid operations selected.";;
  esac;

  echo -e;
}

git_operation()
{
  echo "Starting git operations, select the activity: ";
  echo "1 - Push modifications";

  read git_option;
  echo "Option selected $git_option";
}

app_operation()
{
  echo "Starting App operations, select the activity: ";
  echo "1 - Starting the servers";
  echo "2 - Kill all the applications";

  read app_option;

  if [ $app_option == 1 ]
  then
    echo "Starting servers...";
    source configuration/start.sh &
    sleep 15;
    source discovery/start.sh &
    sleep 15;
    source auth/start.sh &
    source gateway/start.sh &
  fi

  if [ $app_option == 2 ]
  then
    echo "Shutdown servers...";
    curl -X POST http://localhost:8084/actuator/shutdown ; echo -e
    curl -X POST http://localhost:8081/actuator/shutdown ; echo -e
    curl -X POST http://localhost:8080/actuator/shutdown ; echo -e 
    curl -X POST http://localhost:8083/actuator/shutdown ; echo -e 
  fi
}
main
