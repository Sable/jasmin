@echo off
rem - File:    jasmin.bat
rem - Purpose: Jasmin script for Windows 95 and Windows NT JDK
rem - Author:  Jonathan Meyer, Aug 1996

rem - You will need to add Jasmin's classes directory to your CLASSPATH.
rem - Assuming this is installed in c:\jasmin, you can use:
rem -
rem - set CLASSPATH=c:\jasmin\classes;
rem - 
rem - Alternatively, you could use 
rem -
rem - set CLASSPATH=c:\jasmin\lib\classes.zip
rem -
rem - If your Java implementation prefers .zip files.

set CLASSPATH=c:\jasmin\classes;

rem - Semantic Cafe Users:
rem -
rem - In Semantic Cafe 1.2, the CLASSPATH variable is
rem - defined in the file c:\Cafe\Bin\Sc - you will need to
rem - edit this file and change the line reading:
rem -
rem - CLASSPATH=.;%@P%\..\JAVA\LIB\CLASSES.ZIP;%@P%\..\JAVA\LIB\SYMCLASS.ZIP;
rem -
rem - to something like:
rem -
rem - CLASSPATH=.;%@P%\..\JAVA\LIB\CLASSES.ZIP;%@P%\..\JAVA\LIB\SYMCLASS.ZIP;C:\jasmin\classes

rem - (JM - could do better argument handling...)
rem -
java jasmin.Main %1 %2 %3 %4 %5 %6 %7 %8 %9



