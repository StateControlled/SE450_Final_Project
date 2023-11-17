package edu.depaul.authenticator;

import java.security.MessageDigest;
import edu.depaul.logwriter.Level;
import edu.depaul.logwriter.LogWriter;

public class Hash {
    private static final String SALT = "germanaugmentedsixthchord";
    private Hash() {
        ;
    }

    /**
     * Creates a hash of the given {@code text} using the SHA-256 algorithm.
     **/
    public static String hash(String text) {
        try {
            text += SALT;
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
            messageDigest.update(text.getBytes());
            byte[] byteArray = messageDigest.digest();

            StringBuilder builder = new StringBuilder();
            for (int i = 0; i < byteArray.length; i++) {
                builder.append(Integer.toHexString(0xFF & byteArray[i]));
            }
            LogWriter.log(Level.INFO, "Successfully hashed password", "");
            return builder.toString();
        } catch (Exception e) {
            LogWriter.log(Level.SEVERE, "Failed to hash password", e);
            return null;
        }
    }
}
