package com.example.monil.cards;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Created by Monil on 7/17/2018.
 */

public class BooksAdapter extends RecyclerView.Adapter<BooksAdapter.MyViewHolder> {
    private ArrayList<Books> mBooks;
    private Context mcontext;
    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        private TextView name,author,genre;
        private ImageView mBooksImage;
        private  Context mContext;
        public MyViewHolder(Context context,View itemView) {
            super(itemView);
            name = (TextView)itemView.findViewById(R.id.name);
            genre = (TextView)itemView.findViewById(R.id.genre);
            author = (TextView)itemView.findViewById(R.id.author);
            mBooksImage = (ImageView)itemView.findViewById(R.id.bookimg);
            mContext = context;
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {

            Books book = mBooks.get(getAdapterPosition());
            Intent intent = new Intent(mContext,DetailActivity.class);
            intent.putExtra("book_name",book.getName());
            intent.putExtra("book_author",book.getAuthor());
            intent.putExtra("book_img",book.getimageResource());
            mContext.startActivity(intent);
        }
    }
    public BooksAdapter(Context context,ArrayList<Books> mBooks)
    {
        this.mBooks = mBooks;
        this.mcontext = context;
    }
    @NonNull
    @Override
    public BooksAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View viewItem = LayoutInflater.from(mcontext).inflate(R.layout.list_item,parent,false);
        return new MyViewHolder(mcontext,viewItem);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        Books book = mBooks.get(position);
        holder.name.setText(book.getName());
        holder.genre.setText(book.getGenre());
        holder.author.setText(book.getAuthor());
        Glide.with(mcontext).load(book.getimageResource()).into(holder.mBooksImage);
    }

    @Override
    public int getItemCount() {
        return mBooks.size();
    }
}
