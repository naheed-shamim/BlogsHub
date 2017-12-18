package com.example.naheed.blogshub.models;

/**
 * Created by nasheed on 07/12/17.
 */

public class Blog
{
    private String id;

    public String getId ()
    {
        return id;
    }

    public void setId (String id)
    {
        this.id = id;
    }

    @Override
    public String toString()
    {
        return "ClassBlog [id = "+id+"]";
    }
}