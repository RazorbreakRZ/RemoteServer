package org.razorbreak;


import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class WebCtrl {
	
	@SuppressWarnings("unused")
	private Logger log = LoggerFactory.getLogger(this.getClass());
	@Autowired @Value("${resources.path}") String resourcesPath;
	
	@RequestMapping(value="/", method=RequestMethod.GET)
	public String webIndex(){ 
		return "index";
	}
	
	@RequestMapping(value="/status/screen", method=RequestMethod.GET)
	public String webStatusScreen(){
		try{
			Rectangle screenRect = new Rectangle(Toolkit.getDefaultToolkit().getScreenSize());
			BufferedImage capture = new Robot().createScreenCapture(screenRect);
			ImageIO.write(capture, "bmp", new File(resourcesPath));
		}catch(Exception e){
			log.error("The screenshot could not be created. Reason: "+e);
		}
		return "status_screen";
	}

}
