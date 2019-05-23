package com.example.geniusplazechallenge;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.example.geniusplazechallenge.model.DataItem;
import com.example.geniusplazechallenge.mvp.InteractorImpl;
import com.example.geniusplazechallenge.mvp.MainContract;
import com.example.geniusplazechallenge.mvp.PresenterImpl;
import com.example.geniusplazechallenge.recyclerview.MyAdapter;

import java.util.List;

public class MainActivity extends AppCompatActivity implements MainContract.MainView {
    private MainContract.Presenter presenter;
    private RecyclerView recyclerView;
    private List<DataItem> items;
    private OnItemClicked onItemClicked = new OnItemClicked() {
        @Override
        public void itemClicked(DataItem dataItem) {
            Toast.makeText(MainActivity.this, dataItem.getFirstName() + "profile has been clicked", Toast.LENGTH_LONG).show();
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        presenter = new PresenterImpl(MainActivity.this, new InteractorImpl());
        setUpRecyclerview();
        presenter.requestDataFromServer();



    }




    @Override
    public void putDataToRecyclerview(List<DataItem> dataItemList) {

        MyAdapter adapter = new MyAdapter(dataItemList, onItemClicked, MainActivity.this);
        recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();



    }
    private void setUpRecyclerview() {
        recyclerView = findViewById(R.id.dataRecyclerview);
        LinearLayoutManager layoutManager = new LinearLayoutManager(MainActivity.this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);

    }
}
