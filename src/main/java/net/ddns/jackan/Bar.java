package net.ddns.jackan;

import java.util.Date;

public class Bar {

    private Date dateTime;
    private double open;
    private double close;
    private double high;
    private double low;

    public Bar(Date dateTime, double open, double high, double low, double close) {
        this.dateTime = dateTime;
        this.open = open;
        this.close = close;
        this.high = high;
        this.low = low;
    }

    public Bar() {
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

    public double getClose() {
        return close;
    }

    public void setClose(double close) {
        this.close = close;
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

    @Override
    public String toString() {
        return "Bar{" + "dateTime=" + dateTime + ", open=" + open + ", close=" + close + ", high=" + high + ", low=" + low + '}';
    }
}
