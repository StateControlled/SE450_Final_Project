package main.java.edu.depaul.logwriter;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import java.io.StringWriter;
import java.io.PrintWriter;

/**
 * LogWriter handles logging events. Subsequent logs will be appended to the same log file as previous logs.
 **/
public class LogWriter {
    private static SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd kk:mm:ss");
    private static LogWriter instance;
    private static File logFile;
    private static long id;

    /**
     * Private constructor. Can't touch this.
     * Ensures that the first line of every log includes the ID.
     **/
    private LogWriter(File log) {
        logFile = log;
        setID();
        log(Level.INFO, "INIT", Long.toHexString(id));
    }
    
    /**
     * Creates a unique ID number for this logger
     **/
    private static void setID() {
    	id = (System.currentTimeMillis() + logFile.hashCode()) * 173;
    }

    /**
     * Instantiates a new LogWriter.
     * @param name A name for the log file output.
     * @throws NullPointerException if the name is null.
     **/
    public static LogWriter getLogWriter(String name) throws NullPointerException {
    	if (name == null) {
    		throw new NullPointerException("Name cannot be null");
    	}
        if (instance == null) {
            instance = new LogWriter(new File(name + ".log"));
        }
        return instance;
    }

    /**
     * Returns the file where this logger writes its logs.
     * @returns The file defined by the constructor
     **/
    public static File getLog() {
        return logFile;
    }

    /**
     * Writes an event to the log file. This method is intended to log general, non-error events.
     * @param level	an indicator of how serious this event is.
     * @param event	a short description of the event being logged.
     * @param optionalMessage	an optional message for additional information about the event
     **/
    public static void log(Level level, String event, String optionalMessage) {
        try (FileWriter writer = new FileWriter(logFile, true)) {
            String logEvent = String.format("%s %s: %s \\ %s\n", dateFormat.format(new Date()), level.toString(), event, optionalMessage);
            writer.append(logEvent);
            writer.close();
        } catch (IOException e) {
            // I find it amusing to have a try catch inside a logging function
            System.out.println("Failed to log event.");
            e.printStackTrace();
        }
    }

    /**
     * Writes an event to the log file. This form is intended for use with exceptions and errors.
     * @param level	an indicator of how serious this event is.
     * @param event	a short description of the event being logged.
     * @param e	the exception
     **/
    public static void log(Level level, String event, Exception exception) {
        try (FileWriter writer = new FileWriter(logFile, true)) {
            String logEvent = String.format("%s %s: %s %s", dateFormat.format(new Date()), level.toString(), event, exception.toString());
            StringWriter stringWriter = new StringWriter();
            exception.printStackTrace(new PrintWriter(stringWriter));
            logEvent += stringWriter.toString();
            writer.append(logEvent);
            writer.close();
        } catch (IOException e) {
            System.out.println("Failed to log event.");
            e.printStackTrace();
        }
    }
}
