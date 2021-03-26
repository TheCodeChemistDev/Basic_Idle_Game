package com.thecodechemist.basicidlegame;

public class Level3Investment extends Investment {

    public Level3Investment() {
        this.baseCost = 275;
        this.baseIncome = 75;
        this.investmentsOwned = 0;
        this.currentCost = 275;
        this.currentIncome = 0;
        this.investmentTitle = "Level 3 Investment";
    }

    @Override
    public void increaseInvestmentCost() {
        this.currentCost = (int) Math.ceil(this.currentCost * (1.09 + (this.investmentsOwned * 0.003)));
    }

}
