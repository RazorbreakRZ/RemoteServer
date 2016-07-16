package org.razorbreak;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class WebCtrl {
	
	@SuppressWarnings("unused")
	private Logger log = LoggerFactory.getLogger(this.getClass());
	
	@RequestMapping(value="/", method=RequestMethod.GET)
	public String webIndex(){ 
		return "index";
	}
	
	@RequestMapping(value="/status/screen", method=RequestMethod.GET)
	public String webStatusScreen(){
		return "status_screen";
	}

}
