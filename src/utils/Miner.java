package utils;

public class Miner {
    //limit of once
    public static int MAX = (int)1E9;

    public static int getNonce(String data, int dificulty) {
        //string of dificulty zeros "0..0"
        String zeros = String.format("%0" + dificulty + "d", 0);        
        int nonce = 0;
        while (nonce < MAX) {
            //calculate hash nonce + data
            String hash = Hash.getHash(nonce + data);
            //DEBUG ... DEBUG ... DEBUG ... DEBUG ... DEBUG ... 
            System.out.println(nonce + " " + hash);
            //nounce is found
            if (hash.endsWith(zeros)) {
                return nonce;
            }
            //next nonce
            nonce++;
        }
        return nonce;
    }
}
