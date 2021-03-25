    package com.thecodechemist.basicidlegame;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Game game;
    Handler hUiUpdate;
    Runnable rUiUpdate;
    Button btnBuyStandardInvestment;
    Button btnBuyBetterInvestment;
    Button btnBuyBestInvestment;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        game = new Game();

        hUiUpdate = new Handler();
        rUiUpdate = () -> {
            game.generateIncomeFromInvestments();
            updateUI();
            hUiUpdate.postDelayed(rUiUpdate, 1000);
        };
        hUiUpdate.post(rUiUpdate);

        Button btnAddMoney = findViewById(R.id.btnAddMoney);
        btnAddMoney.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                game.moneyButtonTapped();
                updateUI();
            }
        });

        btnBuyStandardInvestment = findViewById(R.id.btnBuyStandardInvestment);
        btnBuyStandardInvestment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                game.purchaseInvestment(v);
                updateUI();
            }
        });

        btnBuyBetterInvestment = findViewById(R.id.btnBuyBetterInvestment);
        btnBuyBetterInvestment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                game.purchaseInvestment(v);
                updateUI();
            }
        });

        btnBuyBestInvestment = findViewById(R.id.btnBuyBestInvestment);
        btnBuyBestInvestment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                game.purchaseInvestment(v);
                updateUI();
            }
        });

        Button btnDebugCash = findViewById(R.id.btnDebugCash);
        btnDebugCash.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                game.setMoney(game.getMoney() + 10000);
                updateUI();
            }
        });

    }

    public void updateUI() {
        TextView tvCurrentMoney = findViewById(R.id.tvCurrentMoney);
        tvCurrentMoney.setText("£ " + game.getMoney());

        //Standard Investments
        int standardInvestmentsOwned = game.getStandardInvestments().getInvestmentsOwned();
        int standardInvestmentIncome = game.getStandardInvestments().getCurrentIncome();
        TextView tvStandardInvestmentTitle = findViewById(R.id.tvStandardInvestmentTitle);
        tvStandardInvestmentTitle.setText("Standard  |  Owned: " + standardInvestmentsOwned + "  |  Income £ " + standardInvestmentIncome + "/s");
        btnBuyStandardInvestment.setText("Buy for £" + game.getStandardInvestments().getCurrentCost());

        //Better Investments
        int betterInvestmentsOwned = game.getBetterInvestments().getInvestmentsOwned();
        int betterInvestmentIncome = game.getBetterInvestments().getCurrentIncome();
        TextView tvBetterInvestmentTitle = findViewById(R.id.tvBetterInvestmentTitle);
        tvBetterInvestmentTitle.setText("Better  |  Owned: " + betterInvestmentsOwned + "  |  Income £ " + betterInvestmentIncome + "/s");
        btnBuyBetterInvestment.setText("Buy for £" + game.getBetterInvestments().getCurrentCost());

        //Best Investments
        int bestInvestmentsOwned = game.getBestInvestments().getInvestmentsOwned();
        int bestInvestmentIncome = game.getBestInvestments().getCurrentIncome();
        TextView tvBestInvestmentTitle = findViewById(R.id.tvBestInvestmentTitle);
        tvBestInvestmentTitle.setText("Best  |  Owned: " + bestInvestmentsOwned + "  |  Income £ " + bestInvestmentIncome + "/s");
        btnBuyBestInvestment.setText("Buy for £" + game.getBestInvestments().getCurrentCost());

    }
}