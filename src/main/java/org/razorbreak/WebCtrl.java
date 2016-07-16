package org.razorbreak;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

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
