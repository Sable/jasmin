#!/bin/bash

# always run this script on the project directory.
# Feng Qian, Jan 26, 2001

JAVAC=javac
JAVA=java
JAVADOC=javadoc
JAVAFLAGS=-O

JASMINROOT=`pwd`
TARGET=${JASMINROOT}/classes

if [ ! -d ${TARGET} ]; then
    mkdir ${TARGET}
else
    rm -fr ${TARGET}
    mkdir ${TARGET}
fi


# compiling java_cup first
(cd lib/cup; ./compile.sh; mv ./classes/* ${TARGET})

# compiling jas
(cd lib/jas/src; ./compile.sh; mv ./classes/* ${TARGET})

# jasmin needs java_cup, add it in class path
export CLASSPATH=${TARGET}:${CLASSPATH}

# Compile jasmin package
(cd src; ./compile.sh; mv ./classes/* ${TARGET})

