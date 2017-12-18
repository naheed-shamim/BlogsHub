package com.example.naheed.blogshub.models;

/**
 * Created by nasheed on 07/12/17.
 */

public class PostList
{
    private String etag;

    private Items[] items;

    private String kind;

    public String getEtag ()
    {
        return etag;
    }

    public void setEtag (String etag)
    {
        this.etag = etag;
    }

    public Items[] getItems ()
    {
        return items;
    }

    public void setItems (Items[] items)
    {
        this.items = items;
    }

    public String getKind ()
    {
        return kind;
    }

    public void setKind (String kind)
    {
        this.kind = kind;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [etag = "+etag+", items = "+items+", kind = "+kind+"]";
    }
}