package testJavaRMI;

import java.net.MalformedURLException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.rmi.AlreadyBoundException;
import java.rmi.Naming;
import java.rmi.RemoteException;

public class RMISquareRootServer extends UnicastRemoteObject implements ISquareRoot
{
	private static final long serialVersionUID=1L;

	public RMISquareRootServer()throws RemoteException
	{
	
	}
	
	public double calculateSquareRoot(double aNumber)
	{
		return Math.sqrt(aNumber);
	}
	
	public static void main(String[] args)
	{
		try 
		{
			ISquareRoot server=new RMISquareRootServer();
			Naming.rebind("RMISquareRoot",server);
			System.out.println("Il Server è pronto");
		}
		catch (RemoteException | MalformedURLException e)
		{
			e.printStackTrace();
		}
	 }
}