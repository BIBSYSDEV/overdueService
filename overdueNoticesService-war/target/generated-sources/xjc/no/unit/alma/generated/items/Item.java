//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.3.0 
// See <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2021.01.04 at 01:21:48 PM CET 
//


package no.unit.alma.generated.items;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * A Physical item.
 * 
 * <p>Java class for item complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="item"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;all&gt;
 *         &lt;element name="bib_data" type="{}bib_data" minOccurs="0"/&gt;
 *         &lt;element name="holding_data" type="{}holding_data"/&gt;
 *         &lt;element name="item_data" type="{}item_data"/&gt;
 *         &lt;element name="additional_info" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/all&gt;
 *       &lt;attribute name="link" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "item", propOrder = {

})
public class Item {

    @XmlElement(name = "bib_data")
    protected BibData bibData;
    @XmlElement(name = "holding_data", required = true)
    protected HoldingData holdingData;
    @XmlElement(name = "item_data", required = true)
    protected ItemData itemData;
    @XmlElement(name = "additional_info")
    protected String additionalInfo;
    @XmlAttribute(name = "link")
    protected String link;

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
     * Gets the value of the holdingData property.
     * 
     * @return
     *     possible object is
     *     {@link HoldingData }
     *     
     */
    public HoldingData getHoldingData() {
        return holdingData;
    }

    /**
     * Sets the value of the holdingData property.
     * 
     * @param value
     *     allowed object is
     *     {@link HoldingData }
     *     
     */
    public void setHoldingData(HoldingData value) {
        this.holdingData = value;
    }

    /**
     * Gets the value of the itemData property.
     * 
     * @return
     *     possible object is
     *     {@link ItemData }
     *     
     */
    public ItemData getItemData() {
        return itemData;
    }

    /**
     * Sets the value of the itemData property.
     * 
     * @param value
     *     allowed object is
     *     {@link ItemData }
     *     
     */
    public void setItemData(ItemData value) {
        this.itemData = value;
    }

    /**
     * Gets the value of the additionalInfo property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAdditionalInfo() {
        return additionalInfo;
    }

    /**
     * Sets the value of the additionalInfo property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAdditionalInfo(String value) {
        this.additionalInfo = value;
    }

    /**
     * Gets the value of the link property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLink() {
        return link;
    }

    /**
     * Sets the value of the link property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLink(String value) {
        this.link = value;
    }

}
