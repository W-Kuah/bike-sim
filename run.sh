#!/usr/bin/env bash
export JAVA_PROGRAM_ARGS=`echo "$@"`
#mvn exec:java -Dmaven.test.skip=true package -Dexec.args="$JAVA_PROGRAM_ARGS"
java -cp target/bikeSim-1.0-SNAPSHOT.jar org.bikesim.BikeSimApp ${JAVA_PROGRAM_ARGS}
