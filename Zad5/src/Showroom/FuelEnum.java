
package Showroom;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for fuelEnum.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="fuelEnum">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}normalizedString">
 *     &lt;enumeration value="Diesel"/>
 *     &lt;enumeration value="Petrol"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "fuelEnum", namespace = "http://www.przyklad.pl/showroom")
@XmlEnum
public enum FuelEnum {

    @XmlEnumValue("Diesel")
    DIESEL("Diesel"),
    @XmlEnumValue("Petrol")
    PETROL("Petrol");
    private final String value;

    FuelEnum(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static FuelEnum fromValue(String v) {
        for (FuelEnum c: FuelEnum.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
