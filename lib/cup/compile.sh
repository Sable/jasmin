#!/bin/sh

export CLASSPATH=./classes

javac -d classes src/runtime/*.java
javac -d classes src/*.java
