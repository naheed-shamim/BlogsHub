package com.example.naheed.blogshub;

import com.example.naheed.blogshub.models.PostList;
import com.example.naheed.blogshub.utils.Constants;

import retrofit2.Call;
import retrofit2.http.GET;



import static com.example.naheed.blogshub.utils.Constants.kBloggerAPIKey;

/**
 * Created by nasheed on 13/12/17.
 */

public interface BloggerService {

    @GET("?key=" + Constants.kBloggerAPIKey)
    Call<PostList> getPostList();

}
