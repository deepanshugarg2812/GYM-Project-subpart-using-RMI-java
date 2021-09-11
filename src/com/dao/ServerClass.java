package com.dao;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

public class ServerClass extends UnicastRemoteObject implements Members{

	protected ServerClass() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public List<GYMMember> getMembers() throws RemoteException{
		DatabaseClass dc = new DatabaseClass();
		return dc.getMembers();
	}

	public static void main(String[] args) {
		try {
			//Get the registery and map the object to name in it
			Registry registry = LocateRegistry.createRegistry(7777);
			registry.bind("server", new ServerClass());
			System.out.println("Server started");
		}catch(Exception e) {
			System.out.println("Error while initializing the server");
		}
	}

}
