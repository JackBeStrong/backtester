package net.ddns.jackan.strategy;

import net.ddns.jackan.Bar;

public abstract class Strategy {

    public abstract void nextBar(Bar currentBar);
    public abstract void entry(Bar currentBar);
}
