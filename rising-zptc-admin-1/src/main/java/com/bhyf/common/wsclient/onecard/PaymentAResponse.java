package com.bhyf.common.wsclient.onecard;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
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
 *         &lt;element name="PaymentAResult" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="nStaSID" type="{http://www.w3.org/2001/XMLSchema}unsignedInt"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = { "paymentAResult", "nStaSID" })
@XmlRootElement(name = "PaymentAResponse")
public class PaymentAResponse {

	@XmlElement(name = "PaymentAResult")
	protected String paymentAResult;
	@XmlSchemaType(name = "unsignedInt")
	protected long nStaSID;

	/**
	 * Gets the value of the paymentAResult property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getPaymentAResult() {
		return paymentAResult;
	}

	/**
	 * Sets the value of the paymentAResult property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setPaymentAResult(String value) {
		this.paymentAResult = value;
	}

	/**
	 * Gets the value of the nStaSID property.
	 * 
	 */
	public long getNStaSID() {
		return nStaSID;
	}

	/**
	 * Sets the value of the nStaSID property.
	 * 
	 */
	public void setNStaSID(long value) {
		this.nStaSID = value;
	}

}