package utils;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

public class BlockChain implements Serializable {

    ArrayList<Block> chain = new ArrayList<>();

    public String getLastBlockHash() {
        if (chain.isEmpty()) {
            return String.format("%08d", 0);
        }
        return chain.get(chain.size() - 1).currentHash;
    }

    public void add(String data, int dificulty) throws InterruptedException {
        //hash of previous block
        String prevHash = getLastBlockHash();
        //mining block
        int nonce = Miner.getNonce(prevHash + data, dificulty);
        //build new block
        Block newBlock = new Block(prevHash, data, nonce);
        chain.add(newBlock);
    }

    public Block get(int index) {
        return chain.get(index);
    }

    public String toString() {
        StringBuilder txt = new StringBuilder();
        txt.append("Blochain size = " + chain.size() + "\n");
        for (Block block : chain) {
            txt.append(block.toString() + "\n");
        }
        return txt.toString();
    }

    public void save(String fileName) throws Exception {
        try ( ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(fileName + ".bc"))) {
            out.writeObject(chain);
        }
    }

    public void load(String fileName) throws Exception {
        try ( ObjectInputStream in = new ObjectInputStream(new FileInputStream(fileName))) {
            this.chain = (ArrayList<Block>) in.readObject();
        }
    }

    public boolean isValid() {
        //Validate blocks
        for (Block block : chain) {
            if (!block.isValid()) {
                return false;
            }
        }
        //validate Links
        for (int i = 1; i < chain.size(); i++) {
            //previous hash !=  hash of previous
            if (chain.get(i).previousHash != chain.get(i - 1).currentHash) {
                return false;
            }
        }
        return true;
    }
}