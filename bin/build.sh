#! /bin/sh

# Usage: build.sh [--refresh] to compile and install all of the jasmin and jas stuff.
#  This script must be run in the base directory of the jasmin directory tree.
#  (ie get /usr/localcc/pkgs/jasmin).

#  If the script is run which the --refresh argument, then the code is updated
#  against the latest version found in the prcs repository before compilition proceeds.
#

if test "x${1}x" = x"--refresh"x; then
    echo "Refreshing code."
    rm -rf src/jasmin;
    prcs checkout jasmin;

    (cd lib/jas;
    rm -rf src/jas;
        prcs checkout jas.prj;)
fi

if test x"${SOOTCLASSPATH}"x = x""x; then
    echo "You must define the variable SOOTCLASSPATH to point to your soot
classes."
    exit

elif  `java -version 2>&1 | grep "1.2" - &> /dev/null `; then
    echo "Error: You must use java 1.1 to compile! Do something about it."
    exit
fi

java -version

export CLASSPATH=.:$SOOTCLASSPATH:`pwd`/lib/jas

echo "Compiling Jas ..."
(cd lib/jas;
 chmod +x compile.sh
 compile.sh;
 rm -rf ../../classes/jas;
 cp -r jas ../../classes)

echo "Compiling Jasmin ..."
bin/compile.sh
