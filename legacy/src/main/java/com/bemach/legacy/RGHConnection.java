package com.bemach.legacy;

import java.io.IOException;

public class RGHConnection implements IRGHConnection {
	public RGHConnection(int port, String Name, String passwd) throws IOException {
	}
	
	/* (non-Javadoc)
	 * @see com.bemach.legacy.IRGHConnection#connect()
	 */
	public void connect() {
		
	}
	/* (non-Javadoc)
	 * @see com.bemach.legacy.IRGHConnection#disconnect()
	 */
	public void disconnect() {
		
	}
	
	/* (non-Javadoc)
	 * @see com.bemach.legacy.IRGHConnection#RFDIReportFor(int)
	 */
	public RFDIReport RFDIReportFor (int id) {
		return null;
	}
	
	/* (non-Javadoc)
	 * @see com.bemach.legacy.IRGHConnection#ACTIOReportFor(int)
	 */
	public ACTIOReport ACTIOReportFor (int customerID) {
		return null;
	}
	
	private void retry() {
		
	}
	
	private AFPacket formPacket() {
		return null;
	}

	public void setReport(RFDIReport rfdiReport) {
		// TODO Auto-generated method stub
		
	}
}
