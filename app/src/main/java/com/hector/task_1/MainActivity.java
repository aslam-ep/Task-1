package com.hector.task_1;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;

import com.hector.task_1.API.MyAPI;
import com.hector.task_1.API.RetrofitClient;
import com.hector.task_1.DataAdapters.DataAdapter;
import com.hector.task_1.DataModels.DataModel;

import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;


public class MainActivity extends AppCompatActivity {

    MyAPI myAPI;
    RecyclerView recyclerView;
    CompositeDisposable compositeDisposable;
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(R.layout.action_bar);

        compositeDisposable = new CompositeDisposable();

        Retrofit retrofit = RetrofitClient.getInstance();
        myAPI = retrofit.create(MyAPI.class);

        progressBar = findViewById(R.id.progressBar);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        
        fetchData();
    }

    private void fetchData() {
        compositeDisposable.add(myAPI.getDataModels()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(new Consumer<List<DataModel>>() {
                @Override
                public void accept(List<DataModel> dataModels) throws Exception {
                    displayData(dataModels);
                }
            }));

    }

    private void displayData(List<DataModel> dataModels) {
        DataAdapter adapter = new DataAdapter(this, dataModels);
        progressBar.setVisibility(View.INVISIBLE);
        recyclerView.setAdapter(adapter);
    }

    @Override
    protected void onStop() {
        compositeDisposable.clear();
        super.onStop();
    }
}