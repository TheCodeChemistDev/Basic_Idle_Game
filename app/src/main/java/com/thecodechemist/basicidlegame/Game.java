package com.thecodechemist.basicidlegame;

import java.util.ArrayList;
import java.util.List;

public class Game {

    private final String TAG = "Game";
    private int money;
    private final List<Investment> investmentsList;

    public Game() {
        this.money = 0;
        //Create an object for each different type of investment in the game
        this.investmentsList = new ArrayList<>();
        this.investmentsList.add(new Level1Investment());
        this.investmentsList.add(new Level2Investment());
        this.investmentsList.add(new Level3Investment());
        this.investmentsList.add(new Level4Investment());
        this.investmentsList.add(new Level5Investment());
        this.investmentsList.add(new Level6Investment());
        this.investmentsList.add(new Level7Investment());
        this.investmentsList.add(new Level8Investment());
        this.investmentsList.add(new Level9Investment());
        this.investmentsList.add(new Level10Investment());

    }

    public void moneyButtonTapped() {
        this.money = this.money + 1;
    }


    public void purchaseInvestment(int investmentId) {

        //Find the cost of purchasing the investment and buy it if the user has enough money
        Investment selectedInvestment = this.investmentsList.get(investmentId);
        int cost;
        cost = selectedInvestment.getCurrentCost();
        if(this.money >= cost) {
            selectedInvestment.purchaseInvestment();
            this.money = this.money - cost;
        }
    }

    public void generateIncomeFromInvestments() {
        int level1InvestmentsOwned = this.investmentsList.get(0).getInvestmentsOwned();
        this.money = this.money + level1InvestmentsOwned;

    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public List<Investment> getInvestmentsList() {
        return this.investmentsList;
    }

}
