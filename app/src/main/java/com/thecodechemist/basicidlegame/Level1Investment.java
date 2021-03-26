package com.thecodechemist.basicidlegame;

public class Level1Investment extends Investment {

    public Level1Investment() {
        this.baseCost = 10;
        this.baseIncome = 1;
        this.investmentsOwned = 0;
        this.currentCost = 10;
        this.currentIncome = 0;
        this.investmentTitle = "Level 1 Investment";
    }

    @Override
    public void increaseInvestmentCost() {
        this.currentCost = (int) Math.ceil(this.currentCost * (1.07 + (this.investmentsOwned * 0.001)));
    }
}
