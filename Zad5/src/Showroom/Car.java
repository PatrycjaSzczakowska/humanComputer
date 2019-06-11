
package Showroom;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.NormalizedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


/**
 * <p>Java class for car complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="car">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="model" type="{http://www.przyklad.pl/showroom}carModel"/>
 *         &lt;element name="type" type="{http://www.przyklad.pl/showroom}carType"/>
 *         &lt;element name="production" type="{http://www.przyklad.pl/showroom}carProduction" maxOccurs="unbounded"/>
 *         &lt;element name="engine" type="{http://www.przyklad.pl/showroom}carEngine"/>
 *         &lt;element name="wheeldrive" type="{http://www.przyklad.pl/showroom}carWheeldrive"/>
 *         &lt;element name="condition" type="{http://www.przyklad.pl/showroom}carCondition"/>
 *         &lt;element name="lacquer" type="{http://www.w3.org/2001/XMLSchema}normalizedString" minOccurs="0"/>
 *         &lt;element name="price" type="{http://www.przyklad.pl/showroom}carPrice"/>
 *       &lt;/sequence>
 *       &lt;attribute name="id" use="required" type="{http://www.w3.org/2001/XMLSchema}normalizedString" />
 *       &lt;attribute name="brandId" use="required" type="{http://www.w3.org/2001/XMLSchema}normalizedString" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "car", namespace = "http://www.przyklad.pl/showroom", propOrder = {
    "model",
    "type",
    "production",
    "engine",
    "wheeldrive",
    "condition",
    "lacquer",
    "price"
})
public class Car {

    @XmlElement(required = true)
    protected CarModel model;
    @XmlElement(required = true)
    protected CarType type;
    @XmlElement(required = true)
    protected List<CarProduction> production;
    @XmlElement(required = true)
    protected CarEngine engine;
    @XmlElement(required = true)
    protected CarWheeldrive wheeldrive;
    @XmlElement(required = true)
    protected CarCondition condition;
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    @XmlSchemaType(name = "normalizedString")
    protected String lacquer;
    @XmlElement(required = true)
    protected CarPrice price;
    @XmlAttribute(name = "id", required = true)
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    @XmlSchemaType(name = "normalizedString")
    protected String id;
    @XmlAttribute(name = "brandId", required = true)
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    @XmlSchemaType(name = "normalizedString")
    protected String brandId;

    /**
     * Gets the value of the model property.
     * 
     * @return
     *     possible object is
     *     {@link CarModel }
     *     
     */
    public CarModel getModel() {
        return model;
    }

    /**
     * Sets the value of the model property.
     * 
     * @param value
     *     allowed object is
     *     {@link CarModel }
     *     
     */
    public void setModel(CarModel value) {
        this.model = value;
    }

    /**
     * Gets the value of the type property.
     * 
     * @return
     *     possible object is
     *     {@link CarType }
     *     
     */
    public CarType getType() {
        return type;
    }

    /**
     * Sets the value of the type property.
     * 
     * @param value
     *     allowed object is
     *     {@link CarType }
     *     
     */
    public void setType(CarType value) {
        this.type = value;
    }

    /**
     * Gets the value of the production property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the production property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getProduction().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CarProduction }
     * 
     * 
     */
    public List<CarProduction> getProduction() {
        if (production == null) {
            production = new ArrayList<CarProduction>();
        }
        return this.production;
    }

    /**
     * Gets the value of the engine property.
     * 
     * @return
     *     possible object is
     *     {@link CarEngine }
     *     
     */
    public CarEngine getEngine() {
        return engine;
    }

    /**
     * Sets the value of the engine property.
     * 
     * @param value
     *     allowed object is
     *     {@link CarEngine }
     *     
     */
    public void setEngine(CarEngine value) {
        this.engine = value;
    }

    /**
     * Gets the value of the wheeldrive property.
     * 
     * @return
     *     possible object is
     *     {@link CarWheeldrive }
     *     
     */
    public CarWheeldrive getWheeldrive() {
        return wheeldrive;
    }

    /**
     * Sets the value of the wheeldrive property.
     * 
     * @param value
     *     allowed object is
     *     {@link CarWheeldrive }
     *     
     */
    public void setWheeldrive(CarWheeldrive value) {
        this.wheeldrive = value;
    }

    /**
     * Gets the value of the condition property.
     * 
     * @return
     *     possible object is
     *     {@link CarCondition }
     *     
     */
    public CarCondition getCondition() {
        return condition;
    }

    /**
     * Sets the value of the condition property.
     * 
     * @param value
     *     allowed object is
     *     {@link CarCondition }
     *     
     */
    public void setCondition(CarCondition value) {
        this.condition = value;
    }

    /**
     * Gets the value of the lacquer property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLacquer() {
        return lacquer;
    }

    /**
     * Sets the value of the lacquer property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLacquer(String value) {
        this.lacquer = value;
    }

    /**
     * Gets the value of the price property.
     * 
     * @return
     *     possible object is
     *     {@link CarPrice }
     *     
     */
    public CarPrice getPrice() {
        return price;
    }

    /**
     * Sets the value of the price property.
     * 
     * @param value
     *     allowed object is
     *     {@link CarPrice }
     *     
     */
    public void setPrice(CarPrice value) {
        this.price = value;
    }

    /**
     * Gets the value of the id property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getId() {
        return id;
    }

    /**
     * Sets the value of the id property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setId(String value) {
        this.id = value;
    }

    /**
     * Gets the value of the brandId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBrandId() {
        return brandId;
    }

    /**
     * Sets the value of the brandId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBrandId(String value) {
        this.brandId = value;
    }

}
