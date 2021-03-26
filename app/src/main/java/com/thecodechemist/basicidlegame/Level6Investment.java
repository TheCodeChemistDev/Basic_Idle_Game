package com.thecodechemist.basicidlegame;

public class Level6Investment extends Investment {

    public Level6Investment() {
        this.baseCost = 69300;
        this.baseIncome = 2700;
        this.investmentsOwned = 0;
        this.currentCost = 69300;
        this.currentIncome = 0;
        this.investmentTitle = "Level 6 Investment";
    }

    @Override
    public void increaseInvestmentCost() {
        this.currentCost = (int) Math.ceil(this.currentCost * (1.12 + (this.investmentsOwned * 0.006)));
    }
}
