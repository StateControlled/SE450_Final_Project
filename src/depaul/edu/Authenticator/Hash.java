package depaul.edu.Authenticator;

import java.security.MessageDigest;

public class Hash {
    private Hash() {

    }

    public static String hash(String text) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
            messageDigest.update(text.getBytes());
            byte[] byteArray = messageDigest.digest();

            StringBuilder builder = new StringBuilder();
            for (int i = 0; i < byteArray.length; i++) {
                builder.append(Integer.toHexString(0xFF & byteArray[i]));
            }
            return builder.toString();
        } catch (Exception e) {
            System.out.println("This shouldn't happen.");
            System.out.println(e.getMessage());
            e.printStackTrace();
            return null;
        }
    }
}
