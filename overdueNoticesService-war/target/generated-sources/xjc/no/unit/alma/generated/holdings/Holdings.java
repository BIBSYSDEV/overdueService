//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.3.0 
// See <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2021.01.06 at 10:21:06 AM CET 
//


package no.unit.alma.generated.holdings;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Holding Records
 * 
 * <p>Java class for holdings complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="holdings"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="holding" type="{}holding" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="bib_data" type="{}bib_data"/&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute name="total_record_count" type="{http://www.w3.org/2001/XMLSchema}int" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "holdings", propOrder = {
    "holding",
    "bibData"
})
public class Holdings {

    protected List<Holding> holding;
    @XmlElement(name = "bib_data", required = true)
    protected BibData bibData;
    @XmlAttribute(name = "total_record_count")
    protected Integer totalRecordCount;

    /**
     * Gets the value of the holding property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the holding property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getHolding().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Holding }
     * 
     * 
     */
    public List<Holding> getHolding() {
        if (holding == null) {
            holding = new ArrayList<Holding>();
        }
        return this.holding;
    }

    /**
     * Gets the value of the bibData property.
     * 
     * @return
     *     possible object is
     *     {@link BibData }
     *     
     */
    public BibData getBibData() {
        return bibData;
    }

    /**
     * Sets the value of the bibData property.
     * 
     * @param value
     *     allowed object is
     *     {@link BibData }
     *     
     */
    public void setBibData(BibData value) {
        this.bibData = value;
    }

    /**
     * Gets the value of the totalRecordCount property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getTotalRecordCount() {
        return totalRecordCount;
    }

    /**
     * Sets the value of the totalRecordCount property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setTotalRecordCount(Integer value) {
        this.totalRecordCount = value;
    }

}
