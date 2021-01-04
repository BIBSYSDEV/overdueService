//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.3.0 
// See <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2021.01.04 at 01:32:40 PM CET 
//


package no.unit.alma.generated.userresourcesharingrequests;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the no.unit.alma.generated.userresourcesharingrequests package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _UserResourceSharingRequest_QNAME = new QName("", "user_resource_sharing_request");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: no.unit.alma.generated.userresourcesharingrequests
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Amount }
     * 
     */
    public Amount createAmount() {
        return new Amount();
    }

    /**
     * Create an instance of {@link UserResourceSharingRequest }
     * 
     */
    public UserResourceSharingRequest createUserResourceSharingRequest() {
        return new UserResourceSharingRequest();
    }

    /**
     * Create an instance of {@link RsNotes }
     * 
     */
    public RsNotes createRsNotes() {
        return new RsNotes();
    }

    /**
     * Create an instance of {@link RsNote }
     * 
     */
    public RsNote createRsNote() {
        return new RsNote();
    }

    /**
     * Create an instance of {@link AdditionalBarcodes }
     * 
     */
    public AdditionalBarcodes createAdditionalBarcodes() {
        return new AdditionalBarcodes();
    }

    /**
     * Create an instance of {@link Amount.Currency }
     * 
     */
    public Amount.Currency createAmountCurrency() {
        return new Amount.Currency();
    }

    /**
     * Create an instance of {@link UserResourceSharingRequest.Status }
     * 
     */
    public UserResourceSharingRequest.Status createUserResourceSharingRequestStatus() {
        return new UserResourceSharingRequest.Status();
    }

    /**
     * Create an instance of {@link UserResourceSharingRequest.Partner }
     * 
     */
    public UserResourceSharingRequest.Partner createUserResourceSharingRequestPartner() {
        return new UserResourceSharingRequest.Partner();
    }

    /**
     * Create an instance of {@link UserResourceSharingRequest.UserRequest }
     * 
     */
    public UserResourceSharingRequest.UserRequest createUserResourceSharingRequestUserRequest() {
        return new UserResourceSharingRequest.UserRequest();
    }

    /**
     * Create an instance of {@link UserResourceSharingRequest.Requester }
     * 
     */
    public UserResourceSharingRequest.Requester createUserResourceSharingRequestRequester() {
        return new UserResourceSharingRequest.Requester();
    }

    /**
     * Create an instance of {@link UserResourceSharingRequest.Format }
     * 
     */
    public UserResourceSharingRequest.Format createUserResourceSharingRequestFormat() {
        return new UserResourceSharingRequest.Format();
    }

    /**
     * Create an instance of {@link UserResourceSharingRequest.SuppliedFormat }
     * 
     */
    public UserResourceSharingRequest.SuppliedFormat createUserResourceSharingRequestSuppliedFormat() {
        return new UserResourceSharingRequest.SuppliedFormat();
    }

    /**
     * Create an instance of {@link UserResourceSharingRequest.PreferredSendMethod }
     * 
     */
    public UserResourceSharingRequest.PreferredSendMethod createUserResourceSharingRequestPreferredSendMethod() {
        return new UserResourceSharingRequest.PreferredSendMethod();
    }

    /**
     * Create an instance of {@link UserResourceSharingRequest.RequestedLanguage }
     * 
     */
    public UserResourceSharingRequest.RequestedLanguage createUserResourceSharingRequestRequestedLanguage() {
        return new UserResourceSharingRequest.RequestedLanguage();
    }

    /**
     * Create an instance of {@link UserResourceSharingRequest.PickupLocation }
     * 
     */
    public UserResourceSharingRequest.PickupLocation createUserResourceSharingRequestPickupLocation() {
        return new UserResourceSharingRequest.PickupLocation();
    }

    /**
     * Create an instance of {@link UserResourceSharingRequest.ReadingRoom }
     * 
     */
    public UserResourceSharingRequest.ReadingRoom createUserResourceSharingRequestReadingRoom() {
        return new UserResourceSharingRequest.ReadingRoom();
    }

    /**
     * Create an instance of {@link UserResourceSharingRequest.Fund }
     * 
     */
    public UserResourceSharingRequest.Fund createUserResourceSharingRequestFund() {
        return new UserResourceSharingRequest.Fund();
    }

    /**
     * Create an instance of {@link UserResourceSharingRequest.CopyrightStatus }
     * 
     */
    public UserResourceSharingRequest.CopyrightStatus createUserResourceSharingRequestCopyrightStatus() {
        return new UserResourceSharingRequest.CopyrightStatus();
    }

    /**
     * Create an instance of {@link UserResourceSharingRequest.CitationType }
     * 
     */
    public UserResourceSharingRequest.CitationType createUserResourceSharingRequestCitationType() {
        return new UserResourceSharingRequest.CitationType();
    }

    /**
     * Create an instance of {@link UserResourceSharingRequest.LevelOfService }
     * 
     */
    public UserResourceSharingRequest.LevelOfService createUserResourceSharingRequestLevelOfService() {
        return new UserResourceSharingRequest.LevelOfService();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UserResourceSharingRequest }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link UserResourceSharingRequest }{@code >}
     */
    @XmlElementDecl(namespace = "", name = "user_resource_sharing_request")
    public JAXBElement<UserResourceSharingRequest> createUserResourceSharingRequest(UserResourceSharingRequest value) {
        return new JAXBElement<UserResourceSharingRequest>(_UserResourceSharingRequest_QNAME, UserResourceSharingRequest.class, null, value);
    }

}
