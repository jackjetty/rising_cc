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
 *         &lt;element name="UploadAccDepResult" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="nDepNum" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = { "uploadAccDepResult", "nDepNum" })
@XmlRootElement(name = "UploadAccDepResponse")
public class UploadAccDepResponse {

	@XmlElement(name = "UploadAccDepResult")
	protected String uploadAccDepResult;
	protected int nDepNum;

	/**
	 * Gets the value of the uploadAccDepResult property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getUploadAccDepResult() {
		return uploadAccDepResult;
	}

	/**
	 * Sets the value of the uploadAccDepResult property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setUploadAccDepResult(String value) {
		this.uploadAccDepResult = value;
	}

	/**
	 * Gets the value of the nDepNum property.
	 * 
	 */
	public int getNDepNum() {
		return nDepNum;
	}

	/**
	 * Sets the value of the nDepNum property.
	 * 
	 */
	public void setNDepNum(int value) {
		this.nDepNum = value;
	}

}
