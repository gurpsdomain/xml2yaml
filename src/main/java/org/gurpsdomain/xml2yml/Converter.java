package org.gurpsdomain.xml2yml;

import org.yaml.snakeyaml.DumperOptions;
import org.yaml.snakeyaml.Yaml;
import org.yaml.snakeyaml.nodes.Tag;
import org.yaml.snakeyaml.representer.Representer;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import java.io.*;

public class Converter {
    private static final int WRONG_ARGUMENT = 1;
    private static final int NOT_READABLE_FILE = 2;
    private static final int NO_JAXB_CONTEXT = 4;

    public static void main(String[] args) {
        if (args.length != 1) {
            System.err.println("I need exactly one file argument");
            System.exit(WRONG_ARGUMENT);
        }

        File input = new File(args[0]);
        if (!input.exists() || !input.isFile() || !input.canRead()) {
            System.err.println("I need a readable file");
            System.exit(NOT_READABLE_FILE);
        }

        Converter converter = new Converter(input);
        try {
            converter.convert();
        } catch (JAXBException e) {
            System.err.println("Can not initialize JAXB context");
            System.exit(NO_JAXB_CONTEXT);
        } catch (FileNotFoundException e) {
            /* this should not occur */
            System.err.println("I need a readable file");
            System.exit(NOT_READABLE_FILE);
        }
    }

    private final File input;

    public Converter(File input) {
        this.input = input;
    }


    private void convert() throws JAXBException, FileNotFoundException {
        JAXBContext context = JAXBContext.newInstance(Advantages.class);
        InputStream inputStream = new FileInputStream(input);

        Advantages advantages = (Advantages) context.createUnmarshaller().unmarshal(inputStream);

        Representer representer = new AdvantageRepresenter();
        Yaml yaml = new Yaml(representer, new DumperOptions());

        Writer writer = new OutputStreamWriter(System.out);
        yaml.dump(advantages, writer);
    }

}
