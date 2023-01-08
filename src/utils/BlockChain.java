package utils;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Eduardo Gomes a23032 e Pedro Martinho a23299
 */

public class BlockChain implements Serializable {

    ArrayList<Block> chain = new ArrayList<>();

    public String getLastBlockHash() {
        if (chain.isEmpty()) {
            return String.format("%08d", 0);
        }
        return chain.get(chain.size() - 1).currentHash;
    }

    public ArrayList<Block> getChain() {
        return chain;
    }

    public int getLength() {
        return chain.size();
    }

    public void add(Block b) throws Exception {
        //verify the linktotheprevious
        if (chain.size() > 1 && !getLastBlockHash().equals(b.previousHash)) {
            throw new Exception("Previous link not match");
        }
        //verify block hash
        if (!b.isValid()) {
            throw new Exception("Block not valid");
        }
        chain.add(b);
    }

    public void add(String data, int dificulty) throws InterruptedException, RemoteException, NotBoundException, MalformedURLException, Exception {
        //hash of previous block
        String prevHash = getLastBlockHash();
        //mining block
        int nonce = new Miner(null).mine(data, dificulty);
        //build new block
        Block newBlock = new Block(prevHash, data, nonce);
        chain.add(newBlock);
    }

    public Block get(int index) {
        return chain.get(index);
    }

    @Override
    public String toString() {
        StringBuilder txt = new StringBuilder();
        txt.append("Blochain size = ").append(chain.size()).append("\n");
        for (Block block : chain) {
            txt.append(block.toString()).append("\n");
        }
        return txt.toString();
    }

    public void save(String fileName) throws Exception {
        try ( ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(fileName))) {
            out.writeObject(chain);
        }
    }

    public void load(String fileName) throws Exception {
        try ( ObjectInputStream in = new ObjectInputStream(new FileInputStream(fileName))) {
            this.chain = (ArrayList<Block>) in.readObject();
        }
    }

    public boolean isValid() throws Exception {
        //Validate blocks
        for (Block block : chain) {
            if (!block.isValid()) {
                return false;
            }
        }
        //validate Links
        for (int i = 1; i < chain.size(); i++) {
            //previous hash !=  hash of previous
            if (!chain.get(i).previousHash.equals(chain.get(i - 1).currentHash)) {
                return false;
            }
        }
        return true;
    }

    public List<String> getUsers() {
        if (!chain.isEmpty()) {
            List<String> l = new ArrayList<>();
            String user;
            for (Block bloco : chain) {
                String result = bloco.merkleRoot.split("feita por ")[1];
                result = result.split(" ao fornecedor")[0];
                user = result;
                if (!l.contains(user)) {
                    l.add(user);
                }
            }
            return l;
        }
        return null;
    }

    public List<String> getUserEncomendas(String user) {
        List<String> l = new ArrayList<>();
        for (Block bloco : chain) {
            String result = bloco.merkleRoot.split("feita por ")[1];
            result = result.split(" ao fornecedor")[0];
            String id = bloco.merkleRoot.split("Encomenda n. ")[1];
            final String id2 = id.split(" feita por")[0];
            if (result.equals(user)) {
                if (!l.isEmpty()) {
                    l.removeIf(s -> (s.contains(" " + id2 +" ")));
                    if (!bloco.merkleRoot.contains("Recebida")) {
                        String result2 = bloco.merkleRoot.split("Encomenda n. ")[1];
                        result2 = result2.split(" feita por")[0];
                        String result3 = bloco.merkleRoot.split(": ")[1];
                        result3 = result3.split(" Recebida")[0];
                        l.add("Encomenda n. " + result2 + " : " + result3);
                    }
                } else {
                    String result2 = bloco.merkleRoot.split("Encomenda n. ")[1];
                    result2 = result2.split(" feita por")[0];
                    String result3 = bloco.merkleRoot.split(": ")[1];
                    result3 = result3.split(" Recebida")[0];
                    l.add("Encomenda n. " + result2 + " : " + result3);
                }
            }
        }
        return l;
    }
    
    public List<String> getHistoricoEncomenda(int id) {
        List<String> l = new ArrayList<>();
        for (Block bloco : chain) {
            if (bloco.merkleRoot.contains(" " + id +" ")) {
                    String result2 = bloco.merkleRoot.split("Encomenda n. ")[1];
                    result2 = result2.split(" feita por")[0];
                    String result3 = bloco.merkleRoot.split(": ")[1];
                    result3 = result3.split(" Recebida")[0];
                    l.add("Encomenda n. " + result2 + " : " + result3);
                }
            }
        return l;
    }
}
