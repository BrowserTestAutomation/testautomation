package com.dell.browserautomation.gridsetup;

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
}
