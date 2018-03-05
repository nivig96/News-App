package com.example.hp.dogsapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class SecondActivity extends AppCompatActivity {
    ListView list;
    CustomList adapter;
    private List<Articles> articlesList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        list = (ListView) findViewById(R.id.list);
        adapter = new CustomList(SecondActivity.this, new ArrayList<Articles>());

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Api.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        Api api = retrofit.create(Api.class);

        Call<NewsList> call = api.getNewsList();
        call.enqueue(new Callback<NewsList>() {
            @Override
            public void onResponse(Call<NewsList> call, Response<NewsList> response) {

                NewsList newsList = response.body();
                articlesList = response.body().getArticles();

                Log.d("Status", newsList.getStatus());

                adapter = new CustomList(SecondActivity.this, articlesList);
                list.setAdapter(adapter);
                adapter.notifyDataSetChanged();

                list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                     @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {

                        Intent i = new Intent(getApplicationContext(), ThirdActivity.class);
                        i.putExtra("url", articlesList.get(position).getUrl());
                        startActivity(i);
                        // Toast.makeText(SecondActivity.this, "You clicked at" + web[+position], Toast.LENGTH_SHORT).show();
                    }
                });
            }

            @Override
            public void onFailure(Call<NewsList> call, Throwable t) {

                Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_LONG).show();
            }
        });


        // list.setAdapter(adapter);

    }
    }




