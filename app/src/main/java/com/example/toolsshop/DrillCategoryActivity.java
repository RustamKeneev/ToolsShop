package com.example.toolsshop;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class DrillCategoryActivity extends AppCompatActivity {
    private ListView drill_list_view;
    private ArrayList<Drill> drillArrayList;
    private ArrayAdapter<Drill> drillArrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drill_category);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar !=null){
            actionBar.hide();
        }
        initAndBuildViews();

    }

    private void initAndBuildViews() {
        drill_list_view = findViewById(R.id.drill_list_view);
        drillArrayList = new ArrayList<>();
        drillArrayList.add(new Drill(getString(R.string.drill_interskol_title),getString(R.string.drill_dewalt_info),R.drawable.interskol));
        drillArrayList.add(new Drill(getString(R.string.drill_makita_title), getString(R.string.drill_makita_info),R.drawable.makita));
        drillArrayList.add(new Drill(getString(R.string.drill_dewalt_title),getString(R.string.drill_dewalt_info),R.drawable.dewalt));

        drillArrayAdapter = new ArrayAdapter<>(getApplicationContext(),android.R.layout.simple_list_item_1,drillArrayList);
        drill_list_view.setAdapter(drillArrayAdapter);

        drill_list_view.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Drill drill = drillArrayList.get(i);
                Intent intent = new Intent(getApplicationContext(),DrillDetailActivity.class);
                intent.putExtra("title",drill.getTitle());
                intent.putExtra("info",drill.getInfo());
                intent.putExtra("resId",drill.getImageResourceId());
                startActivity(intent);
            }
        });
    }
}
