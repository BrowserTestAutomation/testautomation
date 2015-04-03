package com.dell.browserautomation.gridsetup;

/**
 * @author sriram_madavswamy@dell.com
 * class usage : new WindowsConnector("10.10.10.10","administrator","password");
 * for this to work PsExec.exe should be present in c:\softwares
 */

public class WindowsConnector implements Runnable{

	static String  hubIpAddress="10.49.5.102";
	static String userName;
	static String passwd;
	static String ipAddress;
	
	// Command parameters
	static String javaCommand="java -jar "; 
	static String seleniumLocation="//root//Documents//Browser_automation//selenium-server-standalone-2.45.0.jar ";
	static String hubConnection=" -role node -hub http://"+hubIpAddress+":4444/grid/register";
	static String psExecLocation="C:\\softwares";
	
	
	public WindowsConnector(Node node){
		userName=node.userName;
		passwd=node.passwd;
		ipAddress="\\\\"+node.ipAddress;
	}
	
	
	/**
	 * This method is used to run commands on Windows Node from Windows Hub using a tool called PsExec.exe
	 */
	public void runCommandOnWindows(){
		System.out.println("running command for windows ip "+ipAddress);
		Commando comd=new Commando();
		
		comd.cmdsargs=new String[]{
				"cmd","/c","start","/min","PsExec.exe",
				
				ipAddress,"-u",userName,"-p",passwd,
				"-d",
				"-w","c:\\softwares",
				//\\Browser_automation
				"java","-jar","selenium-server-standalone-2.45.0.jar",
				"-role","node","-hub","http://10.49.5.102:4444/grid/register",
				"-port","5553"		
		};	
		
		comd.dirpath=(psExecLocation);
		comd.runCommand();
		System.out.println(" windows "+ipAddress+" ended");
	}


	public void run() {
		// TODO Auto-generated method stub
		runCommandOnWindows();
	}
	
	
}
