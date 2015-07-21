package com.example.appinventiv.recyclerviewdemo;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toolbar;

import com.example.appinventiv.recyclerviewdemo.adapter.CardViewDataAdapter;
import com.example.appinventiv.recyclerviewdemo.bean.ItemBean;
import com.example.appinventiv.recyclerviewdemo.listener.EndlessRecyclerOnScrollListener;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends ActionBarActivity {

    private Toolbar toolbar;

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private LinearLayoutManager mLayoutManager;
    private List<ItemBean> ItemBeanList;

    private static int current_page = 1;

    private int ival = 1;
    private int loadLimit = 10;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);


        // on scroll


        ItemBeanList = new ArrayList<ItemBean>();

        loadData(current_page);

        if (toolbar != null) {
            //  setSupportActionBar(toolbar);
            getSupportActionBar().setTitle("Items");

        }

        // get id of recyclerview
        mRecyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);

        // setting foe fixed size
        mRecyclerView.setHasFixedSize(true);

        mLayoutManager = new LinearLayoutManager(this);

        // use a linear layout manager
        mRecyclerView.setLayoutManager(mLayoutManager);

        // create an Object for Adapter
        mAdapter = new CardViewDataAdapter(ItemBeanList);

        // set the adapter object to the Recyclerview
        mRecyclerView.setAdapter(mAdapter);

        mRecyclerView.setOnScrollListener(new EndlessRecyclerOnScrollListener(mLayoutManager) {

            public void onLoadMore(int current_page) {
                // do somthing...

                loadMoreData(current_page);

            }

        });

    }

    // By default, we add 10 objects for first time.

    private void loadData(int current_page) {


        for (int i = ival; i <= loadLimit; i++) {

            ItemBean item= new ItemBean("Item " + i, "Item " + i+"  :  " +"description", false);

            ItemBeanList.add(item);
            ival++;

        }

    }

    // adding 10 object creating dymically to arraylist and updating recyclerview when  we reached last item

    private void loadMoreData(int current_page) {


        loadLimit = ival + 10;

        for (int i = ival; i <= loadLimit; i++) {
            ItemBean item = new ItemBean("Item " + i, "Item " + i+ "  :   "+"description", false);

            ItemBeanList.add(item);
            ival++;
        }

        mAdapter.notifyDataSetChanged();

    }




}



