package com.uro.sprmvc.common.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

// 위의 임포트와 아래 @XmlRootElement 등의 태그가 없으면 json으로 토해냄.


@XmlRootElement(name = "coffee")
public class Coffee {
 
	String name;
	int quanlity;
 
	public String getName() {
		return name;
	}
 
	@XmlElement
	public void setName(String name) {
		this.name = name;
	}
 
	public int getQuanlity() {
		return quanlity;
	}
 
	@XmlElement
	public void setQuanlity(int quanlity) {
		this.quanlity = quanlity;
	}
 
	public Coffee(String name, int quanlity) {
		this.name = name;
		this.quanlity = quanlity;
	}
 
	public Coffee() {
	}
 
}