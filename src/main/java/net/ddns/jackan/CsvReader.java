package net.ddns.jackan;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class CsvReader {

    private final Logger logger = LoggerFactory.getLogger(CsvReader.class);

    private String csvFile;
    private BufferedReader br;
    private String line;
    private String csvpliteBy = ",";
    private SimpleDateFormat format1 = new SimpleDateFormat("dd/MM/yyyy HH:mm");
    private SimpleDateFormat format2 = new SimpleDateFormat("dd/MM/yyyy");

    public CsvReader(String file) {
        csvFile = file;
    }

    public List<Bar> readBars() {
        ArrayList<Bar> bars = new ArrayList<Bar>();
        try {
            br = new BufferedReader(new FileReader(csvFile));
            logger.debug("Buffered reader created with file: {}", csvFile);
            while ((line = br.readLine()) != null) {
                String[] aRow = line.split(csvpliteBy);
                try {
                    bars.add(new Bar(format1.parse(aRow[0]), Double.parseDouble(aRow[1]), Double.parseDouble(aRow[2])
                            , Double.parseDouble(aRow[3]), Double.parseDouble(aRow[4])));
                } catch (ParseException e) {
                    logger.warn("Datetime format not correct. Trying with dd/MM/yyyy with: {},{},{},{},{}", aRow[0], aRow[1],
                            aRow[2], aRow[3], aRow[4]);
                    try {
                        bars.add(new Bar(format2.parse(aRow[0]), Double.parseDouble(aRow[1]),
                                Double.parseDouble(aRow[2]), Double.parseDouble(aRow[3]), Double.parseDouble(aRow[4])));
                    } catch (ParseException e1) {
                        logger.error("Datetime format cannot be parsed: {}", aRow[0]);
                        e1.printStackTrace();
                    }
                }
            }
        } catch (FileNotFoundException e) {
            logger.error("Source file not found: {}", csvFile);
            e.printStackTrace();
        } catch (IOException e) {
            logger.error("Unknown error occurred");
            e.printStackTrace();
        } finally {
            logger.debug("Trying to close buffer reader.");
            if (br != null) {
                try {
                    br.close();
                    logger.debug("Buffer reader closed successfully.");
                } catch (IOException e) {
                    logger.error("Failed to close buffer reader.");
                    e.printStackTrace();
                }
            }
        }
        return bars;
    }
}
