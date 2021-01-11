//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.3.0 
// See <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2021.01.11 at 08:11:21 AM CET 
//


package no.unit.alma.generated.partners;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * ISO related details. Relevant and mandatory only if profile_type = ISO.
 * 
 * <p>Java class for iso_details complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="iso_details"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;all&gt;
 *         &lt;element name="alternative_document_delivery" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/&gt;
 *         &lt;element name="ill_server" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="ill_port" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="iso_symbol" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="request_expiry_type" type="{}request_expiry_type"/&gt;
 *         &lt;element name="expiry_time" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&gt;
 *         &lt;element name="send_requester_information" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/&gt;
 *         &lt;element name="shared_barcodes" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/&gt;
 *         &lt;element name="ignore_shipping_cost_override" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/&gt;
 *         &lt;element name="email_address" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="resending_overdue_message_interval" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&gt;
 *       &lt;/all&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "iso_details", propOrder = {

})
public class IsoDetails {

    @XmlElement(name = "alternative_document_delivery", defaultValue = "false")
    protected Boolean alternativeDocumentDelivery;
    @XmlElement(name = "ill_server", required = true)
    protected String illServer;
    @XmlElement(name = "ill_port")
    protected int illPort;
    @XmlElement(name = "iso_symbol", required = true)
    protected String isoSymbol;
    @XmlElement(name = "request_expiry_type", required = true)
    protected RequestExpiryType requestExpiryType;
    @XmlElement(name = "expiry_time")
    protected Integer expiryTime;
    @XmlElement(name = "send_requester_information", defaultValue = "false")
    protected Boolean sendRequesterInformation;
    @XmlElement(name = "shared_barcodes", defaultValue = "false")
    protected Boolean sharedBarcodes;
    @XmlElement(name = "ignore_shipping_cost_override", defaultValue = "false")
    protected Boolean ignoreShippingCostOverride;
    @XmlElement(name = "email_address", required = true)
    protected String emailAddress;
    @XmlElement(name = "resending_overdue_message_interval", defaultValue = "0")
    protected Integer resendingOverdueMessageInterval;

    /**
     * Gets the value of the alternativeDocumentDelivery property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isAlternativeDocumentDelivery() {
        return alternativeDocumentDelivery;
    }

    /**
     * Sets the value of the alternativeDocumentDelivery property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setAlternativeDocumentDelivery(Boolean value) {
        this.alternativeDocumentDelivery = value;
    }

    /**
     * Gets the value of the illServer property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIllServer() {
        return illServer;
    }

    /**
     * Sets the value of the illServer property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIllServer(String value) {
        this.illServer = value;
    }

    /**
     * Gets the value of the illPort property.
     * 
     */
    public int getIllPort() {
        return illPort;
    }

    /**
     * Sets the value of the illPort property.
     * 
     */
    public void setIllPort(int value) {
        this.illPort = value;
    }

    /**
     * Gets the value of the isoSymbol property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIsoSymbol() {
        return isoSymbol;
    }

    /**
     * Sets the value of the isoSymbol property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIsoSymbol(String value) {
        this.isoSymbol = value;
    }

    /**
     * Gets the value of the requestExpiryType property.
     * 
     * @return
     *     possible object is
     *     {@link RequestExpiryType }
     *     
     */
    public RequestExpiryType getRequestExpiryType() {
        return requestExpiryType;
    }

    /**
     * Sets the value of the requestExpiryType property.
     * 
     * @param value
     *     allowed object is
     *     {@link RequestExpiryType }
     *     
     */
    public void setRequestExpiryType(RequestExpiryType value) {
        this.requestExpiryType = value;
    }

    /**
     * Gets the value of the expiryTime property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getExpiryTime() {
        return expiryTime;
    }

    /**
     * Sets the value of the expiryTime property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setExpiryTime(Integer value) {
        this.expiryTime = value;
    }

    /**
     * Gets the value of the sendRequesterInformation property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isSendRequesterInformation() {
        return sendRequesterInformation;
    }

    /**
     * Sets the value of the sendRequesterInformation property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setSendRequesterInformation(Boolean value) {
        this.sendRequesterInformation = value;
    }

    /**
     * Gets the value of the sharedBarcodes property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isSharedBarcodes() {
        return sharedBarcodes;
    }

    /**
     * Sets the value of the sharedBarcodes property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setSharedBarcodes(Boolean value) {
        this.sharedBarcodes = value;
    }

    /**
     * Gets the value of the ignoreShippingCostOverride property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isIgnoreShippingCostOverride() {
        return ignoreShippingCostOverride;
    }

    /**
     * Sets the value of the ignoreShippingCostOverride property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setIgnoreShippingCostOverride(Boolean value) {
        this.ignoreShippingCostOverride = value;
    }

    /**
     * Gets the value of the emailAddress property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEmailAddress() {
        return emailAddress;
    }

    /**
     * Sets the value of the emailAddress property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEmailAddress(String value) {
        this.emailAddress = value;
    }

    /**
     * Gets the value of the resendingOverdueMessageInterval property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getResendingOverdueMessageInterval() {
        return resendingOverdueMessageInterval;
    }

    /**
     * Sets the value of the resendingOverdueMessageInterval property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setResendingOverdueMessageInterval(Integer value) {
        this.resendingOverdueMessageInterval = value;
    }

}
