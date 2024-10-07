package com.example.truyencuoi;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;


import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NavUtils;


public class StoryListActivity extends AppCompatActivity {

    private ListView storyListView;
    private String[] stories ={"Việc học", "Đã hai lần rồi", "Cùng như nhau", "Rất lạnh"};



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_story_list);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        storyListView = findViewById(R.id.storyListView);

        //Lấy tên danh mục từ intent
        String category = getIntent().getStringExtra("category");
        setTitle(category);

        //hiển thị danh sách truyện
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,stories);
        storyListView.setAdapter(adapter);

        //Khi click vào truyện, mở StoryDetailActivity
        storyListView.setOnItemClickListener((parent,view, position, id) -> {
            Intent intent = new Intent(StoryListActivity.this,StoryDetailActivity.class);
            intent.putExtra("story", stories[position]);
            startActivity(intent);
        });

    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Kiểm tra nếu nút back được nhấn
        if (item.getItemId() == android.R.id.home) {
            getOnBackPressedDispatcher().onBackPressed();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

}