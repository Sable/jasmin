SIMPLEDIR=SIMPLE~1
# SIMPLEDIR=simple_calc
RM=del
# RM=rm
JAVA=java
JAVAOPTS=
JAVAC=javac
JAVACOPTS=-verbose


test: java_cup\\Main.class java_cup\\$(SIMPLEDIR)\\Main.class
	echo "1*-2+2;" | $(JAVA) $(JAVAOPTS) java_cup.simple_calc.Main

	echo 'If the line above says "= 0" everything is OK.'
	

java_cup\\Main.class:
	$(JAVAC) $(JAVACOPTS) java_cup\\Main.java

java_cup\\$(SIMPLEDIR)\\Main.class:
	cd java_cup
	cd $(SIMPLEDIR)
	echo $(RM) parser.java
	echo $(RM) sym.java
	$(JAVA) $(JAVAOPTS) java_cup.Main < parser.cup
	$(JAVAC) $(JAVACOPTS) Main.java
