package org.gurpsdomain.tools;

import org.junit.Test;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import java.io.*;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class JaxbTest {

    public static final String INPUT_FILE = "src/test/resources/test-object.xml";

    @Test
    public void shouldUnmarshallADocument() throws JAXBException, IOException {
        JAXBContext context = JAXBContext.newInstance(TestObject.class);
        InputStream input = new FileInputStream(new File(INPUT_FILE));

        TestObject testObject = (TestObject) context.createUnmarshaller().unmarshal(input);

        assertThat(testObject, is(new TestObject(37)));
    }

    private void createTestObjectXml() throws JAXBException, IOException {
        OutputStream output = new FileOutputStream(new File(INPUT_FILE));
        JAXBContext context = JAXBContext.newInstance(TestObject.class);
        context.createMarshaller().marshal(new TestObject(51), output);
        output.flush();
        output.close();
    }
}

@XmlRootElement
class TestObject {
    @XmlElement
    private int number;

    private TestObject() {

    }

    public TestObject(int number) {
        this.number = number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TestObject that = (TestObject) o;

        return number == that.number;

    }

    @Override
    public int hashCode() {
        return number;
    }

    @Override
    public String toString() {
        return "TestObject{" +
                "number=" + number +
                '}';
    }
}