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
        game.moneyButtonTapped();
        game.purchaseInvestment();

        assertEquals(1, game.getInvestmentCount());
    }

    @Test
    public void test_moneyReducedAfterPurchase() {
        Game game = new Game();
        game.moneyButtonTapped();
        game.purchaseInvestment();

        assertEquals(0, game.getMoney());
    }

    @Test
    public void test_incomeFromInvestment() {
        Game game = new Game();
        game.moneyButtonTapped();
        game.purchaseInvestment();
        hUiUpdate = mock(Handler.class);
        rUiUpdate = new Runnable() {
            @Override
            public void run() {
                game.generateIncomeFromInvestments();
                if(counter < 4) {
                    hUiUpdate.postDelayed(rUiUpdate, 1000);
                }
                counter += 1;
            }
        };

        assertEquals(5, game.getMoney());

    }


}