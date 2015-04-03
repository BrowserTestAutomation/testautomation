package com.dell.browserautomation.gridsetup;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class RegisterNodesTest {
	RegisterNodes registerNodes;
	List<Node> linuxNodes;
	List<Node> windowsNodes;

	@Before
	public void setUp() throws Exception {
		registerNodes= new RegisterNodes();
		
		//LinuxNodes set
	 linuxNodes = new ArrayList<Node>();
	 linuxNodes.add(new Node("10.49.7.80","root","Dell_123$"));
		
		//windowsNodes set
	 windowsNodes = new ArrayList<Node>();
	 windowsNodes.add(new Node("10.49.5.67","administrator","Dell_123$"));
	 
	}

	@After
	public void tearDown() throws Exception {
	}
	

	@Test
	public void test() {
		RegisterNodes.registerLinuxNodes(linuxNodes);
		RegisterNodes.registerWindowsNodes(windowsNodes);
		
		fail("Not yet implemented");
	}

}
