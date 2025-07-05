#!/usr/bin/env bash
export JAVA_PROGRAM_ARGS=`echo "$@"`
mvn clean install
dependency:copy-dependencies
mvn package
mvn exec:java -Dexec.args="$JAVA_PROGRAM_ARGS"
