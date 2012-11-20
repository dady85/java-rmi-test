package testJavaRMI;

import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RMISecurityManager;
import java.rmi.RemoteException;
import java.net.MalformedURLException;

public class RMISquareRootClient
{
	public static void main(String[] args) 
	{
		int x=Integer.parseInt(args[0]);
		try
		{
			System.setSecurityManager(new RMISecurityManager());
			ISquareRoot squareServer=(ISquareRoot) Naming.lookup("rmi://localhost/RMISquareRoot");
			double result=squareServer.calculateSquareRoot(x);
			System.out.println(result);
		}
		catch(NotBoundException e)
		{
			e.printStackTrace();
		}
		catch(RemoteException e)
		{
			e.printStackTrace();
		}
		catch(MalformedURLException e)
		{
			e.printStackTrace();
		}
	}
}