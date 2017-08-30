package com.bhyf.common.wsclient.onecard;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for anonymous complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="UploadParamTypeResult" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = { "uploadParamTypeResult" })
@XmlRootElement(name = "UploadParamTypeResponse")
public class UploadParamTypeResponse {

	@XmlElement(name = "UploadParamTypeResult")
	protected String uploadParamTypeResult;

	/**
	 * Gets the value of the uploadParamTypeResult property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getUploadParamTypeResult() {
		return uploadParamTypeResult;
	}

	/**
	 * Sets the value of the uploadParamTypeResult property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setUploadParamTypeResult(String value) {
		this.uploadParamTypeResult = value;
	}

}
