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
 *         &lt;element name="ValidatePayPasswordResult" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = { "validatePayPasswordResult" })
@XmlRootElement(name = "ValidatePayPasswordResponse")
public class ValidatePayPasswordResponse {

	@XmlElement(name = "ValidatePayPasswordResult")
	protected String validatePayPasswordResult;

	/**
	 * Gets the value of the validatePayPasswordResult property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getValidatePayPasswordResult() {
		return validatePayPasswordResult;
	}

	/**
	 * Sets the value of the validatePayPasswordResult property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setValidatePayPasswordResult(String value) {
		this.validatePayPasswordResult = value;
	}

}
