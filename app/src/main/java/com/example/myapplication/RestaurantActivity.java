package com.example.myapplication;
import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import android.util.Log;
import java.io.IOException;
import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

public class RestaurantActivity extends AppCompatActivity {
    private static final String TAG = RestaurantActivity.class.getSimpleName();
//    @BindView(R.id.locationEditText) TextView mLocationTextView;
//    @BindView(R.id.listView ) ListView mListView;

    private TextView mLocationTextView;
    private ListView mListView;

   public ArrayList<Restaurant> mRestaurants=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.restaurant_activity);

//        ButterKnife.bind(this);
        mListView=(ListView) findViewById(R.id.listView);
        mLocationTextView = (TextView) findViewById(R.id.locationTextView) ;


        Intent intent = getIntent();
        String location = intent.getStringExtra("location");

        mLocationTextView.setText("Here are all the restaurant near :" + location);
        getRestaurants(location);

    }
    private void getRestaurants(String location) {
        final YelpService yelpService = new YelpService();
        yelpService.findRestaurant(location, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                e.printStackTrace();
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                mRestaurants = yelpService.processResults(response);
                RestaurantActivity.this.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        String[] restaurantNames = new String[mRestaurants.size()];
                        for (int i = 0; i < restaurantNames.length; i++) {
                            restaurantNames[1] = mRestaurants.get(i).getName();
                        }
                        ArrayAdapter adapter = new ArrayAdapter(RestaurantActivity.this,
                                android.R.layout.simple_list_item_1, restaurantNames);
                        mListView.setAdapter(adapter);
//                        for (Restaurant restaurant : mRestaurants) {
//                            Log.d(TAG, "Name: " + restaurant.getName());
//                            Log.d(TAG, "Phone: " + restaurant.getPhone());
//                            Log.d(TAG, "Website: " + restaurant.getWebsite());
//                            Log.d(TAG, "Image url: " + restaurant.getImageUrl());
//                            Log.d(TAG, "Rating: " + Double.toString(restaurant.getRating()));
//                            Log.d(TAG, "Address: " + TextUtils.join(", ", restaurant.getAddress()));
//                            Log.d(TAG, "Categories: " + restaurant.getCategories().toString());
//                        }
                    }
                });


            }
        });
    }
}

