//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.3.0 
// See <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2021.01.05 at 09:04:45 AM CET 
//


package no.unit.alma.generated.users;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Specific researcher's education info.
 * 
 * <p>Java class for researcher_education complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="researcher_education"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="organization_code" type="{}string255Length" minOccurs="0"/&gt;
 *         &lt;element name="organization_name" type="{}string255Length" minOccurs="0"/&gt;
 *         &lt;element name="degree" type="{}string255Length" minOccurs="0"/&gt;
 *         &lt;element name="from_year" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&gt;
 *         &lt;element name="to_year" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&gt;
 *         &lt;element name="field_of_study" type="{}string255Length" minOccurs="0"/&gt;
 *         &lt;element name="additional_details" type="{}string255Length" minOccurs="0"/&gt;
 *         &lt;element name="suppress_from_public_portal" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "researcher_education", propOrder = {
    "organizationCode",
    "organizationName",
    "degree",
    "fromYear",
    "toYear",
    "fieldOfStudy",
    "additionalDetails",
    "suppressFromPublicPortal"
})
public class ResearcherEducation {

    @XmlElement(name = "organization_code")
    protected String organizationCode;
    @XmlElement(name = "organization_name")
    protected String organizationName;
    protected String degree;
    @XmlElement(name = "from_year")
    protected Integer fromYear;
    @XmlElement(name = "to_year")
    protected Integer toYear;
    @XmlElement(name = "field_of_study")
    protected String fieldOfStudy;
    @XmlElement(name = "additional_details")
    protected String additionalDetails;
    @XmlElement(name = "suppress_from_public_portal")
    protected Boolean suppressFromPublicPortal;

    /**
     * Gets the value of the organizationCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOrganizationCode() {
        return organizationCode;
    }

    /**
     * Sets the value of the organizationCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOrganizationCode(String value) {
        this.organizationCode = value;
    }

    /**
     * Gets the value of the organizationName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOrganizationName() {
        return organizationName;
    }

    /**
     * Sets the value of the organizationName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOrganizationName(String value) {
        this.organizationName = value;
    }

    /**
     * Gets the value of the degree property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDegree() {
        return degree;
    }

    /**
     * Sets the value of the degree property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDegree(String value) {
        this.degree = value;
    }

    /**
     * Gets the value of the fromYear property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getFromYear() {
        return fromYear;
    }

    /**
     * Sets the value of the fromYear property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setFromYear(Integer value) {
        this.fromYear = value;
    }

    /**
     * Gets the value of the toYear property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getToYear() {
        return toYear;
    }

    /**
     * Sets the value of the toYear property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setToYear(Integer value) {
        this.toYear = value;
    }

    /**
     * Gets the value of the fieldOfStudy property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFieldOfStudy() {
        return fieldOfStudy;
    }

    /**
     * Sets the value of the fieldOfStudy property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFieldOfStudy(String value) {
        this.fieldOfStudy = value;
    }

    /**
     * Gets the value of the additionalDetails property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAdditionalDetails() {
        return additionalDetails;
    }

    /**
     * Sets the value of the additionalDetails property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAdditionalDetails(String value) {
        this.additionalDetails = value;
    }

    /**
     * Gets the value of the suppressFromPublicPortal property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isSuppressFromPublicPortal() {
        return suppressFromPublicPortal;
    }

    /**
     * Sets the value of the suppressFromPublicPortal property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setSuppressFromPublicPortal(Boolean value) {
        this.suppressFromPublicPortal = value;
    }

}
