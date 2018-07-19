package com.example.monil.cards;

/**
 * Created by Monil on 7/17/2018.
 */

public class Books {
    private String name,genre,author;
    private  int imageResource;
    Books(String name,String genre,String author,int imageResource)
    {
        this.name = name;
        this.genre = genre;
        this.author = author;
        this.imageResource = imageResource;
    }
    public String getName()
    {
        return name;
    }
    public String getGenre()
    {
        return genre;
    }
    public int getimageResource()
    {
        return imageResource;
    }
    public String getAuthor()
    {
        return author;
    }
}
