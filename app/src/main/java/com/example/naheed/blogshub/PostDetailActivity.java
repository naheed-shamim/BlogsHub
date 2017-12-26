package com.example.naheed.blogshub;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.naheed.blogshub.adapters.TabsPagerAdapter;

import butterknife.BindView;
import butterknife.ButterKnife;

public class PostDetailActivity extends AppCompatActivity
{

    @BindView(R.id.toolbar) android.support.v7.widget.Toolbar toolbar;
    @BindView(R.id.tabLayout) TabLayout tabLayout;
    @BindView(R.id.pager) ViewPager viewPager;

    private TabsPagerAdapter tabsPagerAdapter;

    String[] tabsArray = new String[]{"Post","Comments"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post_detail);
        ButterKnife.bind(this);

        setupTabLayout();

        initSetup();
    }

    private void initSetup()
    {
        setupToolbar();
//        setupWebView();
    }

    private void setupTabLayout()
    {
        tabLayout.addTab(tabLayout.newTab().setText("Post"));
        tabLayout.addTab(tabLayout.newTab().setText("Comments"));

        tabsPagerAdapter = new TabsPagerAdapter(getSupportFragmentManager(),tabLayout.getTabCount());
        viewPager.setAdapter(tabsPagerAdapter);

        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }


    private void setupToolbar()
    {
        setSupportActionBar(toolbar);
//        getSupportActionBar().setTitle("Hello");
        getSupportActionBar().setIcon(null);
//        getSupportActionBar().setna

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(false);
        getSupportActionBar().setDisplayShowTitleEnabled(true);
//        getSupportActionBar().setTitle("My Profile");
        getSupportActionBar().setDisplayUseLogoEnabled(false);
    }




    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}
