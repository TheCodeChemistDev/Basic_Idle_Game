package com.thecodechemist.basicidlegame;

public class Level2Investment extends Investment {

    public Level2Investment() {
        this.baseCost = 500;
        this.baseIncome = 10;
        this.investmentsOwned = 0;
        this.currentCost = 500;
        this.currentIncome = 0;
        this.investmentTitle = "Level 2 Investment";
    }

    @Override
    public void increaseInvestmentCost() {
        //TODO: Implement scaling for Better Investment Cost
        this.currentCost = (int) Math.ceil(this.currentCost + (this.investmentsOwned * 5));
    }
}
