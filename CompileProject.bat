REM Batch file to compile and start the program
echo Compiling Project
javac -cp "gson-2.8.2.jar" *.java
timeout /t 3 /nobreak
java Main.java