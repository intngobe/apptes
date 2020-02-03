package com.example.aku_pintar;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class tesAdapter extends RecyclerView.Adapter<tesAdapter.ViewHolder> {
    private tesdb db;
    private Context context;
    private List<tesmodel> univer;

    public tesAdapter(Context context) {
        this.context = context;
        this.univer = new ArrayList<>();
    }

    public void setUniver(List<tesmodel> univer) {
        this.univer = univer;
        notifyDataSetChanged();
    }



    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(context).inflate(R.layout.view_daftar_kampus, viewGroup, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {

        final Integer[] kampus = {R.drawable.itb, R.drawable.ugm, R.drawable.its, R.drawable.its, R.drawable.unhas};
        final tesmodel tesmodel = univer.get(i);

        viewHolder.tvNama.setText(tesmodel.getNamaUniversitas());
        viewHolder.tvAkreditas.setText(tesmodel.getAkreditas());
        viewHolder.tvStatus.setText(tesmodel.getStatus());

        final int idd = i;
        final int idx = tesmodel.getId();
        viewHolder.ivlogo.setImageResource(kampus[idx-1]);

        viewHolder.cvItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final tesmodel tesmodel = univer.get(idd);

                Intent intent = new Intent(context, detail_kampus.class);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return univer.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private LinearLayout cvItem;
        private TextView tvNama, tvAkreditas, tvStatus;
        ImageView ivlogo;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            cvItem = itemView.findViewById(R.id.line1);
            tvNama = itemView.findViewById(R.id.nama1);
            tvAkreditas = itemView.findViewById(R.id.akredi1);
            tvStatus = itemView.findViewById(R.id.status1);
            ivlogo = itemView.findViewById(R.id.logo1);


        }
    }
}