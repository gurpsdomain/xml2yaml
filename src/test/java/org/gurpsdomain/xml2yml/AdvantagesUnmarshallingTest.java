package org.gurpsdomain.xml2yml;

import org.gurpsdomain.xml2yml.modifier.Cost;
import org.gurpsdomain.xml2yml.modifier.CostType;
import org.junit.Test;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Arrays;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class AdvantagesUnmarshallingTest {
    private static final String INPUT_FILE = "src/test/resources/test-advantages.xml";

    @Test
    public void shouldSucceed() throws JAXBException, FileNotFoundException {
        JAXBContext context = JAXBContext.newInstance(Advantages.class);
        InputStream input = new FileInputStream(new File(INPUT_FILE));

        Advantages testAdvantages = (Advantages) context.createUnmarshaller().unmarshal(input);

        assertThat(testAdvantages, is(new Advantages(
                new Advantage("360° Vision", 25, "B34", Arrays.asList(new Modifier[]{new Modifier("Easy to hit ", new Cost(CostType.percentage, -20)), new Modifier("Panoptic 1", new Cost(CostType.percentage, 20)), new Modifier("Panoptic 2", new Cost(CostType.percentage, 60))})),
                new Advantage("Absent-Mindedness", -15, "B122"),
                new Advantage("Absolute Direction", 5, "B34", Arrays.asList(new Modifier[]{new Modifier("Requires signal", new Cost(CostType.percentage, -20)), new Modifier("3D Spatial Sense", new Cost(CostType.points, 5))}))

        )));

    }
}
