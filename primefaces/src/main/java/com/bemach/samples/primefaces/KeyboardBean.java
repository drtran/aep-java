package com.bemach.samples.primefaces;


import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class KeyboardBean {
	private String value;
	
	public String getValue() {
		System.out.println("getValue: " + value);
		return value;
	}
	
	public void setValue (String value) {
		System.out.println("setValue: " + value);
		this.value = value;
	}
}
