//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.3.0 
// See <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2021.01.08 at 08:07:01 AM CET 
//


package no.unit.alma.generated.vendors;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlValue;


/**
 * A specific vendor interface.
 * 
 * <p>Java class for interface complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="interface"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;all&gt;
 *         &lt;element name="interface_id" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="name" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="description" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="status" minOccurs="0"&gt;
 *           &lt;complexType&gt;
 *             &lt;simpleContent&gt;
 *               &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema&gt;string"&gt;
 *                 &lt;attribute name="desc" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *               &lt;/extension&gt;
 *             &lt;/simpleContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="main_note" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="contact_info" type="{}contact_info" minOccurs="0"/&gt;
 *         &lt;element name="admin_info" type="{}admin_info" minOccurs="0"/&gt;
 *         &lt;element name="statistics" type="{}statistics" minOccurs="0"/&gt;
 *         &lt;element name="access_info" type="{}access_info" minOccurs="0"/&gt;
 *         &lt;element name="interface_notes" type="{}notes" minOccurs="0"/&gt;
 *       &lt;/all&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "interface", propOrder = {

})
public class Interface {

    @XmlElement(name = "interface_id")
    protected String interfaceId;
    protected String name;
    protected String description;
    protected Interface.Status status;
    @XmlElement(name = "main_note")
    protected String mainNote;
    @XmlElement(name = "contact_info")
    protected ContactInfo contactInfo;
    @XmlElement(name = "admin_info")
    protected AdminInfo adminInfo;
    protected Statistics statistics;
    @XmlElement(name = "access_info")
    protected AccessInfo accessInfo;
    @XmlElement(name = "interface_notes")
    protected Notes interfaceNotes;

    /**
     * Gets the value of the interfaceId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getInterfaceId() {
        return interfaceId;
    }

    /**
     * Sets the value of the interfaceId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setInterfaceId(String value) {
        this.interfaceId = value;
    }

    /**
     * Gets the value of the name property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the value of the name property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setName(String value) {
        this.name = value;
    }

    /**
     * Gets the value of the description property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets the value of the description property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescription(String value) {
        this.description = value;
    }

    /**
     * Gets the value of the status property.
     * 
     * @return
     *     possible object is
     *     {@link Interface.Status }
     *     
     */
    public Interface.Status getStatus() {
        return status;
    }

    /**
     * Sets the value of the status property.
     * 
     * @param value
     *     allowed object is
     *     {@link Interface.Status }
     *     
     */
    public void setStatus(Interface.Status value) {
        this.status = value;
    }

    /**
     * Gets the value of the mainNote property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMainNote() {
        return mainNote;
    }

    /**
     * Sets the value of the mainNote property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMainNote(String value) {
        this.mainNote = value;
    }

    /**
     * Gets the value of the contactInfo property.
     * 
     * @return
     *     possible object is
     *     {@link ContactInfo }
     *     
     */
    public ContactInfo getContactInfo() {
        return contactInfo;
    }

    /**
     * Sets the value of the contactInfo property.
     * 
     * @param value
     *     allowed object is
     *     {@link ContactInfo }
     *     
     */
    public void setContactInfo(ContactInfo value) {
        this.contactInfo = value;
    }

    /**
     * Gets the value of the adminInfo property.
     * 
     * @return
     *     possible object is
     *     {@link AdminInfo }
     *     
     */
    public AdminInfo getAdminInfo() {
        return adminInfo;
    }

    /**
     * Sets the value of the adminInfo property.
     * 
     * @param value
     *     allowed object is
     *     {@link AdminInfo }
     *     
     */
    public void setAdminInfo(AdminInfo value) {
        this.adminInfo = value;
    }

    /**
     * Gets the value of the statistics property.
     * 
     * @return
     *     possible object is
     *     {@link Statistics }
     *     
     */
    public Statistics getStatistics() {
        return statistics;
    }

    /**
     * Sets the value of the statistics property.
     * 
     * @param value
     *     allowed object is
     *     {@link Statistics }
     *     
     */
    public void setStatistics(Statistics value) {
        this.statistics = value;
    }

    /**
     * Gets the value of the accessInfo property.
     * 
     * @return
     *     possible object is
     *     {@link AccessInfo }
     *     
     */
    public AccessInfo getAccessInfo() {
        return accessInfo;
    }

    /**
     * Sets the value of the accessInfo property.
     * 
     * @param value
     *     allowed object is
     *     {@link AccessInfo }
     *     
     */
    public void setAccessInfo(AccessInfo value) {
        this.accessInfo = value;
    }

    /**
     * Gets the value of the interfaceNotes property.
     * 
     * @return
     *     possible object is
     *     {@link Notes }
     *     
     */
    public Notes getInterfaceNotes() {
        return interfaceNotes;
    }

    /**
     * Sets the value of the interfaceNotes property.
     * 
     * @param value
     *     allowed object is
     *     {@link Notes }
     *     
     */
    public void setInterfaceNotes(Notes value) {
        this.interfaceNotes = value;
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
    public static class Status {

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
