package net.ddns.jackan.calculation;

import net.ddns.jackan.Bar;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class BarsCal {

    private final static Logger logger = LoggerFactory.getLogger(BarsCal.class);

    // calculate sum for open, high, low, close for an array of bars
    public static double sumOpen(List<Bar> bars) {
        double sumOpen = 0;
        for (Bar bar : bars) {
            sumOpen += bar.getOpen();
        }
        return sumOpen;
    }

    public static double sumHigh(List<Bar> bars) {
        double sumHigh = 0;
        for (Bar bar : bars) {
            sumHigh += bar.getHigh();
        }
        return sumHigh;
    }

    public static double sumLow(List<Bar> bars) {
        double sumLow = 0;
        for (Bar bar : bars) {
            sumLow += bar.getLow();
        }
        return sumLow;
    }

    public static double sumClose(List<Bar> bars) {
        double sumClose = 0;
        for (Bar bar : bars) {
            sumClose += bar.getClose();
        }
        return sumClose;
    }

    // calculate average for open, high, low, close for an array of bars
    public static double meanOpen(List<Bar> bars) {

        return sumOpen(bars) / bars.size();
    }
    public static double meanHigh(List<Bar> bars) {

        return sumHigh(bars) / bars.size();
    }
    public static double meanLow(List<Bar> bars) {

        return sumLow(bars) / bars.size();
    }
    public static double meanClose(List<Bar> bars) {

        return sumClose(bars) / bars.size();
    }
}
