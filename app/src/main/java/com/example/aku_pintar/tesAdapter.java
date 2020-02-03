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

        final Integer[] kampus = {R.drawable.its, R.drawable.itb, R.drawable.ui, R.drawable.ugm, R.drawable.ub};
        final tesmodel TESModel = univer.get(i);

        viewHolder.nama1.setText(TESModel.getNamaUniversitas());
        viewHolder.akredi1.setText(TESModel.getAkreditas());
        viewHolder.status1.setText(TESModel.getStatus());
        final  int idd = i;

        final int idx = tesmodel.getId();
        viewHolder.ivlogo.setImageResource(kampus[idx - 1]);

        viewHolder.line1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
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
        private LinearLayout line1;
        private TextView nama1, akredi1, status1;
        ImageView ivlogo;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            line1 = itemView.findViewById(R.id.line1);
            nama1 = itemView.findViewById(R.id.nama1);
            akredi1 = itemView.findViewById(R.id.akredi1);
            status1 = itemView.findViewById(R.id.status1);
            ivlogo = itemView.findViewById(R.id.logo1);


        }
    }
}