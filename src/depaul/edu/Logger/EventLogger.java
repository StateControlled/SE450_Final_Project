package depaul.edu.Logger;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class EventLogger {
    private static EventLogger INSTANCE;
    private File logFile;

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

    public File getLog() {
        return logFile;
    }

    public void log(Event event) {
        try (FileWriter writer = new FileWriter(logFile)) {

        } catch (IOException e) {
            System.out.println("Failed to log event.");
            e.printStackTrace();
        }
    }
}
