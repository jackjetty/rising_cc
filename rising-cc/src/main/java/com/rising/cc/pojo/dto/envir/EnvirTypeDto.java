package com.rising.cc.pojo.dto.envir;

import com.rising.cc.common.component.BaseDto;

@SuppressWarnings("serial")
public class EnvirTypeDto extends BaseDto{
	
	private String envirName;
	
	private String envirCode;
	
	public String getEnvirName() {
		return envirName;
	}

	public void setEnvirName(String envirName) {
		this.envirName = envirName;
	}

	public String getEnvirCode() {
		return envirCode;
	}

	public void setEnvirCode(String envirCode) {
		this.envirCode = envirCode;
	}

	
}
