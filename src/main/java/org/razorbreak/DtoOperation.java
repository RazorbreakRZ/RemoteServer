package org.razorbreak;

import java.util.ArrayList;

public class DtoOperation {
		
	private String operName;
	private ArrayList<String> commandLines;
	
	public DtoOperation(){
		super();
	}
	
//	public DtoOperation(String operName, String commandLine) {
//		super();
//		this.operName = operName;
//		this.commandLines.add(commandLine);
//	}
	
	public DtoOperation(String operName, ArrayList<String> commandLines) {
		super();
		this.operName = operName;
		this.commandLines = commandLines;
	}
	
	public String getOperName() {
		return operName;
	}
	
	public void setOperName(String operName) {
		this.operName = operName;
	}
	
	public ArrayList<String> getCommandLines() {
		return this.commandLines;
	}
	
	public void setCommandLines(ArrayList<String> commandLines) {
		this.commandLines = commandLines;
	}

	@Override
	public String toString() {
		String s = "";
		s += "{" + operName + ", [";
		for(String cmd : this.commandLines){
			s += " '"+cmd+"'";
		}
		s += " ]}";
		return s;
	}

	
}
