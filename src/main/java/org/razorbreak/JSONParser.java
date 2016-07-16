package org.razorbreak;

import java.io.File;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.databind.ObjectMapper;

public class JSONParser {
	
	private Logger log = LoggerFactory.getLogger(this.getClass());
	
	public JSONParser(){}
	
	public DtoApplications parseJSON(String filePath){
		log.debug("Parsing JSON configuration file");
		DtoApplications applications = new DtoApplications();
		ObjectMapper mapper = new ObjectMapper();
		try{
			applications = mapper.readValue(new File(filePath), DtoApplications.class);
			log.trace(applications.toString());
		}catch(Exception e){
			log.error("The JSON configuration file could not be parsed. Reason: "+e);
		}
		return applications;
	}

}
