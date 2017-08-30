package com.bhyf.common.wsclient.onecard;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
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
 *         &lt;element name="nClsNum" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="sThirdID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="sClsName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = { "nClsNum", "sThirdID", "sClsName" })
@XmlRootElement(name = "UploadAccClass")
public class UploadAccClass {

	protected int nClsNum;
	protected String sThirdID;
	protected String sClsName;

	/**
	 * Gets the value of the nClsNum property.
	 * 
	 */
	public int getNClsNum() {
		return nClsNum;
	}

	/**
	 * Sets the value of the nClsNum property.
	 * 
	 */
	public void setNClsNum(int value) {
		this.nClsNum = value;
	}

	/**
	 * Gets the value of the sThirdID property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getSThirdID() {
		return sThirdID;
	}

	/**
	 * Sets the value of the sThirdID property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setSThirdID(String value) {
		this.sThirdID = value;
	}

	/**
	 * Gets the value of the sClsName property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getSClsName() {
		return sClsName;
	}

	/**
	 * Sets the value of the sClsName property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setSClsName(String value) {
		this.sClsName = value;
	}

}
