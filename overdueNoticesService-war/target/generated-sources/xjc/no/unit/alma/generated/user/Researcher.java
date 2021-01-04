//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.3.0 
// See <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2021.01.04 at 01:21:49 PM CET 
//


package no.unit.alma.generated.user;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlValue;


/**
 * Researcher information.
 * 					SIS, API:
 * 			
 * 
 * <p>Java class for researcher complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="researcher"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;all&gt;
 *         &lt;element name="researcher_first_name" type="{}string255Length" minOccurs="0"/&gt;
 *         &lt;element name="researcher_middle_name" type="{}string255Length" minOccurs="0"/&gt;
 *         &lt;element name="researcher_last_name" type="{}string255Length" minOccurs="0"/&gt;
 *         &lt;element name="researcher_suffix" type="{}string255Length" minOccurs="0"/&gt;
 *         &lt;element name="researcher_title" minOccurs="0"&gt;
 *           &lt;complexType&gt;
 *             &lt;simpleContent&gt;
 *               &lt;extension base="&lt;&gt;string255Length"&gt;
 *                 &lt;attribute name="desc" type="{}string4000Length" /&gt;
 *               &lt;/extension&gt;
 *             &lt;/simpleContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="profile_image_url" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="position" minOccurs="0"&gt;
 *           &lt;complexType&gt;
 *             &lt;simpleContent&gt;
 *               &lt;extension base="&lt;&gt;string255Length"&gt;
 *                 &lt;attribute name="desc" type="{}string4000Length" /&gt;
 *               &lt;/extension&gt;
 *             &lt;/simpleContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="portal_profile" minOccurs="0"&gt;
 *           &lt;complexType&gt;
 *             &lt;simpleContent&gt;
 *               &lt;extension base="&lt;&gt;string255Length"&gt;
 *                 &lt;attribute name="desc" type="{}string4000Length" /&gt;
 *               &lt;/extension&gt;
 *             &lt;/simpleContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="auto_capture" type="{}string20Length" minOccurs="0"/&gt;
 *         &lt;element name="research_center" type="{}string20Length" minOccurs="0"/&gt;
 *         &lt;element name="previous_affiliated" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/&gt;
 *         &lt;element name="default_publication_language" minOccurs="0"&gt;
 *           &lt;complexType&gt;
 *             &lt;simpleContent&gt;
 *               &lt;extension base="&lt;&gt;string255Length"&gt;
 *                 &lt;attribute name="desc" type="{}string4000Length" /&gt;
 *               &lt;/extension&gt;
 *             &lt;/simpleContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="researcher_alternate_emails" type="{}researcher_alternate_emails" minOccurs="0"/&gt;
 *         &lt;element name="researcher_organization_affiliations" type="{}researcher_organization_affiliations" minOccurs="0"/&gt;
 *         &lt;element name="researcher_previous_organization_affiliations" type="{}researcher_previous_organization_affiliations" minOccurs="0"/&gt;
 *         &lt;element name="researcher_external_organization_affiliations" type="{}researcher_external_organization_affiliations" minOccurs="0"/&gt;
 *         &lt;element name="researcher_previous_external_organization_affiliations" type="{}researcher_previous_external_organization_affiliations" minOccurs="0"/&gt;
 *         &lt;element name="researcher_name_variants" type="{}researcher_name_variants" minOccurs="0"/&gt;
 *         &lt;element name="researcher_engagement_types" type="{}researcher_engagement_types" minOccurs="0"/&gt;
 *         &lt;element name="researcher_research_topics" type="{}researcher_research_topics" minOccurs="0"/&gt;
 *         &lt;element name="researcher_keywords" type="{}researcher_keywords" minOccurs="0"/&gt;
 *         &lt;element name="researcher_associations" type="{}researcher_associations" minOccurs="0"/&gt;
 *         &lt;element name="researcher_languages" type="{}researcher_languages" minOccurs="0"/&gt;
 *         &lt;element name="researcher_honors" type="{}researcher_honors" minOccurs="0"/&gt;
 *         &lt;element name="researcher_educations" type="{}researcher_educations" minOccurs="0"/&gt;
 *         &lt;element name="researcher_descriptions" type="{}researcher_descriptions" minOccurs="0"/&gt;
 *         &lt;element name="researcher_webpages" type="{}researcher_webpages" minOccurs="0"/&gt;
 *       &lt;/all&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "researcher", propOrder = {

})
public class Researcher {

    @XmlElement(name = "researcher_first_name")
    protected String researcherFirstName;
    @XmlElement(name = "researcher_middle_name")
    protected String researcherMiddleName;
    @XmlElement(name = "researcher_last_name")
    protected String researcherLastName;
    @XmlElement(name = "researcher_suffix")
    protected String researcherSuffix;
    @XmlElement(name = "researcher_title")
    protected Researcher.ResearcherTitle researcherTitle;
    @XmlElement(name = "profile_image_url")
    protected String profileImageUrl;
    protected Researcher.Position position;
    @XmlElement(name = "portal_profile")
    protected Researcher.PortalProfile portalProfile;
    @XmlElement(name = "auto_capture")
    protected String autoCapture;
    @XmlElement(name = "research_center")
    protected String researchCenter;
    @XmlElement(name = "previous_affiliated")
    protected Boolean previousAffiliated;
    @XmlElement(name = "default_publication_language")
    protected Researcher.DefaultPublicationLanguage defaultPublicationLanguage;
    @XmlElement(name = "researcher_alternate_emails")
    protected ResearcherAlternateEmails researcherAlternateEmails;
    @XmlElement(name = "researcher_organization_affiliations")
    protected ResearcherOrganizationAffiliations researcherOrganizationAffiliations;
    @XmlElement(name = "researcher_previous_organization_affiliations")
    protected ResearcherPreviousOrganizationAffiliations researcherPreviousOrganizationAffiliations;
    @XmlElement(name = "researcher_external_organization_affiliations")
    protected ResearcherExternalOrganizationAffiliations researcherExternalOrganizationAffiliations;
    @XmlElement(name = "researcher_previous_external_organization_affiliations")
    protected ResearcherPreviousExternalOrganizationAffiliations researcherPreviousExternalOrganizationAffiliations;
    @XmlElement(name = "researcher_name_variants")
    protected ResearcherNameVariants researcherNameVariants;
    @XmlElement(name = "researcher_engagement_types")
    protected ResearcherEngagementTypes researcherEngagementTypes;
    @XmlElement(name = "researcher_research_topics")
    protected ResearcherResearchTopics researcherResearchTopics;
    @XmlElement(name = "researcher_keywords")
    protected ResearcherKeywords researcherKeywords;
    @XmlElement(name = "researcher_associations")
    protected ResearcherAssociations researcherAssociations;
    @XmlElement(name = "researcher_languages")
    protected ResearcherLanguages researcherLanguages;
    @XmlElement(name = "researcher_honors")
    protected ResearcherHonors researcherHonors;
    @XmlElement(name = "researcher_educations")
    protected ResearcherEducations researcherEducations;
    @XmlElement(name = "researcher_descriptions")
    protected ResearcherDescriptions researcherDescriptions;
    @XmlElement(name = "researcher_webpages")
    protected ResearcherWebpages researcherWebpages;

    /**
     * Gets the value of the researcherFirstName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getResearcherFirstName() {
        return researcherFirstName;
    }

    /**
     * Sets the value of the researcherFirstName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setResearcherFirstName(String value) {
        this.researcherFirstName = value;
    }

    /**
     * Gets the value of the researcherMiddleName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getResearcherMiddleName() {
        return researcherMiddleName;
    }

    /**
     * Sets the value of the researcherMiddleName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setResearcherMiddleName(String value) {
        this.researcherMiddleName = value;
    }

    /**
     * Gets the value of the researcherLastName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getResearcherLastName() {
        return researcherLastName;
    }

    /**
     * Sets the value of the researcherLastName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setResearcherLastName(String value) {
        this.researcherLastName = value;
    }

    /**
     * Gets the value of the researcherSuffix property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getResearcherSuffix() {
        return researcherSuffix;
    }

    /**
     * Sets the value of the researcherSuffix property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setResearcherSuffix(String value) {
        this.researcherSuffix = value;
    }

    /**
     * Gets the value of the researcherTitle property.
     * 
     * @return
     *     possible object is
     *     {@link Researcher.ResearcherTitle }
     *     
     */
    public Researcher.ResearcherTitle getResearcherTitle() {
        return researcherTitle;
    }

    /**
     * Sets the value of the researcherTitle property.
     * 
     * @param value
     *     allowed object is
     *     {@link Researcher.ResearcherTitle }
     *     
     */
    public void setResearcherTitle(Researcher.ResearcherTitle value) {
        this.researcherTitle = value;
    }

    /**
     * Gets the value of the profileImageUrl property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProfileImageUrl() {
        return profileImageUrl;
    }

    /**
     * Sets the value of the profileImageUrl property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProfileImageUrl(String value) {
        this.profileImageUrl = value;
    }

    /**
     * Gets the value of the position property.
     * 
     * @return
     *     possible object is
     *     {@link Researcher.Position }
     *     
     */
    public Researcher.Position getPosition() {
        return position;
    }

    /**
     * Sets the value of the position property.
     * 
     * @param value
     *     allowed object is
     *     {@link Researcher.Position }
     *     
     */
    public void setPosition(Researcher.Position value) {
        this.position = value;
    }

    /**
     * Gets the value of the portalProfile property.
     * 
     * @return
     *     possible object is
     *     {@link Researcher.PortalProfile }
     *     
     */
    public Researcher.PortalProfile getPortalProfile() {
        return portalProfile;
    }

    /**
     * Sets the value of the portalProfile property.
     * 
     * @param value
     *     allowed object is
     *     {@link Researcher.PortalProfile }
     *     
     */
    public void setPortalProfile(Researcher.PortalProfile value) {
        this.portalProfile = value;
    }

    /**
     * Gets the value of the autoCapture property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAutoCapture() {
        return autoCapture;
    }

    /**
     * Sets the value of the autoCapture property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAutoCapture(String value) {
        this.autoCapture = value;
    }

    /**
     * Gets the value of the researchCenter property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getResearchCenter() {
        return researchCenter;
    }

    /**
     * Sets the value of the researchCenter property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setResearchCenter(String value) {
        this.researchCenter = value;
    }

    /**
     * Gets the value of the previousAffiliated property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isPreviousAffiliated() {
        return previousAffiliated;
    }

    /**
     * Sets the value of the previousAffiliated property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setPreviousAffiliated(Boolean value) {
        this.previousAffiliated = value;
    }

    /**
     * Gets the value of the defaultPublicationLanguage property.
     * 
     * @return
     *     possible object is
     *     {@link Researcher.DefaultPublicationLanguage }
     *     
     */
    public Researcher.DefaultPublicationLanguage getDefaultPublicationLanguage() {
        return defaultPublicationLanguage;
    }

    /**
     * Sets the value of the defaultPublicationLanguage property.
     * 
     * @param value
     *     allowed object is
     *     {@link Researcher.DefaultPublicationLanguage }
     *     
     */
    public void setDefaultPublicationLanguage(Researcher.DefaultPublicationLanguage value) {
        this.defaultPublicationLanguage = value;
    }

    /**
     * Gets the value of the researcherAlternateEmails property.
     * 
     * @return
     *     possible object is
     *     {@link ResearcherAlternateEmails }
     *     
     */
    public ResearcherAlternateEmails getResearcherAlternateEmails() {
        return researcherAlternateEmails;
    }

    /**
     * Sets the value of the researcherAlternateEmails property.
     * 
     * @param value
     *     allowed object is
     *     {@link ResearcherAlternateEmails }
     *     
     */
    public void setResearcherAlternateEmails(ResearcherAlternateEmails value) {
        this.researcherAlternateEmails = value;
    }

    /**
     * Gets the value of the researcherOrganizationAffiliations property.
     * 
     * @return
     *     possible object is
     *     {@link ResearcherOrganizationAffiliations }
     *     
     */
    public ResearcherOrganizationAffiliations getResearcherOrganizationAffiliations() {
        return researcherOrganizationAffiliations;
    }

    /**
     * Sets the value of the researcherOrganizationAffiliations property.
     * 
     * @param value
     *     allowed object is
     *     {@link ResearcherOrganizationAffiliations }
     *     
     */
    public void setResearcherOrganizationAffiliations(ResearcherOrganizationAffiliations value) {
        this.researcherOrganizationAffiliations = value;
    }

    /**
     * Gets the value of the researcherPreviousOrganizationAffiliations property.
     * 
     * @return
     *     possible object is
     *     {@link ResearcherPreviousOrganizationAffiliations }
     *     
     */
    public ResearcherPreviousOrganizationAffiliations getResearcherPreviousOrganizationAffiliations() {
        return researcherPreviousOrganizationAffiliations;
    }

    /**
     * Sets the value of the researcherPreviousOrganizationAffiliations property.
     * 
     * @param value
     *     allowed object is
     *     {@link ResearcherPreviousOrganizationAffiliations }
     *     
     */
    public void setResearcherPreviousOrganizationAffiliations(ResearcherPreviousOrganizationAffiliations value) {
        this.researcherPreviousOrganizationAffiliations = value;
    }

    /**
     * Gets the value of the researcherExternalOrganizationAffiliations property.
     * 
     * @return
     *     possible object is
     *     {@link ResearcherExternalOrganizationAffiliations }
     *     
     */
    public ResearcherExternalOrganizationAffiliations getResearcherExternalOrganizationAffiliations() {
        return researcherExternalOrganizationAffiliations;
    }

    /**
     * Sets the value of the researcherExternalOrganizationAffiliations property.
     * 
     * @param value
     *     allowed object is
     *     {@link ResearcherExternalOrganizationAffiliations }
     *     
     */
    public void setResearcherExternalOrganizationAffiliations(ResearcherExternalOrganizationAffiliations value) {
        this.researcherExternalOrganizationAffiliations = value;
    }

    /**
     * Gets the value of the researcherPreviousExternalOrganizationAffiliations property.
     * 
     * @return
     *     possible object is
     *     {@link ResearcherPreviousExternalOrganizationAffiliations }
     *     
     */
    public ResearcherPreviousExternalOrganizationAffiliations getResearcherPreviousExternalOrganizationAffiliations() {
        return researcherPreviousExternalOrganizationAffiliations;
    }

    /**
     * Sets the value of the researcherPreviousExternalOrganizationAffiliations property.
     * 
     * @param value
     *     allowed object is
     *     {@link ResearcherPreviousExternalOrganizationAffiliations }
     *     
     */
    public void setResearcherPreviousExternalOrganizationAffiliations(ResearcherPreviousExternalOrganizationAffiliations value) {
        this.researcherPreviousExternalOrganizationAffiliations = value;
    }

    /**
     * Gets the value of the researcherNameVariants property.
     * 
     * @return
     *     possible object is
     *     {@link ResearcherNameVariants }
     *     
     */
    public ResearcherNameVariants getResearcherNameVariants() {
        return researcherNameVariants;
    }

    /**
     * Sets the value of the researcherNameVariants property.
     * 
     * @param value
     *     allowed object is
     *     {@link ResearcherNameVariants }
     *     
     */
    public void setResearcherNameVariants(ResearcherNameVariants value) {
        this.researcherNameVariants = value;
    }

    /**
     * Gets the value of the researcherEngagementTypes property.
     * 
     * @return
     *     possible object is
     *     {@link ResearcherEngagementTypes }
     *     
     */
    public ResearcherEngagementTypes getResearcherEngagementTypes() {
        return researcherEngagementTypes;
    }

    /**
     * Sets the value of the researcherEngagementTypes property.
     * 
     * @param value
     *     allowed object is
     *     {@link ResearcherEngagementTypes }
     *     
     */
    public void setResearcherEngagementTypes(ResearcherEngagementTypes value) {
        this.researcherEngagementTypes = value;
    }

    /**
     * Gets the value of the researcherResearchTopics property.
     * 
     * @return
     *     possible object is
     *     {@link ResearcherResearchTopics }
     *     
     */
    public ResearcherResearchTopics getResearcherResearchTopics() {
        return researcherResearchTopics;
    }

    /**
     * Sets the value of the researcherResearchTopics property.
     * 
     * @param value
     *     allowed object is
     *     {@link ResearcherResearchTopics }
     *     
     */
    public void setResearcherResearchTopics(ResearcherResearchTopics value) {
        this.researcherResearchTopics = value;
    }

    /**
     * Gets the value of the researcherKeywords property.
     * 
     * @return
     *     possible object is
     *     {@link ResearcherKeywords }
     *     
     */
    public ResearcherKeywords getResearcherKeywords() {
        return researcherKeywords;
    }

    /**
     * Sets the value of the researcherKeywords property.
     * 
     * @param value
     *     allowed object is
     *     {@link ResearcherKeywords }
     *     
     */
    public void setResearcherKeywords(ResearcherKeywords value) {
        this.researcherKeywords = value;
    }

    /**
     * Gets the value of the researcherAssociations property.
     * 
     * @return
     *     possible object is
     *     {@link ResearcherAssociations }
     *     
     */
    public ResearcherAssociations getResearcherAssociations() {
        return researcherAssociations;
    }

    /**
     * Sets the value of the researcherAssociations property.
     * 
     * @param value
     *     allowed object is
     *     {@link ResearcherAssociations }
     *     
     */
    public void setResearcherAssociations(ResearcherAssociations value) {
        this.researcherAssociations = value;
    }

    /**
     * Gets the value of the researcherLanguages property.
     * 
     * @return
     *     possible object is
     *     {@link ResearcherLanguages }
     *     
     */
    public ResearcherLanguages getResearcherLanguages() {
        return researcherLanguages;
    }

    /**
     * Sets the value of the researcherLanguages property.
     * 
     * @param value
     *     allowed object is
     *     {@link ResearcherLanguages }
     *     
     */
    public void setResearcherLanguages(ResearcherLanguages value) {
        this.researcherLanguages = value;
    }

    /**
     * Gets the value of the researcherHonors property.
     * 
     * @return
     *     possible object is
     *     {@link ResearcherHonors }
     *     
     */
    public ResearcherHonors getResearcherHonors() {
        return researcherHonors;
    }

    /**
     * Sets the value of the researcherHonors property.
     * 
     * @param value
     *     allowed object is
     *     {@link ResearcherHonors }
     *     
     */
    public void setResearcherHonors(ResearcherHonors value) {
        this.researcherHonors = value;
    }

    /**
     * Gets the value of the researcherEducations property.
     * 
     * @return
     *     possible object is
     *     {@link ResearcherEducations }
     *     
     */
    public ResearcherEducations getResearcherEducations() {
        return researcherEducations;
    }

    /**
     * Sets the value of the researcherEducations property.
     * 
     * @param value
     *     allowed object is
     *     {@link ResearcherEducations }
     *     
     */
    public void setResearcherEducations(ResearcherEducations value) {
        this.researcherEducations = value;
    }

    /**
     * Gets the value of the researcherDescriptions property.
     * 
     * @return
     *     possible object is
     *     {@link ResearcherDescriptions }
     *     
     */
    public ResearcherDescriptions getResearcherDescriptions() {
        return researcherDescriptions;
    }

    /**
     * Sets the value of the researcherDescriptions property.
     * 
     * @param value
     *     allowed object is
     *     {@link ResearcherDescriptions }
     *     
     */
    public void setResearcherDescriptions(ResearcherDescriptions value) {
        this.researcherDescriptions = value;
    }

    /**
     * Gets the value of the researcherWebpages property.
     * 
     * @return
     *     possible object is
     *     {@link ResearcherWebpages }
     *     
     */
    public ResearcherWebpages getResearcherWebpages() {
        return researcherWebpages;
    }

    /**
     * Sets the value of the researcherWebpages property.
     * 
     * @param value
     *     allowed object is
     *     {@link ResearcherWebpages }
     *     
     */
    public void setResearcherWebpages(ResearcherWebpages value) {
        this.researcherWebpages = value;
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
    public static class DefaultPublicationLanguage {

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
    public static class PortalProfile {

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
    public static class Position {

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
    public static class ResearcherTitle {

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