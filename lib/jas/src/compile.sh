#!/bin/sh

#
# This is a simple script to compile and generate
# documentation from the source code

#
# The classes are generated into the current directory
# under the jas and scm packages.

#
# The html documentation is created under reference/jas

# Change this to the full pathname
# if your java compiler or interpreter is not in your path

JAVAC=javac
JAVA=java
JAVADOC=javadoc

JAVAFLAGS=-O

# Compile jas package

if [ ! -d classes ]; then
    mkdir classes
fi

TARGET=`pwd`/classes

# Compile jas

echo "compiling jas..."
${JAVAC} ${JAVAFLAGS} -d ${TARGET} jas/*.java 
echo "done"

# Compile and run the autogenerator

export CLASSPATH
CLASSPATH=${TARGET}:${CLASSPATH}

echo "Compiling autogenerator..."
(cd scm/autogen; ${JAVAC} -d . autogen.java; cp autogen.class ..)
echo "Creating scm/jas interface..."
(cd scm; ${JAVA} -cp .:${CLASSPATH} autogen; cp autogen.class ${TARGET})

# Compile scm package

echo "Compiling scm..."
${JAVAC} ${JAVAFLAGS} -d ${TARGET} scm/*.java 
echo "done"
