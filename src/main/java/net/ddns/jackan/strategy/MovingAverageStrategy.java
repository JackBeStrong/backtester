package net.ddns.jackan.strategy;

import net.ddns.jackan.Bar;
import net.ddns.jackan.calculation.BarsCal;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.LinkedList;

public class MovingAverageStrategy extends Strategy {

    public double INITIAL_HOLDING_A = 0;
    public double INITIAL_HOLDING_B = 0;
    public double balance = 5000;

    private final Logger logger = LoggerFactory.getLogger(MovingAverageStrategy.class);
    private final int MOVINGAVERAGEBARS = 10;

    private LinkedList<Bar> bars = new LinkedList<Bar>();
    private double movingAverage = 0;
    private boolean aboveLine = false;


    public void nextBar(Bar currentBar) {
        if (bars.size() < MOVINGAVERAGEBARS) {
            bars.add(currentBar);
        }
        else {
            bars.removeLast();
            bars.add(currentBar);
        }
        calculateIndicators();
        if (aboveLine && movingAverage < currentBar.getClose()){
            entry(currentBar);
            aboveLine = false;
        }
        if (!aboveLine && movingAverage >= currentBar.getClose()){
            entry(currentBar);
            aboveLine = true;
        }
    }

    public void calculateIndicators() {
        calculateMovingAverage();
    }

    private void calculateMovingAverage() {
        movingAverage = BarsCal.meanClose(bars);
    }

    public void entry(Bar currentBar) {
        if(aboveLine){

        }
    }
}
