package com.selenium.examples;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class Commando {
	String[] cmdsargs=null;
	String dirpath=null;
	
	void runCommand(){
		List<String> cmdAndArgs = Arrays.asList(cmdsargs);
		File dir = new File(dirpath);
		ProcessBuilder pb = new ProcessBuilder(cmdAndArgs);
		pb.directory(dir);
		try {
			pb.start();
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch(Exception e){
			
		}
	}
	
	
	public void initHub(){
			this.cmdsargs=new String[]{"cmd","/c","start","/min","java","-jar","selenium-server-standalone-2.45.0.jar"
				,"-role","hub","-port","4442"};			
			this.dirpath="C:\\softwares\\Browser_automation";
			this.runCommand();
	}
	
	public void initNode1(){
			/*
			 * connect to remote node and execute the init node commands
			 */
	}
}
