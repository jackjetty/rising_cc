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
 *         &lt;element name="GetErrTxtResult" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="sErrTxt" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = { "getErrTxtResult", "sErrTxt" })
@XmlRootElement(name = "GetErrTxtResponse")
public class GetErrTxtResponse {

	@XmlElement(name = "GetErrTxtResult")
	protected String getErrTxtResult;
	protected String sErrTxt;

	/**
	 * Gets the value of the getErrTxtResult property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getGetErrTxtResult() {
		return getErrTxtResult;
	}

	/**
	 * Sets the value of the getErrTxtResult property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setGetErrTxtResult(String value) {
		this.getErrTxtResult = value;
	}

	/**
	 * Gets the value of the sErrTxt property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getSErrTxt() {
		return sErrTxt;
	}

	/**
	 * Sets the value of the sErrTxt property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setSErrTxt(String value) {
		this.sErrTxt = value;
	}

}
