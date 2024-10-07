package com.example.truyencuoi;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class StoryDetailActivity extends AppCompatActivity {

    private TextView txtStoryDetail;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_story_detail);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        txtStoryDetail = findViewById(R.id.txtStoryDetail);

        //Lấy tên truyện từ Intent
        String story = getIntent().getStringExtra("story");
        setTitle(story);

        //Hiển thị nội dung truyện
        String content ="Lúc bé, nghỉ học là chuyện lạ. Lớn lên mới biết, chuyện lạ là đi học...";
        txtStoryDetail.setText(content);
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