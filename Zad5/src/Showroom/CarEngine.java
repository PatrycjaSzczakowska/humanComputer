
package Showroom;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for carEngine complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="carEngine">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="cylindersNumber" type="{http://www.w3.org/2001/XMLSchema}byte"/>
 *         &lt;element name="capacity" type="{http://www.przyklad.pl/showroom}carEngineCapacity"/>
 *         &lt;element name="power" type="{http://www.przyklad.pl/showroom}carEnginePower"/>
 *       &lt;/sequence>
 *       &lt;attribute name="fuel" type="{http://www.przyklad.pl/showroom}fuelEnum" default="Diesel" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "carEngine", namespace = "http://www.przyklad.pl/showroom", propOrder = {
    "cylindersNumber",
    "capacity",
    "power"
})
public class CarEngine {

    protected byte cylindersNumber;
    @XmlElement(required = true)
    protected CarEngineCapacity capacity;
    @XmlElement(required = true)
    protected CarEnginePower power;
    @XmlAttribute(name = "fuel")
    protected FuelEnum fuel;

    /**
     * Gets the value of the cylindersNumber property.
     * 
     */
    public byte getCylindersNumber() {
        return cylindersNumber;
    }

    /**
     * Sets the value of the cylindersNumber property.
     * 
     */
    public void setCylindersNumber(byte value) {
        this.cylindersNumber = value;
    }

    /**
     * Gets the value of the capacity property.
     * 
     * @return
     *     possible object is
     *     {@link CarEngineCapacity }
     *     
     */
    public CarEngineCapacity getCapacity() {
        return capacity;
    }

    /**
     * Sets the value of the capacity property.
     * 
     * @param value
     *     allowed object is
     *     {@link CarEngineCapacity }
     *     
     */
    public void setCapacity(CarEngineCapacity value) {
        this.capacity = value;
    }

    /**
     * Gets the value of the power property.
     * 
     * @return
     *     possible object is
     *     {@link CarEnginePower }
     *     
     */
    public CarEnginePower getPower() {
        return power;
    }

    /**
     * Sets the value of the power property.
     * 
     * @param value
     *     allowed object is
     *     {@link CarEnginePower }
     *     
     */
    public void setPower(CarEnginePower value) {
        this.power = value;
    }

    /**
     * Gets the value of the fuel property.
     * 
     * @return
     *     possible object is
     *     {@link FuelEnum }
     *     
     */
    public FuelEnum getFuel() {
        if (fuel == null) {
            return FuelEnum.DIESEL;
        } else {
            return fuel;
        }
    }

    /**
     * Sets the value of the fuel property.
     * 
     * @param value
     *     allowed object is
     *     {@link FuelEnum }
     *     
     */
    public void setFuel(FuelEnum value) {
        this.fuel = value;
    }

}
