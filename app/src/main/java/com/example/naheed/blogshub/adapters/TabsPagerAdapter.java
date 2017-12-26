package com.example.naheed.blogshub.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.naheed.blogshub.PostCommentsFragment;
import com.example.naheed.blogshub.PostDetailFragment;

/**
 * Created by Naheed on 26/12/17.
 */

public class TabsPagerAdapter extends FragmentPagerAdapter
{
    int tabCount;

    public TabsPagerAdapter(FragmentManager fm, int tabsCount)
    {
        super(fm);
        this.tabCount = tabsCount;
    }

    @Override
    public Fragment getItem(int position)
    {
        switch (position)
        {
            case 0 :
                PostDetailFragment detailFragment = new PostDetailFragment();
                return detailFragment;
            case 1 :
                PostCommentsFragment commentsFragment = new PostCommentsFragment();
                return commentsFragment;
            default:
                    return null;
        }
    }

    @Override
    public int getCount() {
        return tabCount;
    }


//    @Override
//    public CharSequence getPageTitle(int position) {
//        return super.getPageTitle(position);
//    }
}
