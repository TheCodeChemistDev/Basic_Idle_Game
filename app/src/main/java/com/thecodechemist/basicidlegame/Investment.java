package com.thecodechemist.basicidlegame;

public class Investment {

    public int baseCost;
    public int baseIncome;
    public int investmentsOwned;
    public int currentCost;
    public int currentIncome;
    public String investmentTitle;

    public Investment() {
        this.baseCost = 10;
        this.baseIncome = 1;
        this.investmentsOwned = 0;
        this.currentCost = 10;
        this.currentIncome = 0;
        this.investmentTitle = "Basic Investment";
    }

    public int getInvestmentsOwned() {
        return investmentsOwned;
    }

    public void purchaseInvestment() {
        this.investmentsOwned = this.investmentsOwned + 1;
        this.currentIncome = currentIncome + baseIncome;
        increaseInvestmentCost();
    }

    public void increaseInvestmentCost() {

    }

    public int getCurrentCost() {
        return this.currentCost;
    }

    public int getCurrentIncome() {
        return this.currentIncome;
    }

    public String getInvestmentTitle() {
        return this.investmentTitle;
    }
}
