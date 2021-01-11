//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.3.0 
// See <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2021.01.11 at 07:59:16 AM CET 
//


package no.unit.alma.generated.partners;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlValue;


/**
 * BLDSS related details. Relevant and mandatory only if profile_type = BLDSS.
 * 
 * <p>Java class for bldss_details complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="bldss_details"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;all&gt;
 *         &lt;element name="bldss_base_url" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="bldss_base_account" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="bldss_base_password" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="bldss_digital_format"&gt;
 *           &lt;complexType&gt;
 *             &lt;simpleContent&gt;
 *               &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema&gt;string"&gt;
 *                 &lt;attribute name="desc" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *               &lt;/extension&gt;
 *             &lt;/simpleContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="bldss_send_requester_info" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
 *       &lt;/all&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "bldss_details", propOrder = {

})
public class BldssDetails {

    @XmlElement(name = "bldss_base_url", required = true)
    protected String bldssBaseUrl;
    @XmlElement(name = "bldss_base_account", required = true)
    protected String bldssBaseAccount;
    @XmlElement(name = "bldss_base_password", required = true)
    protected String bldssBasePassword;
    @XmlElement(name = "bldss_digital_format", required = true)
    protected BldssDetails.BldssDigitalFormat bldssDigitalFormat;
    @XmlElement(name = "bldss_send_requester_info", defaultValue = "false")
    protected boolean bldssSendRequesterInfo;

    /**
     * Gets the value of the bldssBaseUrl property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBldssBaseUrl() {
        return bldssBaseUrl;
    }

    /**
     * Sets the value of the bldssBaseUrl property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBldssBaseUrl(String value) {
        this.bldssBaseUrl = value;
    }

    /**
     * Gets the value of the bldssBaseAccount property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBldssBaseAccount() {
        return bldssBaseAccount;
    }

    /**
     * Sets the value of the bldssBaseAccount property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBldssBaseAccount(String value) {
        this.bldssBaseAccount = value;
    }

    /**
     * Gets the value of the bldssBasePassword property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBldssBasePassword() {
        return bldssBasePassword;
    }

    /**
     * Sets the value of the bldssBasePassword property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBldssBasePassword(String value) {
        this.bldssBasePassword = value;
    }

    /**
     * Gets the value of the bldssDigitalFormat property.
     * 
     * @return
     *     possible object is
     *     {@link BldssDetails.BldssDigitalFormat }
     *     
     */
    public BldssDetails.BldssDigitalFormat getBldssDigitalFormat() {
        return bldssDigitalFormat;
    }

    /**
     * Sets the value of the bldssDigitalFormat property.
     * 
     * @param value
     *     allowed object is
     *     {@link BldssDetails.BldssDigitalFormat }
     *     
     */
    public void setBldssDigitalFormat(BldssDetails.BldssDigitalFormat value) {
        this.bldssDigitalFormat = value;
    }

    /**
     * Gets the value of the bldssSendRequesterInfo property.
     * 
     */
    public boolean isBldssSendRequesterInfo() {
        return bldssSendRequesterInfo;
    }

    /**
     * Sets the value of the bldssSendRequesterInfo property.
     * 
     */
    public void setBldssSendRequesterInfo(boolean value) {
        this.bldssSendRequesterInfo = value;
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
    public static class BldssDigitalFormat {

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
