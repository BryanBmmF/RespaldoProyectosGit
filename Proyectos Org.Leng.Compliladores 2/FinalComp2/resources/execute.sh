#! /bin/bash 
echo "STARTING JFLEX COMPILING"
/home/bryan/LabCompi/jflex-1.7.0/bin/jflex -d ../src/practica1comp2/backend/analizadores/ Lexer.flex

echo "STARTING CUP COMPILING"
java -jar /home/bryan/LabCompi/parser/java-cup-11b.jar -parser Parser parser.cup
mv Parser.java ../src/practica1comp2/backend/analizadores/Parser.java
mv sym.java ../src/practica1comp2/backend/analizadores/sym.java
