echo off


REM This is a simple script to compile and generate
REM documentation from the source code

REM The classes are generated into the current directory
REM under the jas and scm packages.

REM The html documentation is created under reference/jas



echo Compiling jas...
javac -g -d . src\jas\*.java


REM Compile and run the autogenerator

echo Compiling autogenerator...
cd src\scm
javac -d . autogen\autogen.java
echo Creating scm/jas interface...
java autogen
cd ..\..


REM Compile scm package

echo Compiling scm...
javac -g -d . src\scm\*.java


echo Generating html...
javadoc -d reference\jas jas src\jas\*java
echo Done
