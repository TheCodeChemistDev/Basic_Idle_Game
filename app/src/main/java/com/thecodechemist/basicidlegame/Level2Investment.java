package com.thecodechemist.basicidlegame;

public class Level2Investment extends Investment {

    public Level2Investment() {
        this.baseCost = 50;
        this.baseIncome = 9;
        this.investmentsOwned = 0;
        this.currentCost = 75;
        this.currentIncome = 0;
        this.investmentTitle = "Level 2 Investment";
    }

    @Override
    public void increaseInvestmentCost() {
        this.currentCost = (int) Math.ceil(this.currentCost * (1.08 + (this.investmentsOwned * 0.002)));
    }
}
