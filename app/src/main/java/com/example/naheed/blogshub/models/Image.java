package com.example.naheed.blogshub.models;

/**
 * Created by nasheed on 07/12/17.
 */

public class Image
{
    private String url;

    public String getUrl ()
    {
        return url;
    }

    public void setUrl (String url)
    {
        this.url = url;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [url = "+url+"]";
    }
}
