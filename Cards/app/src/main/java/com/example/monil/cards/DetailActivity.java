package com.example.monil.cards;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class DetailActivity extends AppCompatActivity {

    TextView book_name,book_author;
    ImageView book_img;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        book_name = (TextView)findViewById(R.id.nameDetail);
        book_author = (TextView) findViewById(R.id.authorDetail);
        book_img = (ImageView)findViewById(R.id.bookimgDetail);
        book_name.setText(getIntent().getStringExtra("book_name"));
        book_author.setText(getIntent().getStringExtra("book_author"));
        Glide.with(this).load(getIntent().getIntExtra("book_img",0)).into(book_img);

    }
}
