package com.thecodechemist.basicidlegame;

public class Level8Investment extends Investment {

    public Level8Investment() {
        this.baseCost = 4158000;
        this.baseIncome = 94500;
        this.investmentsOwned = 0;
        this.currentCost = 4158000;
        this.currentIncome = 0;
        this.investmentTitle = "Level 8 Investment";
    }

    @Override
    public void increaseInvestmentCost() {
        this.currentCost = (int) Math.ceil(this.currentCost * (1.14 + (this.investmentsOwned * 0.008)));
    }
}
