//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.3.0 
// See <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2021.01.06 at 08:55:40 PM CET 
//


package no.unit.alma.generated.user;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * List of researcher's current external organization affiliations.
 * 
 * <p>Java class for researcher_external_organization_affiliations complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="researcher_external_organization_affiliations"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="researcher_external_organization_affiliation" type="{}researcher_organization_affiliation" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "researcher_external_organization_affiliations", propOrder = {
    "researcherExternalOrganizationAffiliation"
})
public class ResearcherExternalOrganizationAffiliations {

    @XmlElement(name = "researcher_external_organization_affiliation")
    protected List<ResearcherOrganizationAffiliation> researcherExternalOrganizationAffiliation;

    /**
     * Gets the value of the researcherExternalOrganizationAffiliation property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the researcherExternalOrganizationAffiliation property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getResearcherExternalOrganizationAffiliation().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ResearcherOrganizationAffiliation }
     * 
     * 
     */
    public List<ResearcherOrganizationAffiliation> getResearcherExternalOrganizationAffiliation() {
        if (researcherExternalOrganizationAffiliation == null) {
            researcherExternalOrganizationAffiliation = new ArrayList<ResearcherOrganizationAffiliation>();
        }
        return this.researcherExternalOrganizationAffiliation;
    }

}
