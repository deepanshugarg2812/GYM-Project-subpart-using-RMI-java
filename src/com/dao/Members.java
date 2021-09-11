package com.dao;


import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.*;

public interface Members extends Remote {
	public List<GYMMember> getMembers() throws RemoteException;
}
