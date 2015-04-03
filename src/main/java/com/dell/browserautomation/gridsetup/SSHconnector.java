package com.dell.browserautomation.gridsetup;

import com.jcraft.jsch.*;

import java.io.InputStream;

/**
 * @author sriram_madavswamy@dell.com
 * Class usage : new callable(new SSHconnector("10.10.10.10","root","passwd"))
 *
 */
public class SSHconnector implements Runnable{
	// Node credentials
	static String  hubIpAddress="10.49.5.102";
	static String userName;
	static String passwd;
	static String ipAddress;
	
	// Command parameters
	static String javaCommand="java -jar "; 
	static String seleniumLocation="//root//Documents//Browser_automation//selenium-server-standalone-2.45.0.jar ";
	static String hubConnection=" -role node -hub http://"+hubIpAddress+":4444/grid/register:5553";
	
	
	public SSHconnector(Node node){
		userName=node.userName;
		passwd=node.passwd;
		ipAddress=node.ipAddress;
	}

	public  void runComandOnLinuxExec() {
		try {
			System.out.println("running command for linux ip "+ipAddress);
			String command=javaCommand+seleniumLocation+hubConnection;
			JSch jsch = new JSch();	

			Session session = jsch.getSession(userName, ipAddress, 22);
			
			session.setPassword(passwd);
			session.setConfig("StrictHostKeyChecking", "no");
			session.connect(); // making a connection with timeout.

			Channel channel = session.openChannel("exec");
			//((ChannelExec)channel).setCommand("ls /root/Documents/Browser_automation");
			((ChannelExec)channel).setCommand(command);
			channel.connect();
			InputStream in=channel.getInputStream();
			byte[] tmp = new byte[1024];
			while (true) {
				while (in.available() > 0) {
					int i = in.read(tmp, 0, 1024);
					if (i < 0)
						break;
					System.out.print(new String(tmp, 0, i));
				}
				if (channel.isClosed()) {
					if (in.available() > 0)
						continue;
					System.out.println("exit-status: "
							+ channel.getExitStatus());
					break;
				}
				try {
					Thread.sleep(1000);
				} catch (Exception ee) {
				}
			}

		} catch (Exception e) {
			System.out.println("caught exception");
			e.printStackTrace();
		}
		System.out.println(" linux "+ipAddress+" ended");
	}

	public  void runComandOnLinux() {
		try {
			System.out.println("running command for linux ip "+ipAddress);
			String command=javaCommand+seleniumLocation+hubConnection;
			JSch jsch = new JSch();	

			Session session = jsch.getSession(userName, ipAddress, 22);
			
			session.setPassword(passwd);
			session.setConfig("StrictHostKeyChecking", "no");
			session.connect(); // making a connection with timeout.

			Channel channel = session.openChannel("shell");
			channel.setOutputStream(System.out);
			//((ChannelExec)channel).setCommand("ls /root/Documents/Browser_automation");
			((ChannelExec)channel).setCommand(command);
			channel.connect();
			/*InputStream in=channel.getInputStream();
			byte[] tmp = new byte[1024];
			while (true) {
				while (in.available() > 0) {
					int i = in.read(tmp, 0, 1024);
					if (i < 0)
						break;
					System.out.print(new String(tmp, 0, i));
				}
				if (channel.isClosed()) {
					if (in.available() > 0)
						continue;
					System.out.println("exit-status: "
							+ channel.getExitStatus());
					break;
				}
				try {
					Thread.sleep(1000);
				} catch (Exception ee) {
				}
			}*/

		} catch (Exception e) {
			System.out.println("caught exception");
			e.printStackTrace();
		}
		System.out.println(" linux "+ipAddress+" ended");
	}

	public void run() {
		// TODO Auto-generated method stub
		runComandOnLinux();
	}
}

