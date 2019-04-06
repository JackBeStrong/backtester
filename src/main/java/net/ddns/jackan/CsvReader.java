package net.ddns.jackan;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class CsvReader {

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
            while ((line = br.readLine()) != null) {
                String[] aRow = line.split(csvpliteBy);
                try {
                    bars.add(new Bar(format1.parse(aRow[0]), Double.parseDouble(aRow[1]), Double.parseDouble(aRow[2])
                            , Double.parseDouble(aRow[3]), Double.parseDouble(aRow[4])));
                } catch (ParseException e) {
                    try {
                        bars.add(new Bar(format2.parse(aRow[0]), Double.parseDouble(aRow[1]),
                                Double.parseDouble(aRow[2]), Double.parseDouble(aRow[3]), Double.parseDouble(aRow[4])));
                    } catch (ParseException e1) {
                        e1.printStackTrace();
                    }
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return bars;
    }
}
