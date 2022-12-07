package utils;

import java.util.concurrent.atomic.AtomicInteger;

public class Miner extends Thread{
    
    static AtomicInteger nonceFound = new AtomicInteger(0);
    static AtomicInteger nonce = new AtomicInteger(0);
    static int noncefinal;
    static String zeros;
    
    public void run() {  
        //nounce is found
        if (nonce.toString().endsWith(zeros)) {
            nonceFound.set(1);
            noncefinal = nonce.get();
        }
    }
    
    public static int getNonce(int dificulty) throws InterruptedException {
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
        return noncefinal;
    }
}