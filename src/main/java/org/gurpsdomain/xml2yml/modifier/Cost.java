package org.gurpsdomain.xml2yml.modifier;

import javax.xml.bind.annotation.*;

/**
 * Created with IntelliJ IDEA.
 * User: robinvankaathoven1
 * Date: 08-11-16
 * Time: 20:30
 * To change this template use File | Settings | File Templates.
 */


@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Cost {
    @XmlAttribute(name = "type")
    CostType type;

    @XmlValue
    int value;

    public Cost() {}

    public Cost(CostType type, int value) {
        this.type = type;
        this.value = value;
    }

    public CostType getType() {
        return type;
    }

    public void setType(CostType type) {
        this.type = type;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Cost)) return false;

        Cost cost = (Cost) o;

        if (value != cost.value) return false;
        if (type != cost.type) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = type != null ? type.hashCode() : 0;
        result = 31 * result + value;
        return result;
    }

    @Override
    public String toString() {
        return "Cost{" +
                "type=" + type +
                ", value=" + value +
                '}';
    }
}
