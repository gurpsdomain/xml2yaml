package org.gurpsdomain.xml2yml;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

import static java.util.Arrays.asList;

@XmlRootElement(name = "advantage_list")
@XmlAccessorType(XmlAccessType.FIELD)
public class Advantages {
    @XmlElement(name="advantage")
    List<Advantage> advantages = new ArrayList<Advantage>();

    public Advantages() {

    }

    public Advantages(Advantage... advantages) {
        this.advantages.addAll(asList(advantages));
    }

    public List<Advantage> getAdvantages() {
        return advantages;
    }

    public void setAdvantages(List<Advantage> advantages) {
        this.advantages = advantages;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Advantages that = (Advantages) o;

        return advantages.equals(that.advantages);

    }

    @Override
    public int hashCode() {
        return advantages.hashCode();
    }

    @Override
    public String toString() {
        return "Advantages{" +
                "advantages=" + advantages +
                '}';
    }
}
