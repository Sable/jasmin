#
# Windows NT makefile for java_cup
#	by Todd Knoblock, 28 January 1998.
#
# To run, type "nmake all" from the directory containing the make file.
# Tested under nmake version 1.62.7022

JVC=jvc
# -x means disable extensions
# -g means include debug information
# -w2 means warning level 2.
#     Unfornately, anything above warning level 2 is noisy
JVCFLAGS= -x -g -w2
JVIEW=jview

.SUFFIXES: .java .class

.java.class:
	$(JVC) $(JVCFLAGS) $<
	
all: runtime simple_calc java_cup test

java_cup: java_cup\*.class

runtime: java_cup\runtime\*.class

simple_calc: 	java_cup\simple_calc\sym.java \
	     	java_cup\simple_calc\parser.java \
		java_cup\simple_calc\*.class


java_cup\simple_calc\sym.java: java_cup java_cup\simple_calc\parser.cup 
	$(JVIEW) java_cup.Main  < java_cup\simple_calc\parser.cup
	@del -f -q java_cup\simple_calc\sym.java >nul 2>nul 
	@del -f -q java_cup\simple_calc\parser.java >nul 2>nul 
	move sym.java java_cup\simple_calc\ 
	move parser.java java_cup\simple_calc\ 

java_cup\simple_calc\parser.java: java_cup\simple_calc\sym.java

clean:
	@del -f -q java_cup\simple_calc\sym.java >nul 2>nul 
	@del -f -q java_cup\simple_calc\parser.java >nul 2>nul 
        @for %d in (java_cup java_cup\runtime java_cup\simple_calc) do \
		@pushd %d \
		& del -f -q *.class >nul 2>nul \
		& popd

test:	simple_calc
	@echo Executing the demo program.  Answer should be 5050.
	echo 101*100/2; | $(JVIEW) java_cup.simple_calc.Main
