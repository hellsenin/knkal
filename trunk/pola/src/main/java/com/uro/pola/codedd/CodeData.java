package com.uro.pola.codedd;

import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.Range;

public class CodeData {

	@NotEmpty
	private String CodeId;
	
	@NotEmpty
	private String CodeIdNm;
	
	private String CodeIdDc;

	@NotEmpty
	private String Code;

	private String FrstRegistPnttm;

	private String FrstRegisterId;

	private String LastUpdtPnttm;

	private String LastUpdusrId;

	public String getCodeId() {
		return CodeId;
	}

	public void setCodeId(String codeId) {
		CodeId = codeId;
	}

	public String getCodeIdNm() {
		return CodeIdNm;
	}

	public void setCodeIdNm(String codeIdNm) {
		CodeIdNm = codeIdNm;
	}

	public String getCodeIdDc() {
		return CodeIdDc;
	}

	public void setCodeIdDc(String codeIdDc) {
		CodeIdDc = codeIdDc;
	}

	public String getCode() {
		return Code;
	}

	public void setCode(String code) {
		Code = code;
	}

	public String getFrstRegistPnttm() {
		return FrstRegistPnttm;
	}

	public void setFrstRegistPnttm(String frstRegistPnttm) {
		FrstRegistPnttm = frstRegistPnttm;
	}

	public String getFrstRegisterId() {
		return FrstRegisterId;
	}

	public void setFrstRegisterId(String frstRegisterId) {
		FrstRegisterId = frstRegisterId;
	}

	public String getLastUpdtPnttm() {
		return LastUpdtPnttm;
	}

	public void setLastUpdtPnttm(String lastUpdtPnttm) {
		LastUpdtPnttm = lastUpdtPnttm;
	}

	public String getLastUpdusrId() {
		return LastUpdusrId;
	}

	public void setLastUpdusrId(String lastUpdusrId) {
		LastUpdusrId = lastUpdusrId;
	}

}
