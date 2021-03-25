    package com.thecodechemist.basicidlegame;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

    public class MainActivity extends AppCompatActivity {

    private final String TAG = "MainActivity";

    private InvestmentArrayAdapter investmentArrayAdapter;
    private ListView lvInvestments;

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

        lvInvestments = findViewById(R.id.lvInvestments);
        investmentArrayAdapter = new InvestmentArrayAdapter(getApplicationContext(), R.layout.investment_list_item);
        lvInvestments.setAdapter(investmentArrayAdapter);

        List<Investment> investmentList = loadInvestmentList();
        for(Investment investment: investmentList) {
            investmentArrayAdapter.add(investment);
        }

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

//        btnBuyStandardInvestment = findViewById(R.id.btnBuyStandardInvestment);
//        btnBuyStandardInvestment.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                game.purchaseInvestment(v);
//                updateUI();
//            }
//        });

        Button btnDebugCash = findViewById(R.id.btnDebugCash);
        btnDebugCash.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                game.setMoney(game.getMoney() + 10000);
                updateUI();
            }
        });

    }

        private List<Investment> loadInvestmentList() {
        //Creates a List of Investment objects representing the 10 levels of investments in the game.
            List<Investment> result = new ArrayList<Investment>();

            result.add(new Level1Investment());
            result.add(new Level2Investment());
            result.add(new Level3Investment());
            result.add(new Level4Investment());
            result.add(new Level5Investment());
            result.add(new Level6Investment());
            result.add(new Level7Investment());
            result.add(new Level8Investment());
            result.add(new Level9Investment());
            result.add(new Level10Investment());

            return result;
        }

        public void updateUI() {
        TextView tvCurrentMoney = findViewById(R.id.tvCurrentMoney);
        tvCurrentMoney.setText("£ " + game.getMoney());

//        //Standard Investments
//        int standardInvestmentsOwned = game.getStandardInvestments().getInvestmentsOwned();
//        int standardInvestmentIncome = game.getStandardInvestments().getCurrentIncome();
//        TextView tvStandardInvestmentTitle = findViewById(R.id.tvStandardInvestmentTitle);
//        tvStandardInvestmentTitle.setText("Standard  |  Owned: " + standardInvestmentsOwned + "  |  Income £ " + standardInvestmentIncome + "/s");
//        btnBuyStandardInvestment.setText("Buy for £" + game.getStandardInvestments().getCurrentCost());
//
//        //Better Investments
//        int betterInvestmentsOwned = game.getBetterInvestments().getInvestmentsOwned();
//        int betterInvestmentIncome = game.getBetterInvestments().getCurrentIncome();
//        TextView tvBetterInvestmentTitle = findViewById(R.id.tvBetterInvestmentTitle);
//        tvBetterInvestmentTitle.setText("Better  |  Owned: " + betterInvestmentsOwned + "  |  Income £ " + betterInvestmentIncome + "/s");
//        btnBuyBetterInvestment.setText("Buy for £" + game.getBetterInvestments().getCurrentCost());
//
//        //Best Investments
//        int bestInvestmentsOwned = game.getBestInvestments().getInvestmentsOwned();
//        int bestInvestmentIncome = game.getBestInvestments().getCurrentIncome();
//        TextView tvBestInvestmentTitle = findViewById(R.id.tvBestInvestmentTitle);
//        tvBestInvestmentTitle.setText("Best  |  Owned: " + bestInvestmentsOwned + "  |  Income £ " + bestInvestmentIncome + "/s");
//        btnBuyBestInvestment.setText("Buy for £" + game.getBestInvestments().getCurrentCost());

    }
}