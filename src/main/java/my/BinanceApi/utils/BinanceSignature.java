package my.BinanceApi.utils;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

public class BinanceSignature {
    static final String algorithm = "HmacSHA256";

    public static String generateSignature(String timestampUrl, String key){
        byte[] hmac;
        try{
            SecretKeySpec secretKeySpec = new SecretKeySpec(key.getBytes(),algorithm);
            Mac mac = Mac.getInstance(algorithm);
            mac.init(secretKeySpec);
            hmac = mac.doFinal(timestampUrl.getBytes());

            return bytesToHex(hmac);
        } catch (NoSuchAlgorithmException | InvalidKeyException e) {
            throw new RuntimeException(e);
        }
    }

    private static String bytesToHex(byte[] bytes) {
        StringBuilder sb = new StringBuilder();
        for (byte b : bytes) {
            sb.append(String.format("%02x", b));
        }
        return sb.toString();
    }
}


