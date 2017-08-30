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
 *         &lt;element name="GetAccDBMoneyResult" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="nMoney" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = { "getAccDBMoneyResult", "nMoney" })
@XmlRootElement(name = "GetAccDBMoneyResponse")
public class GetAccDBMoneyResponse {

	@XmlElement(name = "GetAccDBMoneyResult")
	protected String getAccDBMoneyResult;
	protected int nMoney;

	/**
	 * Gets the value of the getAccDBMoneyResult property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getGetAccDBMoneyResult() {
		return getAccDBMoneyResult;
	}

	/**
	 * Sets the value of the getAccDBMoneyResult property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setGetAccDBMoneyResult(String value) {
		this.getAccDBMoneyResult = value;
	}

	/**
	 * Gets the value of the nMoney property.
	 * 
	 */
	public int getNMoney() {
		return nMoney;
	}

	/**
	 * Sets the value of the nMoney property.
	 * 
	 */
	public void setNMoney(int value) {
		this.nMoney = value;
	}

}
