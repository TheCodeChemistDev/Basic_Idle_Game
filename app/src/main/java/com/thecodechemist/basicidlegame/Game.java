package com.thecodechemist.basicidlegame;

import android.os.Handler;

public class Game {

    private int money;
    private int investmentCount;

    public Game() {
        this.money = 0;
        this.investmentCount = 0;

    }

    public void moneyButtonTapped() {
        this.money = this.money + 1;
    }

    public void purchaseInvestment() {
        if(money > 0) {
            this.investmentCount = this.investmentCount + 1;
            this.money = this.money - 1;
        }
    }

    public void generateIncomeFromInvestments() {
        this.money = this.money + (investmentCount);
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public int getInvestmentCount() {
        return investmentCount;
    }

    public void setInvestmentCount(int investmentCount) {
        this.investmentCount = investmentCount;
    }
}
