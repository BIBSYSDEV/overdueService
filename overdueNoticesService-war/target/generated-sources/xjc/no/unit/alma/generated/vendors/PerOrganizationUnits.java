//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.3.0 
// See <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2021.01.08 at 08:07:01 AM CET 
//


package no.unit.alma.generated.vendors;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * List of EDI codes and types for specific libraries, if used by the vendor.
 * 			One entry must be defined for the institution and its EDI code and type.
 * 			In the PUT action the incoming list will replace the existing list. If the incoming list is empty, the existing list will be deleted.
 * 			
 * 
 * <p>Java class for per_organization_units complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="per_organization_units"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="per_organization_unit" type="{}per_organization_unit" maxOccurs="unbounded"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "per_organization_units", propOrder = {
    "perOrganizationUnit"
})
public class PerOrganizationUnits {

    @XmlElement(name = "per_organization_unit", required = true)
    protected List<PerOrganizationUnit> perOrganizationUnit;

    /**
     * Gets the value of the perOrganizationUnit property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the perOrganizationUnit property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPerOrganizationUnit().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link PerOrganizationUnit }
     * 
     * 
     */
    public List<PerOrganizationUnit> getPerOrganizationUnit() {
        if (perOrganizationUnit == null) {
            perOrganizationUnit = new ArrayList<PerOrganizationUnit>();
        }
        return this.perOrganizationUnit;
    }

}
