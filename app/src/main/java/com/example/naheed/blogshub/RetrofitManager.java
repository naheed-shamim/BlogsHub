package com.example.naheed.blogshub;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by nasheed on 13/12/17.
 */

public class RetrofitManager
{
    public static final String key = "AIzaSyAPrqqekCQXqXiIZbuf4LiE9S6K6f-XWoQ";
    public static final String url = "https://www.googleapis.com/blogger/v3/blogs/8935739805685184910/posts/";

    public static BloggerService bloggerService = null;

    public static BloggerService getService(String baseUrl)
    {
        if(bloggerService == null)
        {
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(baseUrl)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
            bloggerService = retrofit.create(BloggerService.class);
        }
        return  bloggerService;
    }
}
