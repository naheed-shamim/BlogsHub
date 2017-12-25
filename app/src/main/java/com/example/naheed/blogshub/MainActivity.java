package com.example.naheed.blogshub;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.SearchView;
import android.widget.Toast;

import com.example.naheed.blogshub.adapters.BlogPostAdapter;
import com.example.naheed.blogshub.models.PostList;
import com.example.naheed.blogshub.utils.AlertUtils;
import com.example.naheed.blogshub.utils.Constants;
import com.example.naheed.blogshub.utils.NetworkUtils;
import com.example.naheed.blogshub.utils.ProgressDialogUtility;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity
{
    private BlogPostAdapter mBlogPostAdapter;

    @BindView(R.id.drawerLayout) DrawerLayout drawerLayout;
    @BindView(R.id.navigation_menu) NavigationView navigationView;
    @BindView(R.id.postRecyclerView) RecyclerView recyclerView;
    @BindView(R.id.toolbar_home) Toolbar toolbar;

    ActionBarDrawerToggle actionBarDrawerToggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);
        setupInit();
    }

    private void setupInit()
    {
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        setMenuClickListeners();
        setupToobar();

        if (isConnectedToInternet())
            getData();
    }

    private boolean isConnectedToInternet()
    {
        boolean isConnected =  NetworkUtils.isInternetConnected();
        String msg = isConnected ? "Connected to Internet": "No Internet Connection";
        AlertUtils.showShortToast(msg);

        return isConnected;
    }

    private void setMenuClickListeners()
    {
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item)
            {
                switch (item.getItemId())
                {
                    case R.id.nav_home: Toast.makeText(getApplicationContext(), "Home Clicked", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.nav_option1: Toast.makeText(getApplicationContext(), "Option Clicked", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.nav_settings: Toast.makeText(getApplicationContext(), "Settings Clicked", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.nav_about: Toast.makeText(getApplicationContext(), "Option Clicked", Toast.LENGTH_SHORT).show();
                        break;
                }
                return false;
            }
        });
    }

    private void setupToobar()
    {
        //To consider the toolbar_home that we have setup in Layout File and not the one in the styles file
        //To make this backward compatible
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.app_name,R.string.app_name);
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();      //syncs Drawer and Toolbar
    }

    void getData()
    {
        ProgressDialogUtility.startProgressDialog(MainActivity.this);
        final Call<PostList> postList = RetrofitManager.getService(Constants.kBloggerURL).getPostList();

        postList.enqueue(new Callback<PostList>() {
            @Override
            public void onResponse(Call<PostList> call, Response<PostList> response) {
                PostList list = response.body();
                mBlogPostAdapter =  new BlogPostAdapter(MainActivity.this, list.getItems());
                recyclerView.setAdapter(mBlogPostAdapter);

                ProgressDialogUtility.dismissProgressDialog();

                Toast.makeText(getApplicationContext(), "Success", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<PostList> call, Throwable t) {
                ProgressDialogUtility.dismissProgressDialog();
                Toast.makeText(getApplicationContext(), "Error", Toast.LENGTH_SHORT).show();
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main_menu,menu);
        MenuItem search = menu.findItem(R.id.action_search);
        SearchView searchView = (SearchView) search.getActionView();
        search(searchView);
        return true;
    }

    private void search(SearchView searchView)
    {
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {

                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText)
            {
                if (mBlogPostAdapter != null)
                    mBlogPostAdapter.getFilter().filter(newText);
                return true;
            }
        });
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
//        int id = item.getItemId();
//
//        switch (id) {
//            case R.id.action_settings:
//                return true;
//            case R.id.action_search:
//                handleMenuSearch();
//                return true;
//        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
//        if(isSearchOpened) {
//            handleMenuSearch();
//            return;
//        }
        super.onBackPressed();
    }
}