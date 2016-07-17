package org.razorbreak;

import java.util.ArrayList;
import java.util.Iterator;

public class DtoApplication {
		
	private String appName;
	private ArrayList<DtoOperation> operations;
	
	public DtoApplication() {
		super();
	}
	
	public DtoApplication(String appName) {
		super();
		this.appName = appName;
		this.operations = new ArrayList<>();
	}
	
	public DtoApplication(String appName, ArrayList<DtoOperation> operations) {
		super();
		this.appName = appName;
		this.operations = operations;
	}

	public String getAppName() {
		return appName;
	}

	public void setAppName(String appName) {
		this.appName = appName;
	}

	public ArrayList<DtoOperation> getOperations() {
		return operations;
	}

	public void setOperations(ArrayList<DtoOperation> operations) {
		this.operations = operations;
	}
	
	public void addNewOperation(DtoOperation operation) {
		if(checkExistOperation(operation.getOperName())==null)
			this.operations.add(operation);
	}
	
//	public void addNewOperation(String operName, String commandLine) {
//		if(checkExistOperation(operName)==null)
//			this.operations.add(new DtoOperation(operName, commandLine));
//	}
	
	public DtoOperation checkExistOperation(String operName) {
		Iterator<DtoOperation> iter = this.operations.iterator();
		DtoOperation elem = null;
		while(iter.hasNext()){
			elem = iter.next();
			if(elem.getOperName().equals(operName))
				return elem;
		}
		return null;
	}

	@Override
	public String toString() {
		String s = "["+ this.appName + "]  [";
		for(DtoOperation oper : this.operations){
			s += oper +"";
		}
		s += "]";
		return s;
	}
	
	
		

}
