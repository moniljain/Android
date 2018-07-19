package com.example.monil.cards;

import android.content.res.TypedArray;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;

import java.util.ArrayList;
import java.util.Collections;

public class MainActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private ArrayList<Books> mBooks;
    private BooksAdapter mBooksAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mRecyclerView = (RecyclerView)findViewById(R.id.recyclerview);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mBooks = new ArrayList<Books>();
        mBooksAdapter = new BooksAdapter(this,mBooks);
        mRecyclerView.setAdapter(mBooksAdapter);
        initialize();
        ItemTouchHelper helper = new ItemTouchHelper(new ItemTouchHelper.SimpleCallback(ItemTouchHelper.DOWN | ItemTouchHelper.UP
                |ItemTouchHelper.RIGHT|ItemTouchHelper.LEFT,
                ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT) {
            public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder target) {
                int from = viewHolder.getAdapterPosition();
                int to = target.getAdapterPosition();
                Collections.swap(mBooks,from,to);
                mBooksAdapter.notifyItemMoved(from,to);
                return true;
            }

            @Override
            public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction) {
                mBooks.remove(viewHolder.getAdapterPosition());
                mBooksAdapter.notifyItemRemoved(viewHolder.getAdapterPosition());
            }
        });
        helper.attachToRecyclerView(mRecyclerView);
    }
    @SuppressWarnings("ResourceType")
    public void  initialize()
    {
        TypedArray booksImageResources = getResources().obtainTypedArray(R.array.books_images);
        mBooks.add(new Books("Wings Of Fire","Autobiography","A. P. J. Abdul Kalam"
                ,booksImageResources.getResourceId(0,0)));
        mBooks.add(new Books("Inferno","Mystery","dan Brown"
                ,booksImageResources.getResourceId(1,0)));
        mBooks.add(new Books("1984","Political Satire","George Orwell"
                ,booksImageResources.getResourceId(2,0)));
        mBooks.add(new Books("To Kill A Mockingbird","Southern Gothic","Harper Lee"
                ,booksImageResources.getResourceId(3,0)));
        mBooks.add(new Books("The Kite Runner","Historical Fiction","Khaled Hosseini"
                ,booksImageResources.getResourceId(4,0)));
        mBooksAdapter.notifyDataSetChanged();
        booksImageResources.recycle();

    }
}
