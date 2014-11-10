package com.bemach.legacy;

public interface IRGHConnection {

	public abstract void connect();

	public abstract void disconnect();

	public abstract RFDIReport RFDIReportFor(int id);

	public abstract ACTIOReport ACTIOReportFor(int customerID);

	public abstract void setReport(RFDIReport rfdiReport);

}