package com.hector.task_1.DataAdapters;

import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.hector.task_1.R;

public class DataViewHolder extends RecyclerView.ViewHolder {

    TextView id, login;
    CheckBox open_state;
    ImageView url_button;

    public DataViewHolder(@NonNull View itemView) {
        super(itemView);

        id = itemView.findViewById(R.id.id);
        login = itemView.findViewById(R.id.login);
        open_state = itemView.findViewById(R.id.open);
        url_button = itemView.findViewById(R.id.url_button);
    }
}
