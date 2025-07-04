#!/usr/bin/env bash
export JAVA_PROGRAM_ARGS=`echo "$@"`
mvn package
mvn exec:java -Dexec.args="$JAVA_PROGRAM_ARGS"
