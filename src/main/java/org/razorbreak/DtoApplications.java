package org.razorbreak;

import java.util.ArrayList;
import java.util.Iterator;

public class DtoApplications {
	
	ArrayList<DtoApplication> applications;

	public DtoApplications() {
		super();
		this.applications = new ArrayList<>();
	}
	
	public DtoApplications(ArrayList<DtoApplication> applications) {
		super();
		this.applications = applications;
	}

	public ArrayList<DtoApplication> getApplications() {
		return applications;
	}

	public void setApplications(ArrayList<DtoApplication> applications) {
		this.applications = applications;
	}
	
	public void addNewApplication(DtoApplication application) {
		if(checkExistApplication(application.getAppName())==null)
			this.applications.add(application);
	}
		
	public DtoApplication checkExistApplication(String appName){
		Iterator<DtoApplication> iter = this.applications.iterator();
		DtoApplication elem = null;
		while(iter.hasNext()){
			elem = iter.next();
			if(elem.getAppName().equals(appName))
				return elem;
		}
		return null;
	}

	@Override
	public String toString() {
		String s = "";
		s += "Mapped ["+this.applications.size()+"] applications";
		int i = 1;
		for(DtoApplication app : this.applications){
			s += "\n  ["+i+"] " + app +"";
			i++;
		}
		return s;
	}
	
	

}
