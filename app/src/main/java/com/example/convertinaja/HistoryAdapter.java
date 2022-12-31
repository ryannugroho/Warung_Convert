package com.example.convertinaja;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class HistoryAdapter extends RecyclerView.Adapter<HistoryAdapter.ViewHolder> {

    ArrayList<Convert> listConvert;

    public HistoryAdapter(ArrayList<Convert> listConvert) {
        this.listConvert = listConvert;
    }

    @NonNull
    @Override
    public HistoryAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        ViewHolder holder = new ViewHolder(inflater.inflate(R.layout.item_list, parent, false));
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull HistoryAdapter.ViewHolder holder, int position) {
        Convert convert = listConvert.get(position);
        holder.txtNama.setText(convert.geteWallet());
        holder.txtCurhat.setText(String.valueOf(convert.getJumlah()));
    }

    @Override
    public int getItemCount() {
        return listConvert.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView txtCurhat, txtNama;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txtCurhat = itemView.findViewById(R.id.txtItemKonten);
            txtNama = itemView.findViewById(R.id.txtItemNama);
        }
    }
}
