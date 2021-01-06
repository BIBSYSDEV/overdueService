//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.3.0 
// See <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2021.01.06 at 08:55:41 PM CET 
//


package no.unit.alma.generated.partners;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * ARTEmail related details. Relevant and mandatory only if profile_type = ART_EMAIL.
 * 
 * <p>Java class for art_email_details complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="art_email_details"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;all&gt;
 *         &lt;element name="email_address" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="alternative_document_delivery" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
 *         &lt;element name="customer_ids" type="{}customer_ids"/&gt;
 *         &lt;element name="keywords_service" type="{}keywords_service" minOccurs="0"/&gt;
 *         &lt;element name="keywords_delivery" type="{}keywords_delivery" minOccurs="0"/&gt;
 *         &lt;element name="keywords_queries" type="{}keywords_queries" minOccurs="0"/&gt;
 *       &lt;/all&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "art_email_details", propOrder = {

})
public class ArtEmailDetails {

    @XmlElement(name = "email_address", required = true)
    protected String emailAddress;
    @XmlElement(name = "alternative_document_delivery")
    protected boolean alternativeDocumentDelivery;
    @XmlElement(name = "customer_ids", required = true)
    protected CustomerIds customerIds;
    @XmlElement(name = "keywords_service")
    protected KeywordsService keywordsService;
    @XmlElement(name = "keywords_delivery")
    protected KeywordsDelivery keywordsDelivery;
    @XmlElement(name = "keywords_queries")
    protected KeywordsQueries keywordsQueries;

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
     * Gets the value of the alternativeDocumentDelivery property.
     * 
     */
    public boolean isAlternativeDocumentDelivery() {
        return alternativeDocumentDelivery;
    }

    /**
     * Sets the value of the alternativeDocumentDelivery property.
     * 
     */
    public void setAlternativeDocumentDelivery(boolean value) {
        this.alternativeDocumentDelivery = value;
    }

    /**
     * Gets the value of the customerIds property.
     * 
     * @return
     *     possible object is
     *     {@link CustomerIds }
     *     
     */
    public CustomerIds getCustomerIds() {
        return customerIds;
    }

    /**
     * Sets the value of the customerIds property.
     * 
     * @param value
     *     allowed object is
     *     {@link CustomerIds }
     *     
     */
    public void setCustomerIds(CustomerIds value) {
        this.customerIds = value;
    }

    /**
     * Gets the value of the keywordsService property.
     * 
     * @return
     *     possible object is
     *     {@link KeywordsService }
     *     
     */
    public KeywordsService getKeywordsService() {
        return keywordsService;
    }

    /**
     * Sets the value of the keywordsService property.
     * 
     * @param value
     *     allowed object is
     *     {@link KeywordsService }
     *     
     */
    public void setKeywordsService(KeywordsService value) {
        this.keywordsService = value;
    }

    /**
     * Gets the value of the keywordsDelivery property.
     * 
     * @return
     *     possible object is
     *     {@link KeywordsDelivery }
     *     
     */
    public KeywordsDelivery getKeywordsDelivery() {
        return keywordsDelivery;
    }

    /**
     * Sets the value of the keywordsDelivery property.
     * 
     * @param value
     *     allowed object is
     *     {@link KeywordsDelivery }
     *     
     */
    public void setKeywordsDelivery(KeywordsDelivery value) {
        this.keywordsDelivery = value;
    }

    /**
     * Gets the value of the keywordsQueries property.
     * 
     * @return
     *     possible object is
     *     {@link KeywordsQueries }
     *     
     */
    public KeywordsQueries getKeywordsQueries() {
        return keywordsQueries;
    }

    /**
     * Sets the value of the keywordsQueries property.
     * 
     * @param value
     *     allowed object is
     *     {@link KeywordsQueries }
     *     
     */
    public void setKeywordsQueries(KeywordsQueries value) {
        this.keywordsQueries = value;
    }

}
