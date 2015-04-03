package com.dell.browserautomation.gridsetup;

import java.util.List;

/**
 * @author Sriram_Madavswamy@dell.com
 * This class registers both windows and linux nodes for selenium browser automation
 * usage : send List of windows and linux nodes
 */
public class RegisterNodes {

	/**
	 * This methods spawns one thread each for a node in the list of windowsNodes
	 * SSHconnector must be implement callable interface
	 */
	public static boolean registerWindowsNodes(List<Node> windowsNodes){
		
		/*	for( node in windowsNodes){
		executor.run(new WindowsConnector(node));
		}*/
	    WindowsConnector windowsConnector;
		for(Node node : windowsNodes){
			new Thread(new WindowsConnector(node)).start();
			//windowsConnector.runCommandOnWindows();
		}
		
		return false;
	}
	
	/**
	 * This methods spawns one thread each for a node in the list of linuxNodes
	 */
	public static boolean registerLinuxNodes(List<Node> linuxNodes){
		
		/*	for( node in linuxNodes){
			executor.run(new SSHconnector(node));
		}*/
		 SSHconnector sshConnector;
		 for(Node node : linuxNodes){
			new Thread(new SSHconnector(node)).start();
		//	 sshConnector.runComandOnLinux();
			}
		
		return false;
	}

}
