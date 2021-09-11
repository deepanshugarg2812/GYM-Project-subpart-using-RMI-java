package com.dao;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.List;

public class ClientClass {

	public static void main(String[] args) throws MalformedURLException, RemoteException, NotBoundException {
		// TODO Auto-generated method stub
		try {
			Members members = (Members) Naming.lookup("rmi://localhost:7777/server");
			List<GYMMember> memberslist = members.getMembers();
			
			for(GYMMember mem : memberslist) {
				System.out.println(mem);
			}
			
		}catch(Exception e) {
			System.out.println("Client error while initializing");
			e.printStackTrace();
		}

	}

}
