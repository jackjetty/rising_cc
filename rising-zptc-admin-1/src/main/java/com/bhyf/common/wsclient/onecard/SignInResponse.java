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
 *         &lt;element name="SignInResult" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="stanum" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="ThirdType" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="Secret1" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="Secret2" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = { "signInResult", "stanum", "thirdType",
		"secret1", "secret2" })
@XmlRootElement(name = "SignInResponse")
public class SignInResponse {

	@XmlElement(name = "SignInResult")
	protected String signInResult;
	protected int stanum;
	@XmlElement(name = "ThirdType")
	protected int thirdType;
	@XmlElement(name = "Secret1")
	protected int secret1;
	@XmlElement(name = "Secret2")
	protected String secret2;

	/**
	 * Gets the value of the signInResult property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getSignInResult() {
		return signInResult;
	}

	/**
	 * Sets the value of the signInResult property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setSignInResult(String value) {
		this.signInResult = value;
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
	 * Gets the value of the thirdType property.
	 * 
	 */
	public int getThirdType() {
		return thirdType;
	}

	/**
	 * Sets the value of the thirdType property.
	 * 
	 */
	public void setThirdType(int value) {
		this.thirdType = value;
	}

	/**
	 * Gets the value of the secret1 property.
	 * 
	 */
	public int getSecret1() {
		return secret1;
	}

	/**
	 * Sets the value of the secret1 property.
	 * 
	 */
	public void setSecret1(int value) {
		this.secret1 = value;
	}

	/**
	 * Gets the value of the secret2 property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getSecret2() {
		return secret2;
	}

	/**
	 * Sets the value of the secret2 property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setSecret2(String value) {
		this.secret2 = value;
	}

}
