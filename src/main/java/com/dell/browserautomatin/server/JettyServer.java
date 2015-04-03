package com.dell.browserautomatin.server;

import org.eclipse.jetty.server.Handler;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.springframework.web.servlet.DispatcherServlet;



/**
 * @author sriram_madavswamy@dell.com This class creates an embedded webserver
 *
 */
public class JettyServer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JettyServer js=new JettyServer();
		js.startServer();
	}

	public void startServer() {
		Server server = new Server(8080);
		server.setHandler(getJettyServerHandler());
		try {
			server.start();
			server.join();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public Handler getJettyServerHandler() {
		ServletContextHandler handler = new ServletContextHandler();
		/*get an object for the xml parameters
		give the object to dispatcher servlet
		give the edispatcher servlet to servlet handler */
		DispatcherServlet dispatcherServlet = new DispatcherServlet();
		handler.addServlet(new ServletHolder(dispatcherServlet),"/*");
		return handler;

	}
}
