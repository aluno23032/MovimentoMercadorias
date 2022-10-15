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
        //history.add(new Movimento("José", "IKI Mobile", 1));
    }

    @Override
    public String toString() {
        StringBuilder txt = new StringBuilder();
        for (Movimento movimento : history) {
            txt.append(movimento.toString()).append("\n");
        }
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
