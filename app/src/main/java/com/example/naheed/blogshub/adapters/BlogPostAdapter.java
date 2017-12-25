package com.example.naheed.blogshub.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.naheed.blogshub.PostDetailActivity;
import com.example.naheed.blogshub.R;
import com.example.naheed.blogshub.models.Items;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.util.ArrayList;

/**
 * Created by Naheed on 12/12/17.
 */

public class BlogPostAdapter extends RecyclerView.Adapter<BlogPostAdapter.BlogPostViewHolder> implements Filterable
{
    private Context mContext;
    private Items[] mItems;
    private Items[] mFilteredItems;

    public BlogPostAdapter(Context mContext, Items[] items) {
        this.mContext = mContext;
        this.mItems = items;
        this.mFilteredItems = items;
    }

    @Override
    public BlogPostViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(mContext);
        View view = layoutInflater.inflate(R.layout.post_item, parent, false);
        return new BlogPostViewHolder(view);
    }

    @Override
    public void onBindViewHolder(BlogPostViewHolder holder, int position) {
        final Items item = mFilteredItems[position];

        holder.postTitle.setText(item.getTitle());
        Document document = Jsoup.parse(item.getContent());
        holder.postDescription.setText(document.text());

        Elements contentElement = document.select("div");
        final String html = contentElement.toString();


        Elements elements = document.select("img");
        Log.d("CODE","Image -"+elements.get(0).attr("src"));
        Glide.with(mContext).load(elements.get(0).attr("src")).into(holder.postImage);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext,PostDetailActivity.class);
                intent.putExtra("url", item.getUrl());
                intent.putExtra("divContent", html);
                mContext.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mFilteredItems.length;
    }

    @Override
    public Filter getFilter()
    {
        return new Filter()
        {
            @Override
            protected FilterResults performFiltering(CharSequence charSequence) {

                String charString = charSequence.toString();

                if (charString.isEmpty())
                {
                    mFilteredItems = mItems;
                }
                else
                {
                    ArrayList<Items> filteredList = new ArrayList<>();

                    for (Items item : mItems)
                    {
                        // Specify Filter Conditions
                        if (item.getTitle().toLowerCase().contains(charString) ||
                                item.getTitle().toLowerCase().contains(charString))
                        {
                                        filteredList.add(item);
                        }
                    }

                    mFilteredItems = filteredList.toArray(new Items[filteredList.size()]);
                }

                FilterResults filterResults = new FilterResults();
                filterResults.values = mFilteredItems;
                return filterResults;
            }

            @Override
            protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
                mFilteredItems = (Items[]) filterResults.values;
                notifyDataSetChanged();
            }
        };
    }


    public class BlogPostViewHolder extends RecyclerView.ViewHolder
    {
        ImageView postImage;
        TextView postTitle;
        TextView postDescription;

        public BlogPostViewHolder(View itemView) {
            super(itemView);
            postImage = (ImageView)itemView.findViewById(R.id.postImage);
            postTitle = (TextView)itemView.findViewById(R.id.postTitle);
            postDescription = (TextView)itemView.findViewById(R.id.postDescription);
        }
    }
}