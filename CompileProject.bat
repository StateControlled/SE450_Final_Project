REM Batch file to compile and start the program
echo Compiling Project
REM javac -soucepath ./src/ -d ./bin/ ./src/main/java/edu/depaul/main/Main.java
REM javac -cp "gson-2.8.2.jar" -d ./bin ./src/main/java/edu/depaul/gui/Main.java
REM javac -d bin -cp lib/* src/main/java/edu/depaul/authenticator/*.java src/main/java/edu/depaul/catalogue/*.java src/main/java/edu/depaul/customer/*.java 
javac -d bin -cp lib/* src/main/java/edu/depaul/*.java
java bin/src/main/java/edu/depaul/gui/Main
timeout /t 30 /nobreak
REM java Main.java