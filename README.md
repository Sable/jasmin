[![Build Status](http://soot-build.cs.uni-paderborn.de/jenkins/buildStatus/icon?job=soot/jasmin-build)](http://soot-build.cs.uni-paderborn.de/jenkins/job/soot/job/jasmin-build/)

Jasmin README file			   Jan 22nd, 2012, Eric Bodden

Welcome to Jasmin version sable-3.0.1.

This is a specialized version of jasmin which is used as a back end for the
Soot framework.  

Note that with permission from Jonathan Meyer, this package is distributed
under the GNU Lesser General Public License and so can be distributed with
Soot. 


Original Jasmin README:
---------------------------------------------------------------------------

Jasmin README file                         1 March 1997, Jonathan Meyer

Description
-----------
Welcome to Jasmin version 1.06.

Jasmin is a Java Assembler Interface. It takes ASCII descriptions for Java
classes, written in a simple assembler-like syntax, and using the Java
Virtual Machine instruction set. It converts them into binary Java class 
files suitable for loading into a Java interpreter.

Jasmin was written as the companion to the book "Java Virtual Machine",
published by O'Reilly, written by Troy Downing and myself.
(See http://www.ora.com/catalog/javavm/).

If you want to know more about what Jasmin is, why I wrote Jasmin, 
or what kinds of uses Jasmin can be put to, look at doc/about.html.

Home Page
---------
Check out the Jasmin home page at:

    http://cat.nyu.edu/meyer/jasmin

this will tell you the latest news on Jasmin - in particular, make sure that you
have the most recent version, since I'm sure to add bells and whistles over time!
(For example, I plan to rewrite the parser in Jasmin so that it does more error
checking). Also, you can register on this page to receieve news about new releases
and bug fixes.

Requirements
------------
Jasmin is written in Java, so it should be fairly straightforward to get it 
set up and running in your environment.

I have tested Jasmin with the Sun JDK 1.0 on Solaris and Windows 95, and with J++ 
on Windows NT. 

In the bin directory are scripts for running Jasmin on Unix systems and batch files
for Windows. These may need some tailoring on your system.

Installation Instructions
-------------------------
Below you will find installation instructions for:

-- Windows 95/NT and J++ 
-- Windows 95/NT and Sun's JDK or Symantec Cafe 
-- Unix and the Sun JDK 

Jasmin should run on other platforms that have Java installed. Look at the scripts
in the bin directory to get an idea of how Jasmin is started.

A version of the classes for Jasmin in ZIP format is available. See the Jasmin
home page (http://cat.nyu.edu/meyer/jasmin).

******** Windows 95/NT and J++ ********

-- Basic Installation

  1. Extract the jasmin distribution files and place them in C:\JASMIN

  2. Add C:\JASMIN\BIN to your path by editing your AUTOEXEC.BAT.

Then you run Jasmin using the vjasmin command (as show below). 

-- Notes

Under J++, you use jvc (instead of javac) to compile Java code, and jview (instead
of java) to run it.

If you want to maintain the Jasmin files somewhere other than C:\JASMIN,
first move the files to the location you want to use, then edit the bin\vjasmin.bat 
script and change the JASMIN variable so that it points to the jasmin directory. 
Then add the jasmin bin directory to your path by editing your AUTOEXEC.BAT.

-- Trying Jasmin out

If you are using Jasmin with Visual J++ on Windows 95/NT, you can quickly try out 
Jasmin by installing the files in c:\jasmin and then typing to a DOS command prompt:

    cd c:\jasmin
    vjasmin examples\HelloWorld.j

After running Jasmin, you should find the compiled HelloWorld.class file
in the examples directory.

You can then run the HelloWorld program by doing:

    jview examples.HelloWorld

******** Windows 95/NT and Sun's JDK or Symantec Cafe ********

I have run Jasmin under Windows 95 using Symantec Cafe (it probably works
under other implementations of the JDK as well).

-- Basic Installation

  1. Extract the jasmin distribution files and place them in C:\JASMIN. 

  2. Add C:\JASMIN\BIN to your path by editing your AUTOEXEC.BAT.

-- Notes

On some systems, you may need to add the C:\JASMIN\CLASSES directory to your
CLASSPATH variable. CLASSPATH is either defined in C:\AUTOEXEC.BAT (JDK) or
or C:\Cafe\BIN\SC.INI (Cafe version 1.2 and later).

If you want to maintain the Jasmin files elsewhere in your directory hierarchy,
first move the files to the location you want to use, then edit the bin\jasmin.bat 
script and change the JASMIN variable so that it points to the jasmin directory. 
Then add the jasmin bin directory to your path by editing your AUTOEXEC.BAT.

-- Trying Jasmin Out

If you are using Sun's JDK or Symantec Cafe on Windows 95/NT, you can try Jasmin by 
installing the files in c:\jasmin and then typing to a DOS command prompt:

    cd c:\jasmin
    jasmin examples\HelloWorld.j

After running Jasmin, you should find the compiled HelloWorld.class file
in the examples directory.

You can then run the HelloWorld program by doing:

    java -verify examples.HelloWorld

Its a good idea to use the '-verify' option for Java programs compiled with
Jasmin, since this will catch any structural violations you have in
your code.

******** Unix and the Sun JDK ********

I've tried Jasmin on SGIs and Suns running Sun's JDK 1.02. It should work on
other Unix boxes with the JDK as well.

-- Basic Installation

  1. Extract the jasmin distribution files and place them in /usr/local/jasmin. 

  2. Add /usr/local/jasmin/bin to your path, by editing your .cshrc (or equivalent). 

-- Notes

If you want to maintain the Jasmin files somewhere other than /usr/local/jasmin,
first extract the files, then edit the bin/jasmin script and change the JASMIN variable 
so that it points to the jasmin directory. Then add the Jasmin bin directory to 
your path.

-- Trying Jasmin Out

On Unix systems with the JDK installed, change into the directory containing
this readme file, then type to a shell prompt:

    jasmin examples/HelloWorld.j

After running Jasmin, you should find the compiled HelloWorld.class file
in the examples directory.

You can then run the HelloWorld program by doing:

    java -verify examples.HelloWorld

Its a good idea to use the '-verify' option for Java programs compiled with
Jasmin, since this will catch any structural violations you have in
your code.


Problems/Questions
------------------
If you have a problem with Jasmin, please visit the Jasmin home page at:

    http://cat.nyu.edu/meyer/jasmin

this will give you instructions on how to submit problem reports. There is
also a FAQ on this page that you could check to see if your problem has already been
encountered.

Where Next
----------
After trying Jasmin out, have a look at the HelloWorld.j source, and try
compiling and running the other examples.

There is documentation for Jasmin in the doc directory. You should probably
start with the 'guide.html' document. 

If you decide you want to use Jasmin on files in other directories, see the
Installation Instructions below.

Rebuilding Jasmin
-----------------
The bin/compile.sh script is what I use to rebuild Jasmin under Solaris. I've
included it for your enjoyment, though your mileage may vary.

Java API to Jasmin
------------------
In the doc/api directory is a description of some of the public classes in the 
Jasmin package. You may find this a more appropriate hook to the Jasmin assembler in
your application. Note that this API is under revision and may change (but its very
small and basic, so changes should be easy to adapt to).

Files
-----
The following files are included in this distribution:

    README      - this file
    bin/        - Shell scripts and Batch files for running Jasmin under DOS/Unix
    examples/   - directory containing example files written for Jasmin
    src/        - the Java source code and for the jasmin package
    lib/        - contains Java sources for the java_cup and jas packages
    classes/    - contains Java class files used by jasmin.
    doc/        - various documentation files.

Copyright
---------
Jasmin is Copyright (1997) Jonathan Meyer, under the terms of
the GNU General Public License. See COPYING for more.

Jasmin uses the JAS package which has its own copyright - see lib/jas/README.

Jasmin was built partially using the java_cup package, which is also in 
the lib directory.
