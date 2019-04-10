#! /bin/bash 
echo "STARTING JFLEX COMPILING"
/home/bryan/LabCompi/jflex-1.7.0/bin/jflex -d ../src/consolaLinux/ AnalizadorLexico.flex

echo "STARTING CUP COMPILING"
java -jar /home/bryan/LabCompi/java-cup-11.jar parser.cup
mv parser.java ../src/consolaLinux/parser.java
mv sym.java ../src/consolaLinux/sym.java
