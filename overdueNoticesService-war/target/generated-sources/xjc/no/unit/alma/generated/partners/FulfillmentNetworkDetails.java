//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.3.0 
// See <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2021.01.08 at 08:07:06 AM CET 
//


package no.unit.alma.generated.partners;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * FULFILLMENT_NETWORK related details. Relevant and mandatory only if profile_type = FULFILLMENT_NETWORK.
 * 
 * <p>Java class for fulfillment_network_details complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="fulfillment_network_details"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;all&gt;
 *         &lt;element name="fulfillment_network_customer_code" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="fulfillment_network_url" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="request_expiry_type" type="{}request_expiry_type"/&gt;
 *         &lt;element name="expiry_time" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&gt;
 *       &lt;/all&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "fulfillment_network_details", propOrder = {

})
public class FulfillmentNetworkDetails {

    @XmlElement(name = "fulfillment_network_customer_code", required = true)
    protected String fulfillmentNetworkCustomerCode;
    @XmlElement(name = "fulfillment_network_url", required = true)
    protected String fulfillmentNetworkUrl;
    @XmlElement(name = "request_expiry_type", required = true)
    protected RequestExpiryType requestExpiryType;
    @XmlElement(name = "expiry_time")
    protected Integer expiryTime;

    /**
     * Gets the value of the fulfillmentNetworkCustomerCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFulfillmentNetworkCustomerCode() {
        return fulfillmentNetworkCustomerCode;
    }

    /**
     * Sets the value of the fulfillmentNetworkCustomerCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFulfillmentNetworkCustomerCode(String value) {
        this.fulfillmentNetworkCustomerCode = value;
    }

    /**
     * Gets the value of the fulfillmentNetworkUrl property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFulfillmentNetworkUrl() {
        return fulfillmentNetworkUrl;
    }

    /**
     * Sets the value of the fulfillmentNetworkUrl property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFulfillmentNetworkUrl(String value) {
        this.fulfillmentNetworkUrl = value;
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

}
