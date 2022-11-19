package trackingEncomendas;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author manso
 */
public class Ledger {

    List<Movimento> history;

    public Ledger() {
        history = new ArrayList<>();
    }

    @Override
    public String toString() {
        StringBuilder txt = new StringBuilder();
        for (Movimento movimento : history) {
            txt.append(movimento.toString()).append("\n");
        }
        return txt.toString();
    }
    
    public String toGUIString() {
        StringBuilder txt = new StringBuilder();
        txt.append("<html>");
        for (Movimento movimento : history) {
            txt.append(movimento.toString()).append("<br>");
        }
        txt.append("</html>");
        return txt.toString();
    }

    public void add(Movimento m) {
        for (Movimento movimento : history) {
            if (movimento.isRecebido() == true && movimento.getIdEncomenda() == m.getIdEncomenda()) {
                throw new IllegalArgumentException("Essa encomenda ja foi entregue.");
            }
        }
        if (m.getCurrent().equals(m.getTo())) {
            m.setRecebido(true);
        }
        history.add(m);
    }

    public String getCurrent(String to) {
        String current = "";
        for (Movimento movimento : history) {
            if (movimento.getTo().equals(to)) {
                current = movimento.getCurrent();
            }
        }
        return current;
    }
    
    public List<String> getUsers() {
        List<String> l = new ArrayList<>();
        String user;
        for (Movimento movimento : history) {
            user = movimento.getTo();
            if (!l.contains(user)) {
                l.add(user);
            }
        }
        return l;
        
    }

    public List<Movimento> getHistory() {
        return history;
    }
    
    public void clearHistory() {
        history = new ArrayList<>();
    }

    public List<String> getUserEncomendas(String user) {
        List<String> l = new ArrayList<>();
        for (Movimento movimento : history) {
            if (movimento.getTo().equals(user)) {
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
                    if (!movimento.isRecebido()) {
                        l.add("Encomenda n. " + Integer.toString(movimento.getIdEncomenda()) + " : " + movimento.getCurrent());
                    }
                } else {
                    l.add("Encomenda n. " + Integer.toString(movimento.getIdEncomenda()) + " : " + movimento.getCurrent());
                }
            }
        }
        return l;
    }
    
    public void saveFile(String fileName) throws FileNotFoundException {
        try ( PrintStream out = new PrintStream(new File(fileName))) {
            out.println(toString());
        }
    }

    public static Ledger load(String filName) throws FileNotFoundException {
        Scanner file = new Scanner(new File(filName));
        Ledger tmp = new Ledger();
        tmp.history.clear();
        DateTimeFormatter inputFormat = DateTimeFormatter.ofPattern("MM/dd/yyyy HH:mm:ss");
        while (file.hasNext()) {
            //ler uma linha
            String line = file.nextLine();
            //partir a linha nos elementos
            String[] elem = line.split(" ");
            //fazer uma trasção com os elementos
            Movimento m = new Movimento(elem[0], elem[1], elem[2] ,Integer.parseInt(elem[3]), LocalDateTime.parse(elem[4], inputFormat));
            //adicionar a transacao ao objeto
            tmp.history.add(m);
        }
        return tmp;
    }
}
