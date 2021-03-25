package com.thecodechemist.basicidlegame;

public class Level3Investment extends Investment {

    public Level3Investment() {
        this.baseCost = 5000;
        this.baseIncome = 100;
        this.investmentsOwned = 0;
        this.currentCost = 5000;
        this.currentIncome = 0;
    }

    @Override
    public void increaseInvestmentCost() {
        //TODO: Implement scaling for Best Investment Cost
        this.currentCost = (int) Math.ceil(this.currentCost + (this.investmentsOwned * 15));
    }

}
