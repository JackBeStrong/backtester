package net.ddns.jackan.handler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TradeAgent {

    private final Logger logger = LoggerFactory.getLogger(TradeAgent.class);

    // A: USD
    // B: AUD
    private double holdingA; //5000
    private double holdingB; //5000
    private double balanceInA; // 1.2 * 5000
    private double balanceInB; // 0.83 * 5000
    private double priceOneAEqualsXB; // 1.2
    private double priceOneBEqualsXA; // 0.83

    public TradeAgent() {

    }

    public TradeAgent(double priceOneAEqualsXB) {
        this.priceOneAEqualsXB = priceOneAEqualsXB;
        priceOneBEqualsXA = 1 / priceOneAEqualsXB;
    }

    public void buyA(int volumn) {

        /* To do */
        if (checkAgentStatus()){
            holdingA += volumn;
            balanceInA = holdingA * balanceInA;
            balanceInB -= priceOneAEqualsXB * volumn;
//            holdingB = balanceInB /
        }
    }

    private boolean checkAgentStatus(){
        if (priceOneBEqualsXA == 0 || priceOneAEqualsXB == 0) {
            logger.error("Trading agent: price not set");
            return false;
        }
        if (balanceInA <= 0) {
            logger.error("Not enough fund in A, current balance: {}", balanceInA);
            return false;
        }
        if (balanceInB <= 0) {
            logger.error("Not enough fund in B, current balance: {}", balanceInB);
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "TradeAgent{" + "holdingA=" + holdingA + ", holdingB=" + holdingB + ", balanceInA=" + balanceInA + ", "
                + "balanceInB=" + balanceInB + ", priceOneAEqualsXB=" + priceOneAEqualsXB + ", priceOneBEqualsXA=" + priceOneBEqualsXA + '}';
    }

    public Logger getLogger() {
        return logger;
    }

    public double getHoldingA() {
        return holdingA;
    }

    public void setHoldingA(double holdingA) {
        this.holdingA = holdingA;
    }

    public double getHoldingB() {
        return holdingB;
    }

    public void setHoldingB(double holdingB) {
        this.holdingB = holdingB;
    }

    public double getBalanceInA() {
        return balanceInA;
    }

    public void setBalanceInA(double balanceInA) {
        this.balanceInA = balanceInA;
    }

    public double getBalanceInB() {
        return balanceInB;
    }

    public void setBalanceInB(double balanceInB) {
        this.balanceInB = balanceInB;
    }

    public double getPriceOneAEqualsXB() {
        return priceOneAEqualsXB;
    }

    public void setPriceOneAEqualsXB(double priceOneAEqualsXB) {
        this.priceOneAEqualsXB = priceOneAEqualsXB;
    }

    public double getPriceOneBEqualsXA() {
        return priceOneBEqualsXA;
    }

    public void setPriceOneBEqualsXA(double priceOneBEqualsXA) {
        this.priceOneBEqualsXA = priceOneBEqualsXA;
    }
}
