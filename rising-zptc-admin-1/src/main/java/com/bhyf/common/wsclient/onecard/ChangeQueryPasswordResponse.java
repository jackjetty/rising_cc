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
 *         &lt;element name="ChangeQueryPasswordResult" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = { "changeQueryPasswordResult" })
@XmlRootElement(name = "ChangeQueryPasswordResponse")
public class ChangeQueryPasswordResponse {

	@XmlElement(name = "ChangeQueryPasswordResult")
	protected String changeQueryPasswordResult;

	/**
	 * Gets the value of the changeQueryPasswordResult property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getChangeQueryPasswordResult() {
		return changeQueryPasswordResult;
	}

	/**
	 * Sets the value of the changeQueryPasswordResult property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setChangeQueryPasswordResult(String value) {
		this.changeQueryPasswordResult = value;
	}

}
