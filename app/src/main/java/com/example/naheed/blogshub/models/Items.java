package com.example.naheed.blogshub.models;

/**
 * Created by Naheed on 07/12/17.
 */

public class Items
{
    private String content;

    private String id;

    private Author author;

    private String title;

    private String etag;

    private String updated;

    private Replies replies;

    private String selfLink;

    private String published;

    private Blog blog;

    private String url;

    private String kind;

    public String getContent ()
    {
        return content;
    }

    public void setContent (String content)
    {
        this.content = content;
    }

    public String getId ()
    {
        return id;
    }

    public void setId (String id)
    {
        this.id = id;
    }

    public Author getAuthor ()
    {
        return author;
    }

    public void setAuthor (Author author)
    {
        this.author = author;
    }

    public String getTitle ()
    {
        return title;
    }

    public void setTitle (String title)
    {
        this.title = title;
    }

    public String getEtag ()
    {
        return etag;
    }

    public void setEtag (String etag)
    {
        this.etag = etag;
    }

    public String getUpdated ()
    {
        return updated;
    }

    public void setUpdated (String updated)
    {
        this.updated = updated;
    }

    public Replies getReplies ()
    {
        return replies;
    }

    public void setReplies (Replies replies)
    {
        this.replies = replies;
    }

    public String getSelfLink ()
    {
        return selfLink;
    }

    public void setSelfLink (String selfLink)
    {
        this.selfLink = selfLink;
    }

    public String getPublished ()
    {
        return published;
    }

    public void setPublished (String published)
    {
        this.published = published;
    }

    public Blog getBlog ()
    {
        return blog;
    }

    public void setBlog (Blog blog)
    {
        this.blog = blog;
    }

    public String getUrl ()
    {
        return url;
    }

    public void setUrl (String url)
    {
        this.url = url;
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
        return "ClassItems [content = "+content+", id = "+id+", author = "+author+", title = "+title+", etag = "+etag+", updated = "+updated+", replies = "+replies+", selfLink = "+selfLink+", published = "+published+", blog = "+blog+", url = "+url+", kind = "+kind+"]";
    }
}
