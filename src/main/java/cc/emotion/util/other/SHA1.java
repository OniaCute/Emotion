package cc.emotion.util.other;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;

public class SHA1 {
    public static String asSHA(String string) {
        MessageDigest SHA = null;
        try {
            SHA = MessageDigest.getInstance("SHA-1");
        } catch (Exception e) {
            System.out.println(e.toString());
            e.printStackTrace();
            return "";
        }

        byte[] byteArray = string.getBytes(StandardCharsets.UTF_8);
        byte[] md5Bytes = SHA.digest(byteArray);
        StringBuffer hexValue = new StringBuffer();
        for (int i = 0; i < md5Bytes.length; i++) {
            int val = ((int) md5Bytes[i]) & 0xff;
            if (val < 16) {
                hexValue.append("0");
            }
            hexValue.append(Integer.toHexString(val));
        }
        return hexValue.toString().toUpperCase();
    }

}
