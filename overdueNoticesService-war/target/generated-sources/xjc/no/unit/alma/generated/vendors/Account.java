//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.3.0 
// See <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2021.01.11 at 08:11:16 AM CET 
//


package no.unit.alma.generated.vendors;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlValue;


/**
 * A specific vendor account.
 * 
 * <p>Java class for account complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="account"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;all&gt;
 *         &lt;element name="account_id" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="code" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="description" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="financial_sys_code" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="status" minOccurs="0"&gt;
 *           &lt;complexType&gt;
 *             &lt;simpleContent&gt;
 *               &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema&gt;string"&gt;
 *                 &lt;attribute name="desc" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *               &lt;/extension&gt;
 *             &lt;/simpleContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="account_libraries" type="{}libraries" minOccurs="0"/&gt;
 *         &lt;element name="discount_percent" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="note" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="payment_methods" type="{}payment_methods"/&gt;
 *         &lt;element name="expected_receipt_interval" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="claiming_interval" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="expected_invoice_interval" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="expected_activation_interval" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="renewal_evaluation_interval" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="subscription_interval" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="reclaim_interval" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="contact_info" type="{}contact_info" minOccurs="0"/&gt;
 *       &lt;/all&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "account", propOrder = {

})
public class Account {

    @XmlElement(name = "account_id")
    protected String accountId;
    @XmlElement(required = true)
    protected String code;
    @XmlElement(required = true)
    protected String description;
    @XmlElement(name = "financial_sys_code")
    protected String financialSysCode;
    protected Account.Status status;
    @XmlElement(name = "account_libraries")
    protected Libraries accountLibraries;
    @XmlElement(name = "discount_percent")
    protected String discountPercent;
    protected String note;
    @XmlElement(name = "payment_methods", required = true)
    protected PaymentMethods paymentMethods;
    @XmlElement(name = "expected_receipt_interval")
    protected String expectedReceiptInterval;
    @XmlElement(name = "claiming_interval")
    protected String claimingInterval;
    @XmlElement(name = "expected_invoice_interval")
    protected String expectedInvoiceInterval;
    @XmlElement(name = "expected_activation_interval")
    protected String expectedActivationInterval;
    @XmlElement(name = "renewal_evaluation_interval")
    protected String renewalEvaluationInterval;
    @XmlElement(name = "subscription_interval")
    protected String subscriptionInterval;
    @XmlElement(name = "reclaim_interval", required = true)
    protected String reclaimInterval;
    @XmlElement(name = "contact_info")
    protected ContactInfo contactInfo;

    /**
     * Gets the value of the accountId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAccountId() {
        return accountId;
    }

    /**
     * Sets the value of the accountId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAccountId(String value) {
        this.accountId = value;
    }

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
     * Gets the value of the financialSysCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFinancialSysCode() {
        return financialSysCode;
    }

    /**
     * Sets the value of the financialSysCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFinancialSysCode(String value) {
        this.financialSysCode = value;
    }

    /**
     * Gets the value of the status property.
     * 
     * @return
     *     possible object is
     *     {@link Account.Status }
     *     
     */
    public Account.Status getStatus() {
        return status;
    }

    /**
     * Sets the value of the status property.
     * 
     * @param value
     *     allowed object is
     *     {@link Account.Status }
     *     
     */
    public void setStatus(Account.Status value) {
        this.status = value;
    }

    /**
     * Gets the value of the accountLibraries property.
     * 
     * @return
     *     possible object is
     *     {@link Libraries }
     *     
     */
    public Libraries getAccountLibraries() {
        return accountLibraries;
    }

    /**
     * Sets the value of the accountLibraries property.
     * 
     * @param value
     *     allowed object is
     *     {@link Libraries }
     *     
     */
    public void setAccountLibraries(Libraries value) {
        this.accountLibraries = value;
    }

    /**
     * Gets the value of the discountPercent property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDiscountPercent() {
        return discountPercent;
    }

    /**
     * Sets the value of the discountPercent property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDiscountPercent(String value) {
        this.discountPercent = value;
    }

    /**
     * Gets the value of the note property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNote() {
        return note;
    }

    /**
     * Sets the value of the note property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNote(String value) {
        this.note = value;
    }

    /**
     * Gets the value of the paymentMethods property.
     * 
     * @return
     *     possible object is
     *     {@link PaymentMethods }
     *     
     */
    public PaymentMethods getPaymentMethods() {
        return paymentMethods;
    }

    /**
     * Sets the value of the paymentMethods property.
     * 
     * @param value
     *     allowed object is
     *     {@link PaymentMethods }
     *     
     */
    public void setPaymentMethods(PaymentMethods value) {
        this.paymentMethods = value;
    }

    /**
     * Gets the value of the expectedReceiptInterval property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getExpectedReceiptInterval() {
        return expectedReceiptInterval;
    }

    /**
     * Sets the value of the expectedReceiptInterval property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setExpectedReceiptInterval(String value) {
        this.expectedReceiptInterval = value;
    }

    /**
     * Gets the value of the claimingInterval property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getClaimingInterval() {
        return claimingInterval;
    }

    /**
     * Sets the value of the claimingInterval property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setClaimingInterval(String value) {
        this.claimingInterval = value;
    }

    /**
     * Gets the value of the expectedInvoiceInterval property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getExpectedInvoiceInterval() {
        return expectedInvoiceInterval;
    }

    /**
     * Sets the value of the expectedInvoiceInterval property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setExpectedInvoiceInterval(String value) {
        this.expectedInvoiceInterval = value;
    }

    /**
     * Gets the value of the expectedActivationInterval property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getExpectedActivationInterval() {
        return expectedActivationInterval;
    }

    /**
     * Sets the value of the expectedActivationInterval property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setExpectedActivationInterval(String value) {
        this.expectedActivationInterval = value;
    }

    /**
     * Gets the value of the renewalEvaluationInterval property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRenewalEvaluationInterval() {
        return renewalEvaluationInterval;
    }

    /**
     * Sets the value of the renewalEvaluationInterval property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRenewalEvaluationInterval(String value) {
        this.renewalEvaluationInterval = value;
    }

    /**
     * Gets the value of the subscriptionInterval property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSubscriptionInterval() {
        return subscriptionInterval;
    }

    /**
     * Sets the value of the subscriptionInterval property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSubscriptionInterval(String value) {
        this.subscriptionInterval = value;
    }

    /**
     * Gets the value of the reclaimInterval property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getReclaimInterval() {
        return reclaimInterval;
    }

    /**
     * Sets the value of the reclaimInterval property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setReclaimInterval(String value) {
        this.reclaimInterval = value;
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
