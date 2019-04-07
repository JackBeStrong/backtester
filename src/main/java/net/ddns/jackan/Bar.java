package net.ddns.jackan;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Bar {

    private Date dateTime;
    private double open;
    private double high;
    private double low;
    private double close;
    private DateFormat formate = new SimpleDateFormat("dd/MM/yyyy HH:mm");

    public Bar(Date dateTime, double open, double high, double low, double close) {
        this.dateTime = dateTime;
        this.open = open;
        this.high = high;
        this.low = low;
        this.close = close;
    }

    public Bar() {
    }

    public String toCsv() {
        String result = formate.format(dateTime) + "," + String.format("%.4f", open) + "," + String.format("%.4f",
                high) + "," + String.format("%.4f", low) + "," + String.format("%.4f", close);
        return result;
    }

    @Override
    public String toString() {
        return "Bar{" + "dateTime=" + dateTime + ", open=" + open + ", high=" + high + ", low=" + low + ", close=" + close + '}';
    }

    public Date getDateTime() {
        return dateTime;
    }

    public void setDateTime(Date dateTime) {
        this.dateTime = dateTime;
    }

    public double getOpen() {
        return open;
    }

    public void setOpen(double open) {
        this.open = open;
    }

    public double getHigh() {
        return high;
    }

    public void setHigh(double high) {
        this.high = high;
    }

    public double getLow() {
        return low;
    }

    public void setLow(double low) {
        this.low = low;
    }

    public double getClose() {
        return close;
    }

    public void setClose(double close) {
        this.close = close;
    }
}
