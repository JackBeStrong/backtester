package net.ddns.jackan.util;

import net.ddns.jackan.Bar;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;
import java.util.Random;

public class SampleDataGenerate {

    private static final Logger logger = LoggerFactory.getLogger(SampleDataGenerate.class);

    public static int BAR_NO = 10000;
    public static Date START_DATE = new Date(2018 - 1900, 01, 01);
    public static Bar initialBar = new Bar(START_DATE, 0.7443, 0.7443, 0.7437, 0.7437);
    public static String fileLocation = "src/main/resources/testData/sampleData.csv";

    private static Random random = new Random();
    private static double DELTA = 0.0001;
    private static int TIME_DELTA = 60 * 1000;

    public static void main(String[] args) {
        logger.info("Generating {} sample price data. File location: {}", BAR_NO, fileLocation);
        try {
            BufferedWriter br = new BufferedWriter(new FileWriter(fileLocation));

            for (int i = 0; i < BAR_NO; i++) {
                String barCsv = initialBar.toCsv();
                br.write(barCsv + "\n");
                logger.debug("Bar: {} generated", barCsv);
                initialBar = randomBar(initialBar);
            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        logger.info("File: {} generated.", fileLocation);
    }

    private static Bar randomBar(Bar previousBar) {

        long time = previousBar.getDateTime().getTime() + TIME_DELTA;
        double open = previousBar.getOpen() + (random.nextGaussian() / 10000);
        double high = previousBar.getHigh() + (random.nextGaussian() / 10000);
        double low = previousBar.getLow() + (random.nextGaussian() / 10000);
        double close = previousBar.getClose() + (random.nextGaussian() / 10000);

        while (high <= open || high <= low || high <= close) {
            high += DELTA;
        }
        while (low >= open || low >= close || low >= high) {
            low -= DELTA;
        }

        return new Bar(new Date(time), open, high, low, close);
    }
}
