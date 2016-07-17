package org.razorbreak;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@EnableAsync
@RestController
@RequestMapping("")
public class ServiceCtrl {
	
	private Logger log = LoggerFactory.getLogger(this.getClass());
	
	private final long TIMEOUT = 1500;
	private DtoApplications applications = new DtoApplications();
	private String username;
	private String password;
	private String resourcesPath;
	private JSONParser jsonParser = new JSONParser();
	
	@Autowired
	public ServiceCtrl(
			@Value("${account.username}") String username,
			@Value("${account.password}") String password,
			@Value("${json.path}") String filePath,
			@Value("${resources.path}") String resourcesPath){
		log.trace("Initializing internal systems...");
		this.username = username;
		this.password = password;
		log.debug("Execution credentials ["+this.username+":"+this.password.replaceAll(".","*")+"]");
		this.resourcesPath = resourcesPath;
		log.debug("Resources path: "+this.resourcesPath);
		applications = jsonParser.parseJSON(filePath);
		log.trace("Initialization completed!");
	}
			
	@RequestMapping(value="/applications/{app}/{oper}", method=RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<Object> appServlet(
			@PathVariable String app,
			@PathVariable String oper,
			HttpServletRequest request,
			HttpServletResponse response){
		log.trace("Incoming connection from ["+request.getRemoteAddr()+"] --> APP:["+app+"] OPER:["+oper+"] PARAMS:[]");
		return processResponse(app, oper);
	}
	
	private ResponseEntity<Object> processResponse(String app, String oper){
		String message = "Operation result: "+ filterOperation(app, oper);
		return new ResponseEntity<Object>(message,HttpStatus.OK);
	}
	
	private boolean filterOperation(String appName, String operName){
		DtoApplication app = this.applications.checkExistApplication(appName);
		DtoOperation oper;
		boolean exist = (app != null);
		log.trace("Checking APPLICATION code ["+appName+"]: "+exist);
		if(exist){
			oper = app.checkExistOperation(operName);
			exist = (oper != null);
			log.trace("Checking OPERATION code ["+operName+"] for APPLICATION ["+appName+"]: "+exist);
			if(exist){
				return executeOperation(oper);
			}
		}
		return false;
	}
	
	@SuppressWarnings("unused")
	private boolean executeOperation(DtoOperation oper){
		for(String cmd : oper.getCommandLines()){
			try {
				log.debug("Executing command line: "+cmd);
				Process runtimeProcess = Runtime.getRuntime().exec(cmd);
				Thread.sleep(TIMEOUT);
			} catch (Exception e) {
				log.error("An error ocurred while launching the command. Reason: "+e);
				return false;
			}
		}
		return true;
	}

}
