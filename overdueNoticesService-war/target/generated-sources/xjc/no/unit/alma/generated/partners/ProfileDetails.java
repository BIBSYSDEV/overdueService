//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.3.0 
// See <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2021.01.06 at 10:21:06 AM CET 
//


package no.unit.alma.generated.partners;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * The partner's profile details. 
 * 
 * <p>Java class for profile_details complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="profile_details"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;all&gt;
 *         &lt;element name="profile_type" type="{}profile_type"/&gt;
 *         &lt;element name="art_email_details" type="{}art_email_details" minOccurs="0"/&gt;
 *         &lt;element name="ncip_details" type="{}ncip_details" minOccurs="0"/&gt;
 *         &lt;element name="iso_details" type="{}iso_details" minOccurs="0"/&gt;
 *         &lt;element name="iso_18626_details" type="{}iso_18626_details" minOccurs="0"/&gt;
 *         &lt;element name="email_details" type="{}email_details" minOccurs="0"/&gt;
 *         &lt;element name="ncip_p2p_details" type="{}ncip_p2p_details" minOccurs="0"/&gt;
 *         &lt;element name="bldss_details" type="{}bldss_details" minOccurs="0"/&gt;
 *         &lt;element name="fulfillment_network_details" type="{}fulfillment_network_details" minOccurs="0"/&gt;
 *         &lt;element name="rapid_details" type="{}rapid_details" minOccurs="0"/&gt;
 *         &lt;element name="innreach_details" type="{}innreach_details" minOccurs="0"/&gt;
 *       &lt;/all&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "profile_details", propOrder = {

})
public class ProfileDetails {

    @XmlElement(name = "profile_type", required = true)
    @XmlSchemaType(name = "string")
    protected ProfileType profileType;
    @XmlElement(name = "art_email_details")
    protected ArtEmailDetails artEmailDetails;
    @XmlElement(name = "ncip_details")
    protected NcipDetails ncipDetails;
    @XmlElement(name = "iso_details")
    protected IsoDetails isoDetails;
    @XmlElement(name = "iso_18626_details")
    protected Iso18626Details iso18626Details;
    @XmlElement(name = "email_details")
    protected EmailDetails emailDetails;
    @XmlElement(name = "ncip_p2p_details")
    protected NcipP2PDetails ncipP2PDetails;
    @XmlElement(name = "bldss_details")
    protected BldssDetails bldssDetails;
    @XmlElement(name = "fulfillment_network_details")
    protected FulfillmentNetworkDetails fulfillmentNetworkDetails;
    @XmlElement(name = "rapid_details")
    protected RapidDetails rapidDetails;
    @XmlElement(name = "innreach_details")
    protected InnreachDetails innreachDetails;

    /**
     * Gets the value of the profileType property.
     * 
     * @return
     *     possible object is
     *     {@link ProfileType }
     *     
     */
    public ProfileType getProfileType() {
        return profileType;
    }

    /**
     * Sets the value of the profileType property.
     * 
     * @param value
     *     allowed object is
     *     {@link ProfileType }
     *     
     */
    public void setProfileType(ProfileType value) {
        this.profileType = value;
    }

    /**
     * Gets the value of the artEmailDetails property.
     * 
     * @return
     *     possible object is
     *     {@link ArtEmailDetails }
     *     
     */
    public ArtEmailDetails getArtEmailDetails() {
        return artEmailDetails;
    }

    /**
     * Sets the value of the artEmailDetails property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArtEmailDetails }
     *     
     */
    public void setArtEmailDetails(ArtEmailDetails value) {
        this.artEmailDetails = value;
    }

    /**
     * Gets the value of the ncipDetails property.
     * 
     * @return
     *     possible object is
     *     {@link NcipDetails }
     *     
     */
    public NcipDetails getNcipDetails() {
        return ncipDetails;
    }

    /**
     * Sets the value of the ncipDetails property.
     * 
     * @param value
     *     allowed object is
     *     {@link NcipDetails }
     *     
     */
    public void setNcipDetails(NcipDetails value) {
        this.ncipDetails = value;
    }

    /**
     * Gets the value of the isoDetails property.
     * 
     * @return
     *     possible object is
     *     {@link IsoDetails }
     *     
     */
    public IsoDetails getIsoDetails() {
        return isoDetails;
    }

    /**
     * Sets the value of the isoDetails property.
     * 
     * @param value
     *     allowed object is
     *     {@link IsoDetails }
     *     
     */
    public void setIsoDetails(IsoDetails value) {
        this.isoDetails = value;
    }

    /**
     * Gets the value of the iso18626Details property.
     * 
     * @return
     *     possible object is
     *     {@link Iso18626Details }
     *     
     */
    public Iso18626Details getIso18626Details() {
        return iso18626Details;
    }

    /**
     * Sets the value of the iso18626Details property.
     * 
     * @param value
     *     allowed object is
     *     {@link Iso18626Details }
     *     
     */
    public void setIso18626Details(Iso18626Details value) {
        this.iso18626Details = value;
    }

    /**
     * Gets the value of the emailDetails property.
     * 
     * @return
     *     possible object is
     *     {@link EmailDetails }
     *     
     */
    public EmailDetails getEmailDetails() {
        return emailDetails;
    }

    /**
     * Sets the value of the emailDetails property.
     * 
     * @param value
     *     allowed object is
     *     {@link EmailDetails }
     *     
     */
    public void setEmailDetails(EmailDetails value) {
        this.emailDetails = value;
    }

    /**
     * Gets the value of the ncipP2PDetails property.
     * 
     * @return
     *     possible object is
     *     {@link NcipP2PDetails }
     *     
     */
    public NcipP2PDetails getNcipP2PDetails() {
        return ncipP2PDetails;
    }

    /**
     * Sets the value of the ncipP2PDetails property.
     * 
     * @param value
     *     allowed object is
     *     {@link NcipP2PDetails }
     *     
     */
    public void setNcipP2PDetails(NcipP2PDetails value) {
        this.ncipP2PDetails = value;
    }

    /**
     * Gets the value of the bldssDetails property.
     * 
     * @return
     *     possible object is
     *     {@link BldssDetails }
     *     
     */
    public BldssDetails getBldssDetails() {
        return bldssDetails;
    }

    /**
     * Sets the value of the bldssDetails property.
     * 
     * @param value
     *     allowed object is
     *     {@link BldssDetails }
     *     
     */
    public void setBldssDetails(BldssDetails value) {
        this.bldssDetails = value;
    }

    /**
     * Gets the value of the fulfillmentNetworkDetails property.
     * 
     * @return
     *     possible object is
     *     {@link FulfillmentNetworkDetails }
     *     
     */
    public FulfillmentNetworkDetails getFulfillmentNetworkDetails() {
        return fulfillmentNetworkDetails;
    }

    /**
     * Sets the value of the fulfillmentNetworkDetails property.
     * 
     * @param value
     *     allowed object is
     *     {@link FulfillmentNetworkDetails }
     *     
     */
    public void setFulfillmentNetworkDetails(FulfillmentNetworkDetails value) {
        this.fulfillmentNetworkDetails = value;
    }

    /**
     * Gets the value of the rapidDetails property.
     * 
     * @return
     *     possible object is
     *     {@link RapidDetails }
     *     
     */
    public RapidDetails getRapidDetails() {
        return rapidDetails;
    }

    /**
     * Sets the value of the rapidDetails property.
     * 
     * @param value
     *     allowed object is
     *     {@link RapidDetails }
     *     
     */
    public void setRapidDetails(RapidDetails value) {
        this.rapidDetails = value;
    }

    /**
     * Gets the value of the innreachDetails property.
     * 
     * @return
     *     possible object is
     *     {@link InnreachDetails }
     *     
     */
    public InnreachDetails getInnreachDetails() {
        return innreachDetails;
    }

    /**
     * Sets the value of the innreachDetails property.
     * 
     * @param value
     *     allowed object is
     *     {@link InnreachDetails }
     *     
     */
    public void setInnreachDetails(InnreachDetails value) {
        this.innreachDetails = value;
    }

}
