package head_first设计模式.ch11;

import head_first设计模式.ch10.State;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * @Description
 * @ClassName GumballMachineRemote
 * @Author weilc
 * @Date 2021-01-28
 * @Version 1.0
 */
public interface GumballMachineRemote extends Remote {
    int getCount() throws RemoteException;
    String getLocation() throws RemoteException;
    State getState() throws RemoteException;
}
