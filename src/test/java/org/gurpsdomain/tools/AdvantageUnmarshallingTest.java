package org.gurpsdomain.tools;

import org.gurpsdomain.xml2yml.Advantage;
import org.junit.Test;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class AdvantageUnmarshallingTest {
    private static final String INPUT_FILE = "src/test/resources/test-advantage.xml";

    @Test
    public void shouldSucceed() throws JAXBException, FileNotFoundException {
        JAXBContext context = JAXBContext.newInstance(Advantage.class);
        InputStream input = new FileInputStream(new File(INPUT_FILE));

        Advantage testAdvantage = (Advantage) context.createUnmarshaller().unmarshal(input);

        assertThat(testAdvantage, is(new Advantage("360° Vision", 25, "B34")));

    }
}
