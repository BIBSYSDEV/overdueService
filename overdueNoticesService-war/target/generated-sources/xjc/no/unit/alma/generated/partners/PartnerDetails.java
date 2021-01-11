//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.3.0 
// See <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2021.01.11 at 08:11:21 AM CET 
//


package no.unit.alma.generated.partners;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlValue;


/**
 * The partner's general details.
 * 
 * <p>Java class for partner_details complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="partner_details"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;all&gt;
 *         &lt;element name="code" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="name" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="profile_details" type="{}profile_details"/&gt;
 *         &lt;element name="status" type="{}status"/&gt;
 *         &lt;element name="system_type"&gt;
 *           &lt;complexType&gt;
 *             &lt;simpleContent&gt;
 *               &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema&gt;string"&gt;
 *                 &lt;attribute name="desc" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *               &lt;/extension&gt;
 *             &lt;/simpleContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="avg_supply_time" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&gt;
 *         &lt;element name="delivery_delay" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&gt;
 *         &lt;element name="currency" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="borrowing_supported" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
 *         &lt;element name="borrowing_workflow" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="lending_supported" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
 *         &lt;element name="lending_workflow" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="auto_cancel_supported" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/&gt;
 *         &lt;element name="auto_cancel_reason" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="auto_cancel_time" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&gt;
 *         &lt;element name="auto_claim_supported" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/&gt;
 *         &lt;element name="auto_claim_time" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&gt;
 *         &lt;element name="locate_profile" minOccurs="0"&gt;
 *           &lt;complexType&gt;
 *             &lt;simpleContent&gt;
 *               &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema&gt;string"&gt;
 *                 &lt;attribute name="desc" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *               &lt;/extension&gt;
 *             &lt;/simpleContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="institution_code" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="holding_code" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/all&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "partner_details", propOrder = {

})
public class PartnerDetails {

    @XmlElement(required = true)
    protected String code;
    @XmlElement(required = true)
    protected String name;
    @XmlElement(name = "profile_details", required = true)
    protected ProfileDetails profileDetails;
    @XmlElement(required = true)
    @XmlSchemaType(name = "string")
    protected Status status;
    @XmlElement(name = "system_type", required = true)
    protected PartnerDetails.SystemType systemType;
    @XmlElement(name = "avg_supply_time", defaultValue = "0")
    protected Integer avgSupplyTime;
    @XmlElement(name = "delivery_delay", defaultValue = "0")
    protected Integer deliveryDelay;
    protected String currency;
    @XmlElement(name = "borrowing_supported")
    protected boolean borrowingSupported;
    @XmlElement(name = "borrowing_workflow", defaultValue = "DEFAULT_BOR_WF")
    protected String borrowingWorkflow;
    @XmlElement(name = "lending_supported")
    protected boolean lendingSupported;
    @XmlElement(name = "lending_workflow", defaultValue = "DEFAULT_LEND_WF")
    protected String lendingWorkflow;
    @XmlElement(name = "auto_cancel_supported")
    protected Boolean autoCancelSupported;
    @XmlElement(name = "auto_cancel_reason")
    protected String autoCancelReason;
    @XmlElement(name = "auto_cancel_time")
    protected Integer autoCancelTime;
    @XmlElement(name = "auto_claim_supported")
    protected Boolean autoClaimSupported;
    @XmlElement(name = "auto_claim_time")
    protected Integer autoClaimTime;
    @XmlElement(name = "locate_profile")
    protected PartnerDetails.LocateProfile locateProfile;
    @XmlElement(name = "institution_code")
    protected String institutionCode;
    @XmlElement(name = "holding_code")
    protected String holdingCode;

    /**
     * Gets the value of the code property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCode() {
        return code;
    }

    /**
     * Sets the value of the code property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCode(String value) {
        this.code = value;
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
     * Gets the value of the profileDetails property.
     * 
     * @return
     *     possible object is
     *     {@link ProfileDetails }
     *     
     */
    public ProfileDetails getProfileDetails() {
        return profileDetails;
    }

    /**
     * Sets the value of the profileDetails property.
     * 
     * @param value
     *     allowed object is
     *     {@link ProfileDetails }
     *     
     */
    public void setProfileDetails(ProfileDetails value) {
        this.profileDetails = value;
    }

    /**
     * Gets the value of the status property.
     * 
     * @return
     *     possible object is
     *     {@link Status }
     *     
     */
    public Status getStatus() {
        return status;
    }

    /**
     * Sets the value of the status property.
     * 
     * @param value
     *     allowed object is
     *     {@link Status }
     *     
     */
    public void setStatus(Status value) {
        this.status = value;
    }

    /**
     * Gets the value of the systemType property.
     * 
     * @return
     *     possible object is
     *     {@link PartnerDetails.SystemType }
     *     
     */
    public PartnerDetails.SystemType getSystemType() {
        return systemType;
    }

    /**
     * Sets the value of the systemType property.
     * 
     * @param value
     *     allowed object is
     *     {@link PartnerDetails.SystemType }
     *     
     */
    public void setSystemType(PartnerDetails.SystemType value) {
        this.systemType = value;
    }

    /**
     * Gets the value of the avgSupplyTime property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getAvgSupplyTime() {
        return avgSupplyTime;
    }

    /**
     * Sets the value of the avgSupplyTime property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setAvgSupplyTime(Integer value) {
        this.avgSupplyTime = value;
    }

    /**
     * Gets the value of the deliveryDelay property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getDeliveryDelay() {
        return deliveryDelay;
    }

    /**
     * Sets the value of the deliveryDelay property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setDeliveryDelay(Integer value) {
        this.deliveryDelay = value;
    }

    /**
     * Gets the value of the currency property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCurrency() {
        return currency;
    }

    /**
     * Sets the value of the currency property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCurrency(String value) {
        this.currency = value;
    }

    /**
     * Gets the value of the borrowingSupported property.
     * 
     */
    public boolean isBorrowingSupported() {
        return borrowingSupported;
    }

    /**
     * Sets the value of the borrowingSupported property.
     * 
     */
    public void setBorrowingSupported(boolean value) {
        this.borrowingSupported = value;
    }

    /**
     * Gets the value of the borrowingWorkflow property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBorrowingWorkflow() {
        return borrowingWorkflow;
    }

    /**
     * Sets the value of the borrowingWorkflow property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBorrowingWorkflow(String value) {
        this.borrowingWorkflow = value;
    }

    /**
     * Gets the value of the lendingSupported property.
     * 
     */
    public boolean isLendingSupported() {
        return lendingSupported;
    }

    /**
     * Sets the value of the lendingSupported property.
     * 
     */
    public void setLendingSupported(boolean value) {
        this.lendingSupported = value;
    }

    /**
     * Gets the value of the lendingWorkflow property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLendingWorkflow() {
        return lendingWorkflow;
    }

    /**
     * Sets the value of the lendingWorkflow property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLendingWorkflow(String value) {
        this.lendingWorkflow = value;
    }

    /**
     * Gets the value of the autoCancelSupported property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isAutoCancelSupported() {
        return autoCancelSupported;
    }

    /**
     * Sets the value of the autoCancelSupported property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setAutoCancelSupported(Boolean value) {
        this.autoCancelSupported = value;
    }

    /**
     * Gets the value of the autoCancelReason property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAutoCancelReason() {
        return autoCancelReason;
    }

    /**
     * Sets the value of the autoCancelReason property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAutoCancelReason(String value) {
        this.autoCancelReason = value;
    }

    /**
     * Gets the value of the autoCancelTime property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getAutoCancelTime() {
        return autoCancelTime;
    }

    /**
     * Sets the value of the autoCancelTime property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setAutoCancelTime(Integer value) {
        this.autoCancelTime = value;
    }

    /**
     * Gets the value of the autoClaimSupported property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isAutoClaimSupported() {
        return autoClaimSupported;
    }

    /**
     * Sets the value of the autoClaimSupported property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setAutoClaimSupported(Boolean value) {
        this.autoClaimSupported = value;
    }

    /**
     * Gets the value of the autoClaimTime property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getAutoClaimTime() {
        return autoClaimTime;
    }

    /**
     * Sets the value of the autoClaimTime property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setAutoClaimTime(Integer value) {
        this.autoClaimTime = value;
    }

    /**
     * Gets the value of the locateProfile property.
     * 
     * @return
     *     possible object is
     *     {@link PartnerDetails.LocateProfile }
     *     
     */
    public PartnerDetails.LocateProfile getLocateProfile() {
        return locateProfile;
    }

    /**
     * Sets the value of the locateProfile property.
     * 
     * @param value
     *     allowed object is
     *     {@link PartnerDetails.LocateProfile }
     *     
     */
    public void setLocateProfile(PartnerDetails.LocateProfile value) {
        this.locateProfile = value;
    }

    /**
     * Gets the value of the institutionCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getInstitutionCode() {
        return institutionCode;
    }

    /**
     * Sets the value of the institutionCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setInstitutionCode(String value) {
        this.institutionCode = value;
    }

    /**
     * Gets the value of the holdingCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getHoldingCode() {
        return holdingCode;
    }

    /**
     * Sets the value of the holdingCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setHoldingCode(String value) {
        this.holdingCode = value;
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
    public static class LocateProfile {

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
    public static class SystemType {

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
