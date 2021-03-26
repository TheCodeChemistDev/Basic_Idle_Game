package com.thecodechemist.basicidlegame;

public class Level5Investment extends Investment {

    public Level5Investment() {
        this.baseCost = 9900;
        this.baseIncome = 900;
        this.investmentsOwned = 0;
        this.currentCost = 9900;
        this.currentIncome = 0;
        this.investmentTitle = "Level 5 Investment";
    }

    @Override
    public void increaseInvestmentCost() {
        this.currentCost = (int) Math.ceil(this.currentCost * (1.11 + (this.investmentsOwned * 0.005)));
    }

}
