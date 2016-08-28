package org.gurpsdomain.xml2yml;

import org.yaml.snakeyaml.nodes.Tag;
import org.yaml.snakeyaml.representer.Representer;

public class AdvantageRepresenter extends Representer {
    public AdvantageRepresenter() {
        this.addClassTag(Advantages.class, new Tag("!advantages"));
        this.addClassTag(Advantage.class, new Tag("!advantage"));
    }
}
