#!/bin/bash

#
# This is a simple JDK script to compile and generate
# classes from the Jasmin source code. 
#
# Feng Qian, Jan 26,2001

JAVAC=javac
JAVA=java
JAVADOC=javadoc
JAVAFLAGS=-O

JASMINSRC=`pwd`
TARGET=${JASMINSRC}/classes

if [ ! -d ${TARGET} ]; then
   mkdir ${TARGET}
fi

echo "Generating parser..."
${JAVA} java_cup.Main < ./jasmin/parser.cup
mv sym.java parser.java ./jasmin

echo "Compiling jasmin..."
${JAVAC} ${JAVAFLAGS} -d ${TARGET} ${JASMINSRC}/jasmin/*.java
echo "Done"
