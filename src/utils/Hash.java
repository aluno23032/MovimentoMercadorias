package utils;

import java.security.MessageDigest;
import java.util.Base64;

public class Hash {

    public static String hashAlgorithm = "SHA-256";

    public static String getHash(String data, int nonce) {
        try {
            return getHash(data + nonce);
        } catch (Exception ex) {
            return ex.getMessage();
        }
    }
    
    public static String getHash(String data) throws Exception {
        MessageDigest md = MessageDigest.getInstance(hashAlgorithm);
        md.update(data.getBytes());
        return Base64.getEncoder().encodeToString(md.digest());
    }
    //::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::
    private static final long serialVersionUID = 202111021828L;
}