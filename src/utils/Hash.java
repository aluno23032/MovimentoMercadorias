package utils;

public class Hash {

    public static String toHexString(int n) {
        return Integer.toHexString(n).toUpperCase();
    }

    public static String getHash(String data) {
        return toHexString(data.hashCode());
    }
}