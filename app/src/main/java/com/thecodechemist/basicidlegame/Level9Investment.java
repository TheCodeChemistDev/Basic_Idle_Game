package com.thecodechemist.basicidlegame;

public class Level9Investment extends Investment {

    public Level9Investment() {
        this.baseCost = 35343000;
        this.baseIncome = 410000;
        this.investmentsOwned = 0;
        this.currentCost = 35343000;
        this.currentIncome = 0;
        this.investmentTitle = "Level 9 Investment";
    }

    @Override
    public void increaseInvestmentCost() {
        this.currentCost = (int) Math.ceil(this.currentCost * (1.15 + (this.investmentsOwned * 0.009)));
    }
}
