package org.gurpsdomain.xml2yml;

import org.gurpsdomain.xml2yml.modifier.Cost;
import org.gurpsdomain.xml2yml.modifier.CostType;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

@RunWith(Parameterized.class)
public class AdvantageUnmarshallingTest {

    @Parameterized.Parameters(name = "{0}")
    public static Collection<Object[]> data() {
        Collection<Object[]> data = new ArrayList<Object[]>();
        data.add(new Object[]{ "test-advantage.xml", new Advantage("360° Vision", 25, "B34", Arrays.asList(new Modifier[]{new Modifier("Easy to hit ", new Cost(CostType.percentage, -20)), new Modifier("Panoptic 1", new Cost(CostType.percentage, 20)), new Modifier("Panoptic 2", new Cost(CostType.percentage, 60))})) });
        data.add(new Object[]{ "test-advantage-with-levels.xml", new Advantage("Magery", 5, 10, "B66", Arrays.asList(new Modifier[]{new Modifier("Dance", new Cost(CostType.percentage, -40)), new Modifier("Dark-Aspected", new Cost(CostType.percentage, -50)), new Modifier("Day-Aspected", new Cost(CostType.percentage, -40)), new Modifier("Musical", new Cost(CostType.percentage, -50)), new Modifier("Night-Aspected", new Cost(CostType.percentage, -40)), new Modifier("One College", new Cost(CostType.percentage, -40)), new Modifier("Solitary", new Cost(CostType.percentage, -40)), new Modifier("Song", new Cost(CostType.percentage, -40))}))});

        return data;
    }

    private final String inputFile;
    private final Advantage expectedAdvantage;

    public AdvantageUnmarshallingTest(String fileName, Advantage expectedAdvantage) {
        this.inputFile = "src/test/resources/" + fileName;
        this.expectedAdvantage = expectedAdvantage;

    }

    @Test
    public void shouldSucceed() throws JAXBException, FileNotFoundException {
        JAXBContext context = JAXBContext.newInstance(Advantage.class);
        InputStream input = new FileInputStream(new File(inputFile));

        Advantage testAdvantage = (Advantage) context.createUnmarshaller().unmarshal(input);

        assertThat(testAdvantage, is(expectedAdvantage));
    }
}
