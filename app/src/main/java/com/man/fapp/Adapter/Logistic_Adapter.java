package com.man.fapp.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.man.fapp.Model.LogisticInfo;
import com.man.fapp.R;

import java.util.List;

public class Logistic_Adapter extends RecyclerView.Adapter<Logistic_Adapter.MyViewHolder> {

    private List<LogisticInfo> infoList;
    private Context context;

    public Logistic_Adapter(List<LogisticInfo> infoList, Context context) {
        this.infoList = infoList;
        this.context = context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context)
                .inflate(R.layout.log_info_row, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        final LogisticInfo info = infoList.get(position);
        holder.name.setText(info.getName());
        holder.link.setText(info.getLink());
        holder.description.setText(info.getDescription());
        boolean isExpanded = info.isExpanded();
        holder.expandableLayout.setVisibility(isExpanded ? View.VISIBLE : View.GONE);

        holder.name.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                info.setExpanded(!info.isExpanded());
                notifyDataSetChanged();
            }
        });
    }

    @Override
    public int getItemCount() {
        return infoList != null ? infoList.size() : 0;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView name;
        TextView link;
        TextView description;
        ConstraintLayout expandableLayout;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.titleTextView);
            link = itemView.findViewById(R.id.textView3);
            description = itemView.findViewById(R.id.plotTextView);
            expandableLayout = itemView.findViewById(R.id.expandableLayout);

        }
    }
}
