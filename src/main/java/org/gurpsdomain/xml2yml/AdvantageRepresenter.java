package org.gurpsdomain.xml2yml;

import org.yaml.snakeyaml.introspector.Property;
import org.yaml.snakeyaml.nodes.NodeTuple;
import org.yaml.snakeyaml.nodes.Tag;
import org.yaml.snakeyaml.representer.Representer;

public class AdvantageRepresenter extends Representer {
    public AdvantageRepresenter() {
        this.addClassTag(Advantages.class, Tag.MAP);
        this.addClassTag(Advantage.class, Tag.MAP);
    }

    @Override
    protected NodeTuple representJavaBeanProperty(Object javaBean, Property property, Object propertyValue, Tag customTag) {
        if (javaBean instanceof Advantage && ("pointsPerLevel".equals(property.getName()) || "modifiers".equals(property.getName())) && propertyValue == null) {
            return null;
        }
        return super.representJavaBeanProperty(javaBean, property, propertyValue, customTag);
    }
}
