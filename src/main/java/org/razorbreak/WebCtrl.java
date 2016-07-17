package org.razorbreak;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class WebCtrl {
	
	private Logger log = LoggerFactory.getLogger(this.getClass());
	@Autowired @Value("${addons.path}") String addonsPath;
	@Autowired @Value("${resources.path}") String resourcesPath;
	
	@RequestMapping(value="/", method=RequestMethod.GET)
	public String webIndex(){ 
		return "index";
	}
	
	@SuppressWarnings("unused")
	@RequestMapping(value="/status/screen", method=RequestMethod.GET)
	public String webStatusScreen(){
		try{
			Process runtimeProcess = Runtime.getRuntime().exec(addonsPath+"/boxcutter-fs "+resourcesPath+"/screenshot.bmp");
			Thread.sleep(Constants.TIMEOUT);
		}catch(Exception e){
			log.error("The screenshot could not be created. Reason: "+e);
		}
		return "status_screen";
	}

}
