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
 *         &lt;element name="GetParmCodeVersionResult" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Version" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = { "getParmCodeVersionResult", "version" })
@XmlRootElement(name = "GetParmCodeVersionResponse")
public class GetParmCodeVersionResponse {

	@XmlElement(name = "GetParmCodeVersionResult")
	protected String getParmCodeVersionResult;
	@XmlElement(name = "Version")
	protected int version;

	/**
	 * Gets the value of the getParmCodeVersionResult property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getGetParmCodeVersionResult() {
		return getParmCodeVersionResult;
	}

	/**
	 * Sets the value of the getParmCodeVersionResult property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setGetParmCodeVersionResult(String value) {
		this.getParmCodeVersionResult = value;
	}

	/**
	 * Gets the value of the version property.
	 * 
	 */
	public int getVersion() {
		return version;
	}

	/**
	 * Sets the value of the version property.
	 * 
	 */
	public void setVersion(int value) {
		this.version = value;
	}

}