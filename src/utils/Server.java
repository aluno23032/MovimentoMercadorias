package utils;

import java.net.InetAddress;
import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

public class Server {

    public static final String remoteName = "RemoteHello";
    public static final int remotePort = 10011;

    public static void main(String[] args) throws Exception {
        //create object  to listen in the remote port
        RemoteObject helloWorld = new RemoteObject(remotePort);
        //local adress of server
        String host = InetAddress.getLocalHost().getHostAddress();
        //create registry to object
        LocateRegistry.createRegistry(remotePort);
        //create adress of remote object
        String address = String.format("//%s:%d/%s", host, remotePort, remoteName);
        //link adress to object 
        Naming.rebind(address, helloWorld);
        System.out.printf("Ready on %s%n", address);
    }

}
