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
 *         &lt;element name="nParaNum" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="sParamTypeThirdID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="sThirdID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="sParamContent" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = { "nParaNum", "sParamTypeThirdID", "sThirdID",
		"sParamContent" })
@XmlRootElement(name = "UpdateParamCode")
public class UpdateParamCode {

	protected int nParaNum;
	protected String sParamTypeThirdID;
	protected String sThirdID;
	protected String sParamContent;

	/**
	 * Gets the value of the nParaNum property.
	 * 
	 */
	public int getNParaNum() {
		return nParaNum;
	}

	/**
	 * Sets the value of the nParaNum property.
	 * 
	 */
	public void setNParaNum(int value) {
		this.nParaNum = value;
	}

	/**
	 * Gets the value of the sParamTypeThirdID property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getSParamTypeThirdID() {
		return sParamTypeThirdID;
	}

	/**
	 * Sets the value of the sParamTypeThirdID property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setSParamTypeThirdID(String value) {
		this.sParamTypeThirdID = value;
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
	 * Gets the value of the sParamContent property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getSParamContent() {
		return sParamContent;
	}

	/**
	 * Sets the value of the sParamContent property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setSParamContent(String value) {
		this.sParamContent = value;
	}

}
