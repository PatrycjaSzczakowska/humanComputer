package generated;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for continentEnum.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="continentEnum">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Europe"/>
 *     &lt;enumeration value="Asia"/>
 *     &lt;enumeration value="North_America"/>
 *     &lt;enumeration value="South_America"/>
 *     &lt;enumeration value="Africa"/>
 *     &lt;enumeration value="Austalia_and_Oceania"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 */
@XmlType(name = "continentEnum", namespace = "http://www.przyklad.pl/showroom")
@XmlEnum
public enum ContinentEnum {

    @XmlEnumValue("Europe")
    EUROPE("Europe"),
    @XmlEnumValue("Asia")
    ASIA("Asia"),
    @XmlEnumValue("North_America")
    NORTH_AMERICA("North_America"),
    @XmlEnumValue("South_America")
    SOUTH_AMERICA("South_America"),
    @XmlEnumValue("Africa")
    AFRICA("Africa"),
    @XmlEnumValue("Austalia_and_Oceania")
    AUSTALIA_AND_OCEANIA("Austalia_and_Oceania");
    private final String value;

    ContinentEnum(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static ContinentEnum fromValue(String v) {
        for (ContinentEnum c : ContinentEnum.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
