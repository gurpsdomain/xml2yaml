package org.gurpsdomain.xml2yml;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;


@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Advantage {
    private String name;
    @XmlElement(name = "base_points")
    private int basePoints;
    @XmlElement(name = "points_per_level", required=false)
    private Integer pointsPerLevel;
    private String reference;
    @XmlElement(name = "modifier", required=false)
    private List<Modifier> modifiers;

    public Advantage() {
        /* Needed for Jaxb */
    }

    public Advantage(String name, int basePoints, String reference) {
        this(name, basePoints, null, reference);
    }

    public Advantage(String name, int basePoints, Integer pointsPerLevel, String reference) {
        this(name, basePoints, pointsPerLevel, reference, null);
    }

    public Advantage(String name, int basePoints, String reference, List<Modifier> modifiers) {
        this(name, basePoints, null, reference, modifiers);
    }

    public Advantage(String name, int basePoints, Integer pointsPerLevel, String reference, List<Modifier> modifiers) {
        this.name = name;
        this.basePoints = basePoints;
        this.pointsPerLevel = pointsPerLevel;
        this.reference = reference;
        this.modifiers = modifiers;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBasePoints() {
        return basePoints;
    }

    public void setBasePoints(int basePoints) {
        this.basePoints = basePoints;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public void setPointsPerLevel(Integer pointsPerLevel) {
        this.pointsPerLevel = pointsPerLevel;
    }

    public Integer getPointsPerLevel() {
        return pointsPerLevel;
    }

    public void setModifiers(List<Modifier> modifiers) {
        this.modifiers = modifiers;
    }

    public List<Modifier> getModifiers() {
        return modifiers;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        if(modifiers != null) {
            modifiers.forEach(modifier -> sb.append(modifier));
        }
        return "Advantage{" +
                "name='" + name + '\'' +
                ", basePoints=" + basePoints +
                ", reference='" + reference + '\'' +
                ", modifiers='" + sb.toString() + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Advantage)) return false;

        Advantage advantage = (Advantage) o;

        if (basePoints != advantage.basePoints) return false;
        if (modifiers != null ? !modifiers.equals(advantage.modifiers) : advantage.modifiers != null) return false;
        if (name != null ? !name.equals(advantage.name) : advantage.name != null) return false;
        if (pointsPerLevel != null ? !pointsPerLevel.equals(advantage.pointsPerLevel) : advantage.pointsPerLevel != null)
            return false;
        if (reference != null ? !reference.equals(advantage.reference) : advantage.reference != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + basePoints;
        result = 31 * result + (pointsPerLevel != null ? pointsPerLevel.hashCode() : 0);
        result = 31 * result + (reference != null ? reference.hashCode() : 0);
        result = 31 * result + (modifiers != null ? modifiers.hashCode() : 0);
        return result;
    }
}
