@echo off
rem - File:    vjasmin.bat
rem - Purpose: Jasmin script for Visual J++ and Windows NT
rem - Author:  Jonathan Meyer, Feb 1997

rem - Assumes Jasmin is installed in c:\jasmin.
rem - Change the following line if you have installed Jasmin in a non-default location:

set JASMIN=c:\jasmin

set JASMIN_CLASSES=%JASMIN%\classes

jview /q /cp:a %JASMIN_CLASSES% jasmin.Main %1 %2 %3 %4 %5 %6 %7 %8 %9



