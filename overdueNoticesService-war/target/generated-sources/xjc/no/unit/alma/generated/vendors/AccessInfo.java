//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.3.0 
// See <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2021.01.06 at 08:56:46 PM CET 
//


package no.unit.alma.generated.vendors;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlValue;


/**
 * <p>Java class for access_info complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="access_info"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;all&gt;
 *         &lt;element name="user_id" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="user_password" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="user_pass_note" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="ip_address_reg_method" minOccurs="0"&gt;
 *           &lt;complexType&gt;
 *             &lt;simpleContent&gt;
 *               &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema&gt;string"&gt;
 *                 &lt;attribute name="desc" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *               &lt;/extension&gt;
 *             &lt;/simpleContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="ip_address_reg_instructions" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="ip_address_note" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="access_note" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="primary_access_uri" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="interface_uri" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="implemented_auth_method" minOccurs="0"&gt;
 *           &lt;complexType&gt;
 *             &lt;simpleContent&gt;
 *               &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema&gt;string"&gt;
 *                 &lt;attribute name="desc" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *               &lt;/extension&gt;
 *             &lt;/simpleContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="local_persistent_uri" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/all&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "access_info", propOrder = {

})
public class AccessInfo {

    @XmlElement(name = "user_id")
    protected String userId;
    @XmlElement(name = "user_password")
    protected String userPassword;
    @XmlElement(name = "user_pass_note")
    protected String userPassNote;
    @XmlElement(name = "ip_address_reg_method")
    protected AccessInfo.IpAddressRegMethod ipAddressRegMethod;
    @XmlElement(name = "ip_address_reg_instructions")
    protected String ipAddressRegInstructions;
    @XmlElement(name = "ip_address_note")
    protected String ipAddressNote;
    @XmlElement(name = "access_note")
    protected String accessNote;
    @XmlElement(name = "primary_access_uri")
    protected String primaryAccessUri;
    @XmlElement(name = "interface_uri")
    protected String interfaceUri;
    @XmlElement(name = "implemented_auth_method")
    protected AccessInfo.ImplementedAuthMethod implementedAuthMethod;
    @XmlElement(name = "local_persistent_uri")
    protected String localPersistentUri;

    /**
     * Gets the value of the userId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUserId() {
        return userId;
    }

    /**
     * Sets the value of the userId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUserId(String value) {
        this.userId = value;
    }

    /**
     * Gets the value of the userPassword property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUserPassword() {
        return userPassword;
    }

    /**
     * Sets the value of the userPassword property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUserPassword(String value) {
        this.userPassword = value;
    }

    /**
     * Gets the value of the userPassNote property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUserPassNote() {
        return userPassNote;
    }

    /**
     * Sets the value of the userPassNote property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUserPassNote(String value) {
        this.userPassNote = value;
    }

    /**
     * Gets the value of the ipAddressRegMethod property.
     * 
     * @return
     *     possible object is
     *     {@link AccessInfo.IpAddressRegMethod }
     *     
     */
    public AccessInfo.IpAddressRegMethod getIpAddressRegMethod() {
        return ipAddressRegMethod;
    }

    /**
     * Sets the value of the ipAddressRegMethod property.
     * 
     * @param value
     *     allowed object is
     *     {@link AccessInfo.IpAddressRegMethod }
     *     
     */
    public void setIpAddressRegMethod(AccessInfo.IpAddressRegMethod value) {
        this.ipAddressRegMethod = value;
    }

    /**
     * Gets the value of the ipAddressRegInstructions property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIpAddressRegInstructions() {
        return ipAddressRegInstructions;
    }

    /**
     * Sets the value of the ipAddressRegInstructions property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIpAddressRegInstructions(String value) {
        this.ipAddressRegInstructions = value;
    }

    /**
     * Gets the value of the ipAddressNote property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIpAddressNote() {
        return ipAddressNote;
    }

    /**
     * Sets the value of the ipAddressNote property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIpAddressNote(String value) {
        this.ipAddressNote = value;
    }

    /**
     * Gets the value of the accessNote property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAccessNote() {
        return accessNote;
    }

    /**
     * Sets the value of the accessNote property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAccessNote(String value) {
        this.accessNote = value;
    }

    /**
     * Gets the value of the primaryAccessUri property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPrimaryAccessUri() {
        return primaryAccessUri;
    }

    /**
     * Sets the value of the primaryAccessUri property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPrimaryAccessUri(String value) {
        this.primaryAccessUri = value;
    }

    /**
     * Gets the value of the interfaceUri property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getInterfaceUri() {
        return interfaceUri;
    }

    /**
     * Sets the value of the interfaceUri property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setInterfaceUri(String value) {
        this.interfaceUri = value;
    }

    /**
     * Gets the value of the implementedAuthMethod property.
     * 
     * @return
     *     possible object is
     *     {@link AccessInfo.ImplementedAuthMethod }
     *     
     */
    public AccessInfo.ImplementedAuthMethod getImplementedAuthMethod() {
        return implementedAuthMethod;
    }

    /**
     * Sets the value of the implementedAuthMethod property.
     * 
     * @param value
     *     allowed object is
     *     {@link AccessInfo.ImplementedAuthMethod }
     *     
     */
    public void setImplementedAuthMethod(AccessInfo.ImplementedAuthMethod value) {
        this.implementedAuthMethod = value;
    }

    /**
     * Gets the value of the localPersistentUri property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLocalPersistentUri() {
        return localPersistentUri;
    }

    /**
     * Sets the value of the localPersistentUri property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLocalPersistentUri(String value) {
        this.localPersistentUri = value;
    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType&gt;
     *   &lt;simpleContent&gt;
     *     &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema&gt;string"&gt;
     *       &lt;attribute name="desc" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
     *     &lt;/extension&gt;
     *   &lt;/simpleContent&gt;
     * &lt;/complexType&gt;
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "value"
    })
    public static class ImplementedAuthMethod {

        @XmlValue
        protected String value;
        @XmlAttribute(name = "desc")
        protected String desc;

        /**
         * Gets the value of the value property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getValue() {
            return value;
        }

        /**
         * Sets the value of the value property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setValue(String value) {
            this.value = value;
        }

        /**
         * Gets the value of the desc property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getDesc() {
            return desc;
        }

        /**
         * Sets the value of the desc property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setDesc(String value) {
            this.desc = value;
        }

    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType&gt;
     *   &lt;simpleContent&gt;
     *     &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema&gt;string"&gt;
     *       &lt;attribute name="desc" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
     *     &lt;/extension&gt;
     *   &lt;/simpleContent&gt;
     * &lt;/complexType&gt;
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "value"
    })
    public static class IpAddressRegMethod {

        @XmlValue
        protected String value;
        @XmlAttribute(name = "desc")
        protected String desc;

        /**
         * Gets the value of the value property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getValue() {
            return value;
        }

        /**
         * Sets the value of the value property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setValue(String value) {
            this.value = value;
        }

        /**
         * Gets the value of the desc property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getDesc() {
            return desc;
        }

        /**
         * Sets the value of the desc property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setDesc(String value) {
            this.desc = value;
        }

    }

}
