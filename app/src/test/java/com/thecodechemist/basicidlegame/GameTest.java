package com.thecodechemist.basicidlegame;

import android.os.Handler;

import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;

public class GameTest {

    Handler hUiUpdate;
    Runnable rUiUpdate;
    int counter = 0;

    @Test
    public void test_moneyButtonTap() {
        Game game = new Game();
        game.moneyButtonTapped();

        assertEquals(1, game.getMoney());
    }

    @Test
    public void test_investmentCountIncreaseOnPurchase() {
        Game game = new Game();
        for(int i = 0; i < 10; i++) {
            game.moneyButtonTapped();
        }
        game.purchaseInvestment();

        assertEquals(1, game.getInvestments().getInvestmentsOwned());
    }

    @Test
    public void test_moneyReducedAfterPurchase() {
        Game game = new Game();
        for(int i = 0; i < 10; i++) {
            game.moneyButtonTapped();
        }
        game.purchaseInvestment();

        assertEquals(0, game.getMoney());
    }

    @Test
    public void test_incomeFromInvestment() {
        Game game = new Game();
        for(int i = 0; i < 10; i++) {
            game.moneyButtonTapped();
        }
        game.purchaseInvestment();
        game.generateIncomeFromInvestments();

        assertEquals(1, game.getMoney());

    }


}