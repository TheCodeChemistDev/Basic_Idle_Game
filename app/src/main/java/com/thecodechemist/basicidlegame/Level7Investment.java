package com.thecodechemist.basicidlegame;

public class Level7Investment extends Investment {

    public Level7Investment() {
        this.baseCost = 519750;
        this.baseIncome = 18900;
        this.investmentsOwned = 0;
        this.currentCost = 519750;
        this.currentIncome = 0;
        this.investmentTitle = "Level 7 Investment";
    }

    @Override
    public void increaseInvestmentCost() {
        this.currentCost = (int) Math.ceil(this.currentCost * (1.13 + (this.investmentsOwned * 0.007)));
    }

}
