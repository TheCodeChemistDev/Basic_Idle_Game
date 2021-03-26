package com.thecodechemist.basicidlegame;

public class Level4Investment extends Investment {

    public Level4Investment() {
        this.baseCost = 1650;
        this.baseIncome = 350;
        this.investmentsOwned = 0;
        this.currentCost = 1650;
        this.currentIncome = 0;
        this.investmentTitle = "Level 4 Investment";
    }

    @Override
    public void increaseInvestmentCost() {
        this.currentCost = (int) Math.ceil(this.currentCost * (1.1 + (this.investmentsOwned * 0.004)));
    }
}
