REM Batch file to compile and start the program
echo Compiling Project
REM javac -soucepath ./src/ -d ./bin/ ./src/main/java/edu/depaul/main/Main.java
REM javac -cp "gson-2.8.2.jar" -d ./bin ./src/main/java/edu/depaul/gui/Main.java
javac -cp lib/* -d bin -soucepath . src/main/java/edu/depaul/gui/Main.java
timeout /t 30 /nobreak
REM java Main.java