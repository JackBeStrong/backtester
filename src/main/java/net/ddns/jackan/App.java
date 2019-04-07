package net.ddns.jackan;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class App {

    private static final Logger logger = LoggerFactory.getLogger(App.class);

    public final static String fileLocation = "src/main/resources/testData/SampleData.csv";


    public static void main(String[] args) {

        logger.debug("App started");

        CsvReader reader = new CsvReader(fileLocation);
        logger.debug("Data source file loaded: {}", fileLocation);
        for(Bar bar: reader.readBars()){
            System.out.println(bar);
        }
    }

}
