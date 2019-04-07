package net.ddns.jackan.strategy;

import net.ddns.jackan.Bar;
import net.ddns.jackan.calculation.BarsCal;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.LinkedList;

public class MovingAverageStrategy extends Strategy {
    private final Logger logger = LoggerFactory.getLogger(MovingAverageStrategy.class);
    private final int MOVINGAVERAGEBARS = 10;

    private LinkedList<Bar> bars = new LinkedList<Bar>();
    private double movingAverage;


    public void nextBar(Bar currentBar) {
        if (bars.size() < MOVINGAVERAGEBARS) {
            bars.add(currentBar);
        }
        else {
            bars.removeLast();
            bars.add(currentBar);
        }
        calculateIndicators();

    }

    public void calculateIndicators() {
        calculateMovingAverage();
    }

    private void calculateMovingAverage() {
        movingAverage = BarsCal.meanClose(bars);
    }
}
