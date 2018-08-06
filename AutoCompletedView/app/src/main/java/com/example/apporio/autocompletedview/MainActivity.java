package com.example.apporio.autocompletedview;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.ActionProvider;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.widget.ListView;
import android.widget.SearchView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    ListViewAdapter listViewAdapter;
    String[] title;
    String[] description;
    int[] icons;
    ArrayList<Model> modelArrayList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        title = new String[]{"Alerm", "Alerm2", "Battery", "BatteryLow", "Cake", "Laptop", "Lappi"};
        description = new String[]{"Show Time", "NormalAlerm", "Charged", "LowBatterry", "Yummi", "SuperLaptop", "NormalLaptop"};
        icons = new int[]{R.drawable.alerm, R.drawable.alerm2, R.drawable.ic_battery, R.drawable.ic_battery_charging_80_black_24dp,
                R.drawable.ic_cake_black_24dp, R.drawable.ic_laptop, R.drawable.ic_laptop_chromebook_black_24dp};

        listView = findViewById(R.id.list);

        for (int i = 0; i < title.length; i++) {
            Model model = new Model(title[i], description[i], icons[i]);

            //bind all in array
            modelArrayList.add(model);


        }
        listViewAdapter = new ListViewAdapter(this, modelArrayList);
        listView.setAdapter(listViewAdapter);
    }

        @Override
        public boolean onCreateOptionsMenu ( final Menu menu){
            getMenuInflater().inflate(R.menu.menu, menu);

            MenuItem menuItem = menu.findItem(R.id.ActionSearch);
            SearchView searchView = (SearchView) MenuItemCompat.getActionView(menuItem);
            searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
                @Override
                public boolean onQueryTextSubmit(String s) {
                    return false;
                }

                @Override
                public boolean onQueryTextChange(String s) {


                    if (TextUtils.isEmpty(s)) {
                        listViewAdapter.filter("");
                        listView.clearTextFilter();
                    } else {
                        listViewAdapter.filter(s);
                    }
                    return true;
                }
            });
            return true;

        }

        @Override
        public boolean onOptionsItemSelected (MenuItem item){

            int id = item.getItemId();
            if (id == R.id.Action) {


            }
            return super.onOptionsItemSelected(item);
        }
    }
