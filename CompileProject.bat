REM Batch file to compile and start the program
echo Compiling Project...
javac -d "bin" -cp "lib/gson-2.10.1.jar" @paths.txt
java -cp "bin;lib/gson-2.10.1.jar" main.java.edu.depaul.gui.Main