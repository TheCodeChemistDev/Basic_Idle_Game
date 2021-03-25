package com.thecodechemist.basicidlegame;

public class Level1Investment extends Investment {

    public Level1Investment() {
        this.baseCost = 10;
        this.baseIncome = 1;
        this.investmentsOwned = 0;
        this.currentCost = 10;
        this.currentIncome = 0;
    }

    @Override
    public void increaseInvestmentCost() {
        //TODO: Implement scaling for Standard Investment Cost
        this.currentCost = (int) Math.ceil(this.currentCost + (this.investmentsOwned * 1.2));
    }
}
