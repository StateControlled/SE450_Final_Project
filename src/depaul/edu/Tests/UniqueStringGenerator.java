package depaul.edu.Tests;

import java.util.zip.CRC32;

public class UniqueStringGenerator {
	private static final String SALT = "rimskykorsakov";
	
    public static String generator1(String input1, String input2, String input3) {
        // Concatenate the three inputs
        String concatenatedInputs = SALT + input1 + input2 + input3;
//        
//        for (byte b : concatenatedInputs.getBytes()) {
//        	System.out.println(b);
//        }

        // Calculate the CRC32 checksum
        CRC32 crc32 = new CRC32();
        crc32.update(concatenatedInputs.getBytes());
        long checksum = crc32.getValue();


        // Convert the checksum to a hexadecimal string
        String uniqueString = Long.toHexString(checksum);

        return uniqueString;
    }
    
    public static String generator2(String input1, String input2, String input3) {
        // Concatenate the three inputs
        String concatenatedInputs = SALT + input1 + input2 + input3;
        return java.util.UUID.nameUUIDFromBytes(concatenatedInputs.getBytes()).toString();

    }

    public static void main(String[] args) {
        String input1 = "Restricted";
        String input2 = "Accessibiljty";
        String input3 = "Validate";
        String input4 = "Restricted";
        String input5 = "Accessibility";
        String input6 = "Validate";

        String uniqueString  = generator1(input1, input2, input3);
        System.out.println("Unique String: " + uniqueString);
        
        String uniqueString2 = generator1(input4, input5, input6);
        System.out.println("Unique String: " + uniqueString2);
        
        String uniqueString3 = generator2(input1, input2, input3);
        System.out.println("Unique String: " + uniqueString3);
        
        String uniqueString4 = generator2(input4, input5, input6);
        System.out.println("Unique String: " + uniqueString4);
        
        
    }
}
