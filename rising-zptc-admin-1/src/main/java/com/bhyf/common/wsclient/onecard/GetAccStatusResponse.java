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
 *         &lt;element name="GetAccStatusResult" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="bValid" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = { "getAccStatusResult", "bValid" })
@XmlRootElement(name = "GetAccStatusResponse")
public class GetAccStatusResponse {

	@XmlElement(name = "GetAccStatusResult")
	protected String getAccStatusResult;
	protected boolean bValid;

	/**
	 * Gets the value of the getAccStatusResult property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getGetAccStatusResult() {
		return getAccStatusResult;
	}

	/**
	 * Sets the value of the getAccStatusResult property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setGetAccStatusResult(String value) {
		this.getAccStatusResult = value;
	}

	/**
	 * Gets the value of the bValid property.
	 * 
	 */
	public boolean isBValid() {
		return bValid;
	}

	/**
	 * Sets the value of the bValid property.
	 * 
	 */
	public void setBValid(boolean value) {
		this.bValid = value;
	}

}
