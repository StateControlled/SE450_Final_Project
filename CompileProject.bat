REM Batch file to compile and start the program
echo Compiling Project...
javac -d "bin" -cp "lib/gson-2.10.1.jar" @paths.txt
REM If databases have not been populated with data, start with command:
REM java -cp "bin;lib/gson-2.10.1.jar" main.java.edu.depaul.gui.Main -p
java -cp "bin;lib/gson-2.10.1.jar" main.java.edu.depaul.gui.Main
REM timeout /t 60