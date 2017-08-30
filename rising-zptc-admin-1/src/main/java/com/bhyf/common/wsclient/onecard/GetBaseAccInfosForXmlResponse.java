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
 *         &lt;element name="GetBaseAccInfosForXmlResult" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Data" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="nCurrVersion" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = { "getBaseAccInfosForXmlResult", "data",
		"nCurrVersion" })
@XmlRootElement(name = "GetBaseAccInfosForXmlResponse")
public class GetBaseAccInfosForXmlResponse {

	@XmlElement(name = "GetBaseAccInfosForXmlResult")
	protected String getBaseAccInfosForXmlResult;
	@XmlElement(name = "Data")
	protected String data;
	protected int nCurrVersion;

	/**
	 * Gets the value of the getBaseAccInfosForXmlResult property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getGetBaseAccInfosForXmlResult() {
		return getBaseAccInfosForXmlResult;
	}

	/**
	 * Sets the value of the getBaseAccInfosForXmlResult property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setGetBaseAccInfosForXmlResult(String value) {
		this.getBaseAccInfosForXmlResult = value;
	}

	/**
	 * Gets the value of the data property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getData() {
		return data;
	}

	/**
	 * Sets the value of the data property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setData(String value) {
		this.data = value;
	}

	/**
	 * Gets the value of the nCurrVersion property.
	 * 
	 */
	public int getNCurrVersion() {
		return nCurrVersion;
	}

	/**
	 * Sets the value of the nCurrVersion property.
	 * 
	 */
	public void setNCurrVersion(int value) {
		this.nCurrVersion = value;
	}

}
