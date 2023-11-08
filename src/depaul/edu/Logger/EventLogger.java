package depaul.edu.Logger;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.io.StringWriter;
import java.io.PrintWriter;

public class EventLogger {
    private static SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd HH:mm:ss");
    private static EventLogger INSTANCE;
    private static File logFile;

    private EventLogger(File log) {
        logFile = log;
    }

    /**
     * @param name A name for the log file output.
     * @throws NullPointerException if the name is null.
     **/
    public static EventLogger getLoggerInstance(String name) throws NullPointerException {
        if (INSTANCE == null) {
            INSTANCE = new EventLogger(new File(name + ".log"));
        }
        return INSTANCE;
    }

    public static File getLog() {
        return logFile;
    }

    public static void log(Level level, String event, String optionalMessage) {
        try (FileWriter writer = new FileWriter(logFile, true)) {
            String logEvent = String.format("%s %s: %s %s \\ %s\n", dateFormat.format(new Date()), level.toString(), event, optionalMessage);
            writer.append(logEvent);
            writer.close();
        } catch (IOException e) {
            // I find it amusing to have a try catch inside a logging function
            System.out.println("Failed to log event.");
            e.printStackTrace();
        }
    }

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
