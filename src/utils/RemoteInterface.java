package utils;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface RemoteInterface  extends Remote{
    public String getMessage() throws RemoteException;
    public int mine(String data, int difficulty) throws RemoteException;
}
