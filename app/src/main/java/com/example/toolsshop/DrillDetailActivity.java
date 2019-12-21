package com.example.toolsshop;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class DrillDetailActivity extends AppCompatActivity {
    private ImageView drill_image_view;
    private TextView title_text_view;
    private TextView info_drill_text_view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drill_detail);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar !=null){
            actionBar.hide();
        }
        initAndBuildViews();
    }

    private void initAndBuildViews() {
        drill_image_view = findViewById(R.id.drill_image_view);
        title_text_view = findViewById(R.id.title_text_view);
        info_drill_text_view = findViewById(R.id.info_drill_text_view);
        Intent intent = getIntent();
        if (intent.hasExtra("title") && intent.hasExtra("info") && intent.hasExtra("resId")){
            String title = intent.getStringExtra("title");
            String info = intent.getStringExtra("info");
            int resId = intent.getIntExtra("resId",-1);
             drill_image_view.setImageResource(resId);
            title_text_view.setText(title);
            info_drill_text_view.setText(info);
        }else {
             Intent backToCategoryIntent = new Intent(this,DrillCategoryActivity.class);
             startActivity(backToCategoryIntent);
        }
    }
}
