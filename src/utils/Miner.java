package utils;

import java.util.concurrent.atomic.AtomicInteger;

public class Miner extends Thread{
    
    static AtomicInteger nonceFound = new AtomicInteger(0);
    static AtomicInteger nonce = new AtomicInteger(0);
    static String zeros;
    static String data;
    
    public void run() {  
        //calculate hash nonce + data
        String hash = Hash.getHash(nonce + data);
        //nounce is found
        if (hash.endsWith(zeros)) {
            nonceFound.set(1);
        }
    }
    
    public static int getNonce(String data, int dificulty) throws InterruptedException {
        Miner.data = data; 
        zeros = String.format("%0" + dificulty + "d", 0);
        int procs = Runtime.getRuntime().availableProcessors();
        Miner threads[] = new Miner[procs];
        
        while (nonceFound.get() == 0) {
            for (int i = 0; i < threads.length; i++) {
                // 2.2 - criar as threads com os limites
                threads[i] = new Miner();
                // 2.3 - executar as threads
                threads[i].start();
                //esperar pela thread i 
                threads[i].join();
                //next nonce
                nonce.addAndGet(1);
            }
        }
        return nonce.get();
    }
}