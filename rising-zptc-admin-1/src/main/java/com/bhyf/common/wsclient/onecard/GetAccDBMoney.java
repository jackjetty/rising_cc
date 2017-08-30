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
 *         &lt;element name="sIDNo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="nIDType" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="nEWalletNum" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = { "sidNo", "nidType", "neWalletNum" })
@XmlRootElement(name = "GetAccDBMoney")
public class GetAccDBMoney {

	@XmlElement(name = "sIDNo")
	protected String sidNo;
	@XmlElement(name = "nIDType")
	protected int nidType;
	@XmlElement(name = "nEWalletNum")
	protected int neWalletNum;

	/**
	 * Gets the value of the sidNo property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getSIDNo() {
		return sidNo;
	}

	/**
	 * Sets the value of the sidNo property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setSIDNo(String value) {
		this.sidNo = value;
	}

	/**
	 * Gets the value of the nidType property.
	 * 
	 */
	public int getNIDType() {
		return nidType;
	}

	/**
	 * Sets the value of the nidType property.
	 * 
	 */
	public void setNIDType(int value) {
		this.nidType = value;
	}

	/**
	 * Gets the value of the neWalletNum property.
	 * 
	 */
	public int getNEWalletNum() {
		return neWalletNum;
	}

	/**
	 * Sets the value of the neWalletNum property.
	 * 
	 */
	public void setNEWalletNum(int value) {
		this.neWalletNum = value;
	}

}
