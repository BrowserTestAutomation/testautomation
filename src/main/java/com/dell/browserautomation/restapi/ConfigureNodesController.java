package com.dell.browserautomation.restapi;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;




//@RequestMapping("/configureBrowser")
@Controller
public class ConfigureNodesController {

	@RequestMapping(value="/",method=RequestMethod.GET)
	public String welcome(){
		
		return "welcome";
	}
	
	
	@RequestMapping(value="/configureBrowser",method=RequestMethod.GET)
	public void configureBrowser( ){
		
	}
}
