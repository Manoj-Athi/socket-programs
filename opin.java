import java.rmi.*;

public interface opin extends Remote
{
    public int add(int a,int b)throws RemoteException;
    public int sub(int a,int b)throws RemoteException;
    public int mul(int a,int b)throws RemoteException;
    public int div(int a,int b)throws RemoteException;
    public int mod(int a,int b)throws RemoteException;
    public int convcf(int a)throws RemoteException;
    public int convfc(int a)throws RemoteException;
    public int cgpa(int tot)throws RemoteException;
}