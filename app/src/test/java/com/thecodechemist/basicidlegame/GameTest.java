package com.thecodechemist.basicidlegame;

import android.os.Handler;

import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;

public class GameTest {


    @Test
    public void test_moneyButtonTap() {
        Game game = new Game();
        game.moneyButtonTapped();

        assertEquals(1, game.getMoney());
    }


}