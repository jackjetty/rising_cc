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
 *         &lt;element name="nStaNum" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="nOptNum" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="nEWalletNum" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="nMonDeal" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="sDealTime" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = { "sidNo", "nidType", "nStaNum", "nOptNum",
		"neWalletNum", "nMonDeal", "sDealTime" })
@XmlRootElement(name = "DepositA")
public class DepositA {

	@XmlElement(name = "sIDNo")
	protected String sidNo;
	@XmlElement(name = "nIDType")
	protected int nidType;
	protected int nStaNum;
	protected int nOptNum;
	@XmlElement(name = "nEWalletNum")
	protected int neWalletNum;
	protected int nMonDeal;
	protected String sDealTime;

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
	 * Gets the value of the nStaNum property.
	 * 
	 */
	public int getNStaNum() {
		return nStaNum;
	}

	/**
	 * Sets the value of the nStaNum property.
	 * 
	 */
	public void setNStaNum(int value) {
		this.nStaNum = value;
	}

	/**
	 * Gets the value of the nOptNum property.
	 * 
	 */
	public int getNOptNum() {
		return nOptNum;
	}

	/**
	 * Sets the value of the nOptNum property.
	 * 
	 */
	public void setNOptNum(int value) {
		this.nOptNum = value;
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

	/**
	 * Gets the value of the nMonDeal property.
	 * 
	 */
	public int getNMonDeal() {
		return nMonDeal;
	}

	/**
	 * Sets the value of the nMonDeal property.
	 * 
	 */
	public void setNMonDeal(int value) {
		this.nMonDeal = value;
	}

	/**
	 * Gets the value of the sDealTime property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getSDealTime() {
		return sDealTime;
	}

	/**
	 * Sets the value of the sDealTime property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setSDealTime(String value) {
		this.sDealTime = value;
	}

}
