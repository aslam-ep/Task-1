package com.hector.task_1.DataAdapters;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.hector.task_1.DataModels.DataModel;
import com.hector.task_1.R;

import java.util.List;

public class DataAdapter extends RecyclerView.Adapter<DataViewHolder> {

    Context context;
    List<DataModel> dataModelList;

    public DataAdapter(Context context, List<DataModel> dataModelList) {
        this.context = context;
        this.dataModelList = dataModelList;
    }

    @NonNull
    @Override
    public DataViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recycler_view_item_row, parent, false);

        return new DataViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DataViewHolder holder, final int position) {
        holder.id.setText(String.valueOf(dataModelList.get(position).id));
        holder.login.setText(String.valueOf((dataModelList.get(position).user).login));
        if(dataModelList.get(position).state.equals("open"))
            holder.open_state.setChecked(true);
        else
            holder.open_state.setChecked(false);

        holder.url_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(dataModelList.get(position).repository_url));
                context.startActivity(i);
            }
        });
    }

    @Override
    public int getItemCount() {
        return dataModelList.size();
    }
}
