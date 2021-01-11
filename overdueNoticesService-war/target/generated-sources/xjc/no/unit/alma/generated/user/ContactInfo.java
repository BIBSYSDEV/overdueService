//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.3.0 
// See <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2021.01.11 at 08:11:18 AM CET 
//


package no.unit.alma.generated.user;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * List of the user's contacts information.
 * 				SIS: In case of new user, these segments will be marked as "external".
 * 				In case of synchronization, this list will replace the existing external contacts. Internal contacts will be kept.
 * 				POST action: The segments will be created as external or as internal according to the "segment_type" attribute.
 * 				PUT action: Incoming internal segments (based on the "segment_type" attribute) will replace the existing internal segments.
 * 				Incoming external segments (based on the "segment_type" attribute) will replace the existing external segments.
 * 				If the incoming list is empty, existing segments will be deleted.
 * 		
 * 
 * <p>Java class for contact_info complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="contact_info"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="addresses" type="{}addresses" minOccurs="0"/&gt;
 *         &lt;element name="emails" type="{}emails" minOccurs="0"/&gt;
 *         &lt;element name="phones" type="{}phones" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "contact_info", propOrder = {
    "addresses",
    "emails",
    "phones"
})
public class ContactInfo {

    protected Addresses addresses;
    protected Emails emails;
    protected Phones phones;

    /**
     * Gets the value of the addresses property.
     * 
     * @return
     *     possible object is
     *     {@link Addresses }
     *     
     */
    public Addresses getAddresses() {
        return addresses;
    }

    /**
     * Sets the value of the addresses property.
     * 
     * @param value
     *     allowed object is
     *     {@link Addresses }
     *     
     */
    public void setAddresses(Addresses value) {
        this.addresses = value;
    }

    /**
     * Gets the value of the emails property.
     * 
     * @return
     *     possible object is
     *     {@link Emails }
     *     
     */
    public Emails getEmails() {
        return emails;
    }

    /**
     * Sets the value of the emails property.
     * 
     * @param value
     *     allowed object is
     *     {@link Emails }
     *     
     */
    public void setEmails(Emails value) {
        this.emails = value;
    }

    /**
     * Gets the value of the phones property.
     * 
     * @return
     *     possible object is
     *     {@link Phones }
     *     
     */
    public Phones getPhones() {
        return phones;
    }

    /**
     * Sets the value of the phones property.
     * 
     * @param value
     *     allowed object is
     *     {@link Phones }
     *     
     */
    public void setPhones(Phones value) {
        this.phones = value;
    }

}
