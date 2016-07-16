package org.razorbreak;

public class DtoOperation {
		
	private String operName;
	private String commandLine;
	
	public DtoOperation(){
		super();
	}
	
	public DtoOperation(String operName, String commandLine) {
		super();
		this.operName = operName;
		this.commandLine = commandLine;
	}
	
	public String getOperName() {
		return operName;
	}
	
	public void setOperName(String operName) {
		this.operName = operName;
	}
	
	public String getCommandLine() {
		return commandLine;
	}
	
	public void setCommandLine(String commandLine) {
		this.commandLine = commandLine;
	}

	@Override
	public String toString() {
		return "{" + operName + ",'" + commandLine + "'}";
	}

	
}
