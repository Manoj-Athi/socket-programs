import java.rmi.*;
import java.rmi.server.*;

public class opiml extends UnicastRemoteObject implements opin
{
    public int add(int a,int b)throws RemoteException
    {
        return(a+b);
    }
    public int sub(int a,int b)throws RemoteException
    {
        return(a-b);
    }
    public int mul(int a,int b)throws RemoteException
    {
        return(a*b);
    }
    public int div(int a,int b)throws RemoteException
    {
        return(a/b);
    }
    public int mod(int a,int b)throws RemoteException
    {
        return(a%b);
    }
    public int convcf(int a)throws RemoteException
    {
        return((a-32)*5/9);
    }
    public int convfc(int a)throws RemoteException
    {
        return(((9*a)/5)+32);
    }
    public int cgpa(int tot)throws RemoteException
    {
        if(tot>90 && tot<=100)
            return('S');
        else if(tot>80 && tot<=90)
            return('A');
        else if(tot>70 && tot<=80)
            return('B');
        else if(tot>60 && tot<=70)
            return('C');
        else
            return('F');
    }
    public opiml()throws RemoteException
    {
        super();
    }
}