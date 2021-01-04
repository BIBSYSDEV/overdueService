//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.3.0 
// See <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2021.01.04 at 01:32:40 PM CET 
//


package no.unit.alma.generated.users;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlValue;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * Specific researcher's engagement type.
 * 
 * <p>Java class for researcher_engagement_type complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="researcher_engagement_type"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="researcher_engagement" minOccurs="0"&gt;
 *           &lt;complexType&gt;
 *             &lt;simpleContent&gt;
 *               &lt;extension base="&lt;&gt;string255Length"&gt;
 *                 &lt;attribute name="desc" type="{}string4000Length" /&gt;
 *               &lt;/extension&gt;
 *             &lt;/simpleContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="engagement_end_date" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "researcher_engagement_type", propOrder = {
    "researcherEngagement",
    "engagementEndDate"
})
public class ResearcherEngagementType {

    @XmlElement(name = "researcher_engagement")
    protected ResearcherEngagementType.ResearcherEngagement researcherEngagement;
    @XmlElement(name = "engagement_end_date")
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar engagementEndDate;

    /**
     * Gets the value of the researcherEngagement property.
     * 
     * @return
     *     possible object is
     *     {@link ResearcherEngagementType.ResearcherEngagement }
     *     
     */
    public ResearcherEngagementType.ResearcherEngagement getResearcherEngagement() {
        return researcherEngagement;
    }

    /**
     * Sets the value of the researcherEngagement property.
     * 
     * @param value
     *     allowed object is
     *     {@link ResearcherEngagementType.ResearcherEngagement }
     *     
     */
    public void setResearcherEngagement(ResearcherEngagementType.ResearcherEngagement value) {
        this.researcherEngagement = value;
    }

    /**
     * Gets the value of the engagementEndDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getEngagementEndDate() {
        return engagementEndDate;
    }

    /**
     * Sets the value of the engagementEndDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setEngagementEndDate(XMLGregorianCalendar value) {
        this.engagementEndDate = value;
    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType&gt;
     *   &lt;simpleContent&gt;
     *     &lt;extension base="&lt;&gt;string255Length"&gt;
     *       &lt;attribute name="desc" type="{}string4000Length" /&gt;
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
    public static class ResearcherEngagement {

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
