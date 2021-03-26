package com.thecodechemist.basicidlegame;

public class Level10Investment extends Investment {

    public Level10Investment() {
        this.baseCost = 335758500;
        this.baseIncome = 1600000;
        this.investmentsOwned = 0;
        this.currentCost = 335758500;
        this.currentIncome = 0;
        this.investmentTitle = "Level 10 Investment";
    }

    @Override
    public void increaseInvestmentCost() {
        this.currentCost = (int) Math.ceil(this.currentCost * (1.16 + (this.investmentsOwned * 0.01)));
    }
}
