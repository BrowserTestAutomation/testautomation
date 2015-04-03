package com.dell.browserautomation.gridsetup;

public class Node {
	String ipAddress;
	String userName;
	String passwd;
	
	
	public Node(String ipAddress, String userName, String passwd){
		this.ipAddress=ipAddress;
		this.userName=userName;
		this.passwd=passwd;
	}
}
