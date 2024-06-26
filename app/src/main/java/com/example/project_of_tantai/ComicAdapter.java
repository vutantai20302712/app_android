package com.example.project_of_tantai;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import org.w3c.dom.Text;

import java.util.List;

public class ComicAdapter extends BaseAdapter {
    Activity activity;
    List<Comic> data;

    public ComicAdapter(Activity activity, List<Comic> data) {
        this.activity = activity;
        this.data = data;
    }
    @Override
    public int getCount() {
       return data.size();
    }

    @Override
    public Object getItem(int position) {
        return data.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = activity.getLayoutInflater().inflate(R.layout.item_comic,null);
        Comic comic = data.get(position);
        ImageView imageView = convertView.findViewById(R.id.image_co);
        TextView nameView = convertView.findViewById(R.id.name_co);
        TextView artistView = convertView.findViewById(R.id.artist_co);
        ImageView contentView = convertView.findViewById(R.id.content_co);
        nameView.setText(comic.getNamecomic());
        artistView.setText(comic.getArtistcomic());
        Picasso.get().load(comic.getImagecomic()).into(imageView);
        Picasso.get().load(comic.getContentcomic()).into(contentView);
        return convertView;
    }

}
