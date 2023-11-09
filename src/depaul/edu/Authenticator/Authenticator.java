package depaul.edu.Authenticator;

public class Authenticator {
    private static Authenticator INSTANCE;

    private Authenticator() {

    }

    public static Authenticator getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new Authenticator();
        }
        return INSTANCE;
    }

    public boolean authenticate(String username, String hashedPassword) {
        return false;
    }
}
