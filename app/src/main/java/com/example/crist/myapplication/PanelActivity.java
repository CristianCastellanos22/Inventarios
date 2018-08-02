package com.example.crist.myapplication;

import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.ArrayList;

public class PanelActivity extends AppCompatActivity implements View.OnClickListener {

    private HeaderAdapter headerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_panel);

        final FloatingActionButton floatingActionButton = (FloatingActionButton)findViewById(R.id.add1);

        RecyclerView recyclerView = (RecyclerView)findViewById(R.id.recycler);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);

        ArrayList<Header> mDataset = new ArrayList<>();
        mDataset.add(new Header("10001", "Cristian Castellanos", "22 de Enero de 2017"));
        mDataset.add(new Header("10002", "Cristian Castellanos", "20 de Marzo de 2014"));
        mDataset.add(new Header("10003", "Cristian Castellanos", "15 de Diciembre de 2015"));

        headerAdapter = new HeaderAdapter(mDataset);
        recyclerView.setAdapter(headerAdapter);

        floatingActionButton.setOnClickListener(this);

        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                if (newState == RecyclerView.SCROLL_STATE_IDLE){
                    floatingActionButton.show();
                }

                super.onScrollStateChanged(recyclerView, newState);
            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                if (dy > 0 || dy < 0 && floatingActionButton.isShown()){
                    floatingActionButton.hide();
                }
            }
        });

    }

    @Override
    public void onClick(View v) {
        showCreateHeaderDialog();
    }

    private void showCreateHeaderDialog() {
        FragmentManager fragmentManager = getSupportFragmentManager();
        HeaderDialogFragment newFragment = new HeaderDialogFragment();

        FragmentTransaction transaction = fragmentManager.beginTransaction();

        transaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);

        transaction.add(android.R.id.content, newFragment)
                .addToBackStack(null).commit();
    }
}
