#!/usr/bin/env bash
export JAVA_PROGRAM_ARGS=`echo "$@"`
mvn clean install
mvn dependency:copy-dependencies
mvn package
mvn javadoc:javadoc
#mvn exec:java -Dexec.args="$JAVA_PROGRAM_ARGS"
