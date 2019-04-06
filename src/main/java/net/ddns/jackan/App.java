package net.ddns.jackan;

public class App {

    public static void main(String[] args) {
        CsvReader reader = new CsvReader("src/main/resources/testData/SampleDataAUDUSD20161203.csv");
        for(Bar bar: reader.readBars()){
            System.out.println(bar);
        }
    }

}
