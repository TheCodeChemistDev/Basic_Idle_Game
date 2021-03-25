package com.thecodechemist.basicidlegame;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class InvestmentArrayAdapter extends ArrayAdapter<Investment> {

    private static final String TAG = "InvestmentArrayAdapter";
    private List<Investment> investmentList = new ArrayList<>();

    static class InvestmentViewHolder {
        TextView tvInvestmentTitle;
        TextView tvInvestmentOwned;
        TextView tvInvestmentIncome;
        Button btnBuyInvestment;
    }

    public InvestmentArrayAdapter(Context context, int textViewResourceId) {
        super(context, textViewResourceId);
    }

    @Override
    public void add(Investment object) {
        investmentList.add(object);
        super.add(object);
    }

    @Override
    public int getCount() {
        return this.investmentList.size();
    }

    @Override
    public Investment getItem(int index) {
        return this.investmentList.get(index);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row = convertView;
        InvestmentViewHolder viewHolder;
        if (row == null) {
            LayoutInflater inflater = (LayoutInflater) this.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row = inflater.inflate(R.layout.investment_list_item, parent, false);
            viewHolder = new InvestmentViewHolder();
            viewHolder.tvInvestmentTitle = (TextView) row.findViewById(R.id.tvInvestmentTitle);
            viewHolder.tvInvestmentOwned = (TextView) row.findViewById(R.id.tvInvestmentOwned);
            viewHolder.tvInvestmentIncome = (TextView) row.findViewById(R.id.tvInvestmentIncome);
            viewHolder.btnBuyInvestment = (Button) row.findViewById(R.id.btnBuyInvestment);
            row.setTag(viewHolder);
        } else {
            viewHolder = (InvestmentViewHolder)row.getTag();
        }
        Investment investment = getItem(position);
        viewHolder.tvInvestmentTitle.setText(investment.getInvestmentTitle());
        viewHolder.tvInvestmentOwned.setText("Owned: " + investment.getInvestmentsOwned());
        viewHolder.tvInvestmentIncome.setText("Income: £ " + investment.getCurrentIncome() + "/s");
        viewHolder.btnBuyInvestment.setText("Buy X 1 \n £ " + investment.getCurrentCost());
        return row;
    }

}
