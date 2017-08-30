package com.bhyf.common.wsclient.onecard;

import java.util.HashMap;
import java.util.Map;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAnyAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.namespace.QName;

/**
 * <p>
 * Java class for SecurityHeader complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name="SecurityHeader">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
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
@XmlType(name = "SecurityHeader", propOrder = { "thirdType", "secret1",
		"secret2" })
public class SecurityHeader {

	@XmlElement(name = "ThirdType")
	protected int thirdType;
	@XmlElement(name = "Secret1")
	protected int secret1;
	@XmlElement(name = "Secret2")
	protected String secret2;
	@XmlAnyAttribute
	private Map<QName, String> otherAttributes = new HashMap<QName, String>();

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

	/**
	 * Gets a map that contains attributes that aren't bound to any typed
	 * property on this class.
	 * 
	 * <p>
	 * the map is keyed by the name of the attribute and the value is the string
	 * value of the attribute.
	 * 
	 * the map returned by this method is live, and you can add new attribute by
	 * updating the map directly. Because of this design, there's no setter.
	 * 
	 * 
	 * @return always non-null
	 */
	public Map<QName, String> getOtherAttributes() {
		return otherAttributes;
	}

}
