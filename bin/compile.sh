#!/bin/sh

#
# This is a simple JDK script to compile and generate
# classes from the Jasmin source code. 
#

JASMIN=`pwd`

JAVAC=javac
JAVA=java
JAVADOC=javadoc
JAVAFLAGS=-O

# Compile jasmin package

cd ${JASMIN}/classes

echo "Compiling jasmin parser..."

${JAVA} java_cup.Main < ${JASMIN}/src/jasmin/parser.cup
/bin/rm ${JASMIN}/src/jasmin/parser.java 
/bin/rm ${JASMIN}/src/jasmin/sym.java
/bin/mv sym.java parser.java ${JASMIN}/src/jasmin

echo "Compiling jasmin..."
${JAVAC} ${JAVAFLAGS} -d ${JASMIN}/classes ${JASMIN}/src/jasmin/*.java

