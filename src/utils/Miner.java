package utils;

import java.util.concurrent.atomic.AtomicInteger;

public class Miner extends Thread {

    private static final int MAX = (int) 1E9;
    static AtomicInteger nonce = new AtomicInteger(0);
    private static  int found = 0;
    static String data;
    private final int dificulty;

    public Miner(String data, int dificulty) {
        Miner.data = data;
        this.dificulty = dificulty;
    }

    @Override
    public void run() {

        String zeros = String.format("%0" + dificulty + "d", 0);
        nonce.set(0);
        String hash = null;
        while (nonce.get() < MAX || found != 1) {
            hash = Hash.getHash(nonce.get() + data);
            if (hash.endsWith(zeros)) {
                found = 1;


                return;
            }
            nonce.incrementAndGet();
        }





    }

    public static int getNonce(String data, int dificulty) throws InterruptedException {
        //string of dificulty zeros "0..0"
        Miner.data = data;
        String format = String.format("%0" + dificulty + "d", 0);
        int procs = Runtime.getRuntime().availableProcessors();
        Miner threads[] = new Miner[procs];

        while (found == 0) {
            for (int i = 0; i < procs; i++) {
                //cria as threads com os limites
                threads[i] = new Miner(data, dificulty);
                //executa as threads
                threads[i].start();
            }
            for (Miner th: threads) {
                th.join();
            }
        }
        return nonce.get();
    }

    public static void setNonce(){
        found = 0;
    }
}