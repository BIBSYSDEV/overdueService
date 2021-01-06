//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.3.0 
// See <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2021.01.06 at 08:56:49 PM CET 
//


package no.unit.alma.generated.partners;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * ISO 18626 related details. Relevant and mandatory only if profile_type = ISO_18626.
 * 
 * <p>Java class for iso_18626_details complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="iso_18626_details"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;all&gt;
 *         &lt;element name="alternative_document_delivery" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/&gt;
 *         &lt;element name="ill_server" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="iso_symbol" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="send_requester_information" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/&gt;
 *         &lt;element name="shared_barcodes" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/&gt;
 *         &lt;element name="return_info" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/&gt;
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
@XmlType(name = "iso_18626_details", propOrder = {

})
public class Iso18626Details {

    @XmlElement(name = "alternative_document_delivery", defaultValue = "false")
    protected Boolean alternativeDocumentDelivery;
    @XmlElement(name = "ill_server", required = true)
    protected String illServer;
    @XmlElement(name = "iso_symbol", required = true)
    protected String isoSymbol;
    @XmlElement(name = "send_requester_information", defaultValue = "false")
    protected Boolean sendRequesterInformation;
    @XmlElement(name = "shared_barcodes", defaultValue = "false")
    protected Boolean sharedBarcodes;
    @XmlElement(name = "return_info", defaultValue = "false")
    protected Boolean returnInfo;
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
     * Gets the value of the returnInfo property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isReturnInfo() {
        return returnInfo;
    }

    /**
     * Sets the value of the returnInfo property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setReturnInfo(Boolean value) {
        this.returnInfo = value;
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
