package com.example.hp.dogsapp;

import android.app.Activity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import static retrofit2.Response.error;

/**
 * Created by HP on 5/8/2017.
 */
public class CustomList extends ArrayAdapter<Articles> {
    private final Activity context;
    private List<Articles> articlesList;
    private LayoutInflater inflater;
   // private final String[] web;
   // private final Integer[] imageId;
   // private final String[] cla;
   // private final String[] em;
  /*  public CustomList(Activity context,String[] web,String[] cla,String[] em, Integer[] imageId){
        super(context,R.layout.list_single,web);
        this.context = context;
        this.web = web;
        this.imageId=imageId;
        this.cla=cla;
        this.em=em;
    }*/
  public CustomList(Activity context,List<Articles> articlesList)
  {
      super(context,R.layout.list_single,articlesList);
      this.context=context;
      this.articlesList = articlesList;
      this.inflater = LayoutInflater.from(context);
  }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View rowView = inflater.inflate(R.layout.list_single, null, true);
        TextView nameTextField = (TextView) rowView.findViewById(R.id.txt);
        TextView infoTextField=(TextView) rowView.findViewById(R.id.cla);
        ImageView imageView = (ImageView)rowView.findViewById(R.id.img);

        Articles articles=articlesList.get(position);
        nameTextField.setText(articles.getTitle());
        infoTextField.setText(articles.getDescription());
        Log.i("ImageUrl",articles.getUrlToImage());
        if(articles.getUrlToImage()!=null && !articles.getUrlToImage().isEmpty() )
        Picasso.with(context)
                .load(articles.getUrlToImage())
                .placeholder(R.drawable.title)
                .error(R.drawable.title)
                .into(imageView);

        return rowView;
    }
}
