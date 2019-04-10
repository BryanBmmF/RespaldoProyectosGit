#! /bin/bash 
echo "STARTING JFLEX COMPILING"
/home/bryan/LabCompi/jflex-1.7.0/bin/jflex -d ../src/proyecto1compi1/ AnalizadorLexico.flex

echo "STARTING CUP COMPILING"
java -jar /home/bryan/LabCompi/java-cup-11.jar parserCreador.cup
mv parser.java ../src/proyecto1compi1/parser.java
mv sym.java ../src/proyecto1compi1/sym.java
