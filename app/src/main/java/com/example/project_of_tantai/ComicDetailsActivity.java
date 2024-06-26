package com.example.project_of_tantai;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class ComicDetailsActivity extends AppCompatActivity {
    TextView contentComicTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comic_details);
        contentComicTextView = findViewById(R.id.ContentComic); // Đảm bảo sử dụng id chính xác
        Intent intent = getIntent();
        String contentText = intent.getStringExtra("content");
        // Hiển thị nội dung văn bản trong TextView
        contentComicTextView.setText(contentText);
    }
}
