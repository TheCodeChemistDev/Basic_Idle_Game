package com.thecodechemist.basicidlegame;

import android.view.View;
import android.widget.Button;

public class Game {

    private final String TAG = "Kemist";
    private int money;
    private Level1Investment standardInvestments;
    private Level2Investment betterInvestments;
    private Level3Investment bestInvestments;

    public Game() {
        this.money = 0;
        this.standardInvestments = new Level1Investment();
        this.betterInvestments = new Level2Investment();
        this.bestInvestments = new Level3Investment();

    }

    public void moneyButtonTapped() {
        this.money = this.money + 1;
    }


    public void purchaseInvestment(View viewBtnClicked) {
        Button btnClicked = (Button) viewBtnClicked;
        int cost;
        switch(btnClicked.getId()) {
            case R.id.btnBuyStandardInvestment:
                cost = this.standardInvestments.getCurrentCost();
                if(money >= cost) {
                    this.standardInvestments.purchaseInvestment();
                    this.money = this.money - cost;
                }
                break;
            case R.id.btnBuyBetterInvestment:
                cost = this.betterInvestments.getCurrentCost();
                if(money >= cost) {
                    this.betterInvestments.purchaseInvestment();
                    this.money = this.money - cost;
                }
                break;
            case R.id.btnBuyBestInvestment:
                cost = this.bestInvestments.getCurrentCost();
                if(money >= cost) {
                    this.bestInvestments.purchaseInvestment();
                    this.money = this.money - cost;
                }
                break;
        }
    }

    public void generateIncomeFromInvestments() {
        this.money = this.money + (this.standardInvestments.getInvestmentsOwned()) + (this.betterInvestments.getInvestmentsOwned() * 10) + (this.bestInvestments.getInvestmentsOwned() * 100);

    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public Level1Investment getStandardInvestments() {
        return this.standardInvestments;
    }

    public Level2Investment getBetterInvestments() {
        return this.betterInvestments;
    }

    public Level3Investment getBestInvestments() {
        return this.bestInvestments;
    }

}
