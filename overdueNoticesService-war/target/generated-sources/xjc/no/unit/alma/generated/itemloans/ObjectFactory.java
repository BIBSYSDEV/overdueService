//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.3.0 
// See <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2021.01.04 at 01:21:50 PM CET 
//


package no.unit.alma.generated.itemloans;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the no.unit.alma.generated.itemloans package. 
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

    private final static QName _ItemLoan_QNAME = new QName("", "item_loan");
    private final static QName _ItemLoans_QNAME = new QName("", "item_loans");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: no.unit.alma.generated.itemloans
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link ItemLoan }
     * 
     */
    public ItemLoan createItemLoan() {
        return new ItemLoan();
    }

    /**
     * Create an instance of {@link ItemLoans }
     * 
     */
    public ItemLoans createItemLoans() {
        return new ItemLoans();
    }

    /**
     * Create an instance of {@link ItemLoan.CircDesk }
     * 
     */
    public ItemLoan.CircDesk createItemLoanCircDesk() {
        return new ItemLoan.CircDesk();
    }

    /**
     * Create an instance of {@link ItemLoan.Library }
     * 
     */
    public ItemLoan.Library createItemLoanLibrary() {
        return new ItemLoan.Library();
    }

    /**
     * Create an instance of {@link ItemLoan.LocationCode }
     * 
     */
    public ItemLoan.LocationCode createItemLoanLocationCode() {
        return new ItemLoan.LocationCode();
    }

    /**
     * Create an instance of {@link ItemLoan.ItemPolicy }
     * 
     */
    public ItemLoan.ItemPolicy createItemLoanItemPolicy() {
        return new ItemLoan.ItemPolicy();
    }

    /**
     * Create an instance of {@link ItemLoan.LastRenewStatus }
     * 
     */
    public ItemLoan.LastRenewStatus createItemLoanLastRenewStatus() {
        return new ItemLoan.LastRenewStatus();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ItemLoan }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ItemLoan }{@code >}
     */
    @XmlElementDecl(namespace = "", name = "item_loan")
    public JAXBElement<ItemLoan> createItemLoan(ItemLoan value) {
        return new JAXBElement<ItemLoan>(_ItemLoan_QNAME, ItemLoan.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ItemLoans }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ItemLoans }{@code >}
     */
    @XmlElementDecl(namespace = "", name = "item_loans")
    public JAXBElement<ItemLoans> createItemLoans(ItemLoans value) {
        return new JAXBElement<ItemLoans>(_ItemLoans_QNAME, ItemLoans.class, null, value);
    }

}