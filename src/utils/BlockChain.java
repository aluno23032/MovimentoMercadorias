package utils;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

public class BlockChain implements Serializable {

    ArrayList<Block> chain = new ArrayList<>();

    public String getLastBlockHash() {
        if (chain.isEmpty()) {
            return String.format("%08d", 0);
        }
        return chain.get(chain.size() - 1).currentHash;
    }

    public int getLength() {
        return chain.size();
    }

    public void add(String data, int dificulty) throws InterruptedException, RemoteException, NotBoundException, MalformedURLException {
        //hash of previous block
        String prevHash = getLastBlockHash();
        //mining block
        String host = "localhost";
        String remoteObject = String.format("//%s:%d/%s", host, Server.remotePort, Server.remoteName);
        RemoteInterface remoteHello = (RemoteInterface) Naming.lookup(remoteObject);
        int nonce = remoteHello.mine(dificulty);
        //build new block
        Block newBlock = new Block(prevHash, Hash.getHash(data), nonce);
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
            if (!chain.get(i).previousHash.equals(chain.get(i - 1).currentHash)) {
                return false;
            }
        }
        return true;
    }

    public List<String> getUsers() {
        List<String> l = new ArrayList<>();
        String user;
        for (Block bloco : chain) {
            String result = bloco.data.split("feita por ")[1];
            result = result.split(" ao fornecedor")[0];
            user = result;
            if (!l.contains(user)) {
                l.add(user);
            }
        }
        return l;
    }

    public List<String> getUserEncomendas(String user) {
        List<String> l = new ArrayList<>();
        for (Block bloco : chain) {
            String result = bloco.data.split("feita por ")[1];
            result = result.split(" ao fornecedor")[0];
            if (result.equals(user)) {
                if (!l.isEmpty()) {
                    boolean hasOld = false;
                    for (String entry : l) {
                        if (entry.contains("1")) {
                            hasOld = true;
                        }
                    }
                    if (hasOld == true) {
                        l.removeIf(s -> s.contains("1"));
                    }
                    if (!bloco.data.contains("Recebida")) {
                        String result2 = bloco.data.split("Encomenda n. ")[1];
                        result2 = result2.split(" feita por")[0];
                        String result3 = bloco.data.split(": ")[1];
                        result3 = result3.split(" Recebida")[0];
                        l.add("Encomenda n. " + result2 + " : " + result3);
                    }
                } else {
                    String result2 = bloco.data.split("Encomenda n. ")[1];
                    result2 = result2.split(" feita por")[0];
                    String result3 = bloco.data.split(": ")[1];
                    result3 = result3.split(" Recebida")[0];
                    l.add("Encomenda n. " + result2 + " : " + result3);
                }
            }
        }
        return l;
    }
}
