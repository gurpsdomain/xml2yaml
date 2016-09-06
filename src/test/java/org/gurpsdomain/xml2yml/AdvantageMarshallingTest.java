package org.gurpsdomain.xml2yml;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.yaml.snakeyaml.DumperOptions;
import org.yaml.snakeyaml.Yaml;
import org.yaml.snakeyaml.representer.Representer;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

@RunWith(Parameterized.class)
public class AdvantageMarshallingTest {
    @Parameterized.Parameters(name = "{0}")
    public static Collection<Object[]> data() {
        Collection<Object[]> data = new ArrayList<>();
        data.add(new Object[]{ "test-advantage.yml", new Advantage("360° Vision", 25, "B34", Arrays.asList(new Modifier[]{ new Modifier("Easy to hit "), new Modifier("Panoptic 1"), new Modifier("Panoptic 2")}))});
        data.add(new Object[]{ "test-advantage-with-levels.yml", new Advantage("Magery", 5, 10, "B66") });
        return data;
    }

    private final File expectedYml;
    private final Advantage advantage;
    private String expectedResult;

    public AdvantageMarshallingTest(String fileName, Advantage advantage) {
        this.expectedYml = new File("src/test/resources/" + fileName);
        this.advantage = advantage;

    }

    @Before
    public void readExpectedResult() throws FileNotFoundException {
        BufferedReader ymlReader = new BufferedReader(new FileReader(expectedYml));
        expectedResult = ymlReader.lines().collect(Collectors.joining("\n")) + "\n";
    }

    @Test
    public void shouldSucceed() {
        Representer representer = new AdvantageRepresenter();
        Yaml yaml = new Yaml(representer, new DumperOptions());

        String result = yaml.dump(advantage);

        assertThat(result, is(expectedResult));
    }
}
