
package Showroom;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="brands" type="{http://www.przyklad.pl/showroom}brands"/>
 *         &lt;element name="cars" type="{http://www.przyklad.pl/showroom}cars"/>
 *         &lt;element name="metadata" type="{http://www.przyklad.pl/showroom}metadata"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "brands",
    "cars",
    "metadata"
})
@XmlRootElement(name = "carShowroom", namespace = "http://www.przyklad.pl/showroom")
public class CarShowroom {

    @XmlElement(required = true)
    protected Brands brands;
    @XmlElement(required = true)
    protected Cars cars;
    @XmlElement(required = true)
    protected Metadata metadata;

    /**
     * Gets the value of the brands property.
     * 
     * @return
     *     possible object is
     *     {@link Brands }
     *     
     */
    public Brands getBrands() {
        return brands;
    }

    /**
     * Sets the value of the brands property.
     * 
     * @param value
     *     allowed object is
     *     {@link Brands }
     *     
     */
    public void setBrands(Brands value) {
        this.brands = value;
    }

    /**
     * Gets the value of the cars property.
     * 
     * @return
     *     possible object is
     *     {@link Cars }
     *     
     */
    public Cars getCars() {
        return cars;
    }

    /**
     * Sets the value of the cars property.
     * 
     * @param value
     *     allowed object is
     *     {@link Cars }
     *     
     */
    public void setCars(Cars value) {
        this.cars = value;
    }

    /**
     * Gets the value of the metadata property.
     * 
     * @return
     *     possible object is
     *     {@link Metadata }
     *     
     */
    public Metadata getMetadata() {
        return metadata;
    }

    /**
     * Sets the value of the metadata property.
     * 
     * @param value
     *     allowed object is
     *     {@link Metadata }
     *     
     */
    public void setMetadata(Metadata value) {
        this.metadata = value;
    }

}
