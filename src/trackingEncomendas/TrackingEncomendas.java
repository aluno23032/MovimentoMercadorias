/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package trackingEncomendas;

import java.time.LocalDateTime;
import java.time.Month;

/**
 *
 * @author Eduardo
 */
public class TrackingEncomendas {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Ledger l = new Ledger();
        Movimento m = new Movimento("IKI Mobile", "Jose", "IKI Mobile", 1, LocalDateTime.of(2022, Month.OCTOBER, 13, 20, 0, 0));
        l.add(m);
        m = new Movimento("IKI Mobile", "Jose", "DHL", 1, LocalDateTime.of(2022, Month.OCTOBER, 15, 20, 0, 0));
        l.add(m);
        m = new Movimento("IKI Mobile", "Jose", "Jose", 1, LocalDateTime.of(2022, Month.OCTOBER, 16, 20, 0, 0));
        l.add(m);
        System.out.println(l.toString());
    }
}
