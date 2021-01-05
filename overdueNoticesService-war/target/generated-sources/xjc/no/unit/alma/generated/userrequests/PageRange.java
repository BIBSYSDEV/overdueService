//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.3.0 
// See <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2021.01.05 at 09:04:47 AM CET 
//


package no.unit.alma.generated.userrequests;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * A range of pages.
 * 
 * <p>Java class for page_range complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="page_range"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;all&gt;
 *         &lt;element name="from_page" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="to_page" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/all&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "page_range", propOrder = {

})
public class PageRange {

    @XmlElement(name = "from_page")
    protected String fromPage;
    @XmlElement(name = "to_page")
    protected String toPage;

    /**
     * Gets the value of the fromPage property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFromPage() {
        return fromPage;
    }

    /**
     * Sets the value of the fromPage property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFromPage(String value) {
        this.fromPage = value;
    }

    /**
     * Gets the value of the toPage property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getToPage() {
        return toPage;
    }

    /**
     * Sets the value of the toPage property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setToPage(String value) {
        this.toPage = value;
    }

}
