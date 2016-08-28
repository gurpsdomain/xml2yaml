package org.gurpsdomain.xml2yml;

import org.junit.Before;
import org.junit.Test;
import org.yaml.snakeyaml.DumperOptions;
import org.yaml.snakeyaml.Yaml;
import org.yaml.snakeyaml.nodes.Tag;
import org.yaml.snakeyaml.representer.Representer;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.stream.Collectors;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class AdvantageMarshallingTest {
    private static final File EXPECTED_YML = new File("src/test/resources/test-advantage.yml");
    private String expectedResult;

    @Before
    public void readExpectedResult() throws FileNotFoundException {
        BufferedReader ymlReader = new BufferedReader(new FileReader(EXPECTED_YML));
        expectedResult = ymlReader.lines().collect(Collectors.joining("\n")) + "\n";
    }

    @Test
    public void shouldSucceed() {
        Representer representer = new AdvantageRepresenter();
        Yaml yaml = new Yaml(representer, new DumperOptions());
        Advantage advantage = new Advantage("360° Vision", 25, "B34");

        String result = yaml.dump(advantage);

        assertThat(result, is(expectedResult));
    }
}
