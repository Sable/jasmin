#!/bin/sh

export CLASSPATH
CLASSPATH=./classes

javac -d classes src/runtime/*.java
javac -d classes src/*.java
