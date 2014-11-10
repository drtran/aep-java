package com.bemach.legacy;

public class FakeConnection implements IRGHConnection {

	private RFDIReport report;
	
	public FakeConnection(String string, String string2) {
		// TODO Auto-generated constructor stub
	}
	
	public FakeConnection() {
		// TODO Auto-generated constructor stub
	}

	public void connect() {}
	public void disconnect() {}
	public RFDIReport RFDIReportFor(int id) { return report; }
	public ACTIOReport ACTIOReportFor(int customerID) { return null; }
	public void setReport(RFDIReport rfdiReport) {
		this.report = rfdiReport;
	}
}
