package edu.depaul.paymentprocessor;

import edu.depaul.logwriter.Level;
import edu.depaul.logwriter.LogWriter;

/**
 * The PaymentProcessor class contains the logic to "validate" a credit card.
 **/
public class PaymentProcessor {
    private static PaymentProcessor processor;

    private PaymentProcessor() {
        ;
    }

    public static PaymentProcessor getProcessor() {
        if (processor == null) {
            processor = new PaymentProcessor();
        }
        return processor;
    }

    /**
     * Validates a credit card. This is a simulated validation. Please don't use it for serious things.
     * 
     * @param number    the 16-digit credit card number.
     * @param expiration    the expiration date on the card.
     * @param security  the security code from the card.
     * @return {@code true} if the credit card is determined to be valid.
     **/
    public static boolean validateCreditCard(String number, String expiration, String security) {
        try {
            LogWriter.log(Level.INFO, "Received credit card processing request", "Credit Card processor validateCreditCard");
            LogWriter.log(Level.INFO, String.format("Read NUMBER : %s // EXPIRATION : %s // SECURITY : %s", number, expiration, security), "LOG DATA");
            String sNumber = number.replaceAll("[^0-9]", "");
            if (sNumber.length() != 16) {
                LogWriter.log(Level.WARNING, "Credit Card length " + sNumber.length() + " is not acceptable", "REJECTED");
                return false;
            }

            String sExpiration = expiration.replaceAll("[^0-9]", "");
            sExpiration += security;
            if (sExpiration.length() != 7) {
                LogWriter.log(Level.WARNING, "Credit Card security code or expiration date is incorrect", "REJECTED");
                return false;
            }

            Integer.parseInt(sExpiration);

            int leading = Integer.parseInt(sNumber.substring(0, 2));
            switch (leading) {
                // DSC
                case 60:
                    break;
                // MC
                case 55:
                case 54:
                case 53:
                case 52:
                case 51:
                    break;
                // VISA
                case 49:
                case 48:
                case 47:
                case 46:
                case 45:
                case 44:
                case 43:
                case 42:
                case 41:
                case 40:
                    break;
                default:
                    LogWriter.log(Level.WARNING, "Credit Card rejected", "REJECTED");
                    return false;
            }
            LogWriter.log(Level.INFO, "Credit Card approved!", "APPROVED");
            return true;
        } catch (Exception e) {
            LogWriter.log(Level.SEVERE, "Error Processing Credit Card", e);
            return false;
        }
    }    

}
