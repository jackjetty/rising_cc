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
 *         &lt;element name="operatorNum" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="stanum" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="sIDNo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="nIDType" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="oldPassword" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="newPassword" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = { "operatorNum", "stanum", "sidNo", "nidType",
		"oldPassword", "newPassword" })
@XmlRootElement(name = "ChangeQueryPassword")
public class ChangeQueryPassword {

	protected int operatorNum;
	protected int stanum;
	@XmlElement(name = "sIDNo")
	protected String sidNo;
	@XmlElement(name = "nIDType")
	protected int nidType;
	protected String oldPassword;
	protected String newPassword;

	/**
	 * Gets the value of the operatorNum property.
	 * 
	 */
	public int getOperatorNum() {
		return operatorNum;
	}

	/**
	 * Sets the value of the operatorNum property.
	 * 
	 */
	public void setOperatorNum(int value) {
		this.operatorNum = value;
	}

	/**
	 * Gets the value of the stanum property.
	 * 
	 */
	public int getStanum() {
		return stanum;
	}

	/**
	 * Sets the value of the stanum property.
	 * 
	 */
	public void setStanum(int value) {
		this.stanum = value;
	}

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
	 * Gets the value of the oldPassword property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getOldPassword() {
		return oldPassword;
	}

	/**
	 * Sets the value of the oldPassword property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setOldPassword(String value) {
		this.oldPassword = value;
	}

	/**
	 * Gets the value of the newPassword property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getNewPassword() {
		return newPassword;
	}

	/**
	 * Sets the value of the newPassword property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setNewPassword(String value) {
		this.newPassword = value;
	}

}
