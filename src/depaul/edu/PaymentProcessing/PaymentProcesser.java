package depaul.edu.PaymentProcessing;

public class PaymentProcesser {
    private PaymentProcesser() {

    }

    public static boolean validateCreditCard(String number, String expiration, String security) {
        try {
            String sNumber = number.replaceAll("[^0-9]", "");
            if (sNumber.length() != 16) {
                return false;
            }

            String sExpiration = expiration.replaceAll("[^0-9]", "");
            sExpiration += security;
            if (sExpiration.length() != 7) {
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
                    return false;
            }
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
