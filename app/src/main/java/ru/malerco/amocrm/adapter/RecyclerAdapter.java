package ru.malerco.amocrm.adapter;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.text.format.DateFormat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.List;

import ru.malerco.amocrm.R;
import ru.malerco.amocrm.models.leads.Lead;
import ru.malerco.amocrm.models.leads.LeadsStatus;


public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.MyViewHolder> {

    private Context mContext;
    private List<Lead> leads;
    private List<LeadsStatus> leadsStatus;


    public class MyViewHolder extends RecyclerView.ViewHolder {
        private TextView name;
        private TextView budget;
        private TextView status;
        private TextView timestamp;
        private CardView cardView;

        public MyViewHolder(View view) {
            super(view);
            name = (TextView)view.findViewById(R.id.leadName);
            budget = (TextView) view.findViewById(R.id.leadBudget);
            status = (TextView) view.findViewById(R.id.leadStatus);
            timestamp = (TextView)view.findViewById(R.id.leadTimestamp);
            cardView = (CardView)view.findViewById(R.id.card_view);
        }
    }


    public RecyclerAdapter(Context mContext, List<Lead> leads, List<LeadsStatus> leadsStatus) {

        this.mContext = mContext;
        this.leads = leads;
        this.leadsStatus = leadsStatus;

    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recycler_items, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {
        final Lead leadAlbum = leads.get(position);
        holder.name.setText(leadAlbum.getName());
        holder.budget.setText("Budget: " + leadAlbum.getPrice());

        holder.timestamp.setText(DateFormat.format("dd-MM-yyyy", leadAlbum.getDateCreate() * 1000L).toString());

        for (LeadsStatus status : leadsStatus){
            if (leadAlbum.getStatusId().equals(status.getId())){
                holder.status.setText(status.getName());
                holder.cardView.setBackgroundColor(Color.parseColor(status.getColor()));
            }
        }
    }

    @Override
    public int getItemCount() {

        return leads.size();
    }

}