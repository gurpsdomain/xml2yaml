package org.gurpsdomain.xml2yml;

import org.gurpsdomain.xml2yml.modifier.Cost;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Modifier {
    @XmlElement(name = "name")
    private String name;
    @XmlElement(name = "cost", required=false)
    private Cost cost;

    public Modifier() {}

    public Modifier(String name) {
        this.name = name;
        this.cost = null;
    }

    public Modifier(String name, Cost cost) {
        this.name = name;
        this.cost = cost;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Cost getCost() {
        return cost;
    }

    public void setCost(Cost cost) {
        this.cost = cost;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Modifier)) return false;

        Modifier modifier = (Modifier) o;

        if (cost != null ? !cost.equals(modifier.cost) : modifier.cost != null) return false;
        if (name != null ? !name.equals(modifier.name) : modifier.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (cost != null ? cost.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Modifier{" +
                "name='" + name + '\'' +
                ", cost=" + cost +
                '}';
    }
}
