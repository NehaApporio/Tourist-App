package com.example.apporio.viewpager;

import android.app.ProgressDialog;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.PagerTabStrip;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.StringRequestListener;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

//public class MainActivity extends FragmentActivity implements MyInterface{
    public class MainActivity extends FragmentActivity implements MyInterface{
    private static final String TAG = "MainActivity";
    ViewPager viewPager;
    PagerTabStrip pagerTabStrip;
    TrialListViewAdapter trialListViewAdapter;
    private ProgressDialog progressDialog;
    ArrayList<Thirdone> q=new ArrayList<>();
    ArrayList<Thirdone> core1 = new ArrayList<>();
    ArrayList<Thirdone> core2 = new ArrayList<>();
    ArrayList<Thirdone> core3=  new ArrayList<>();
    ArrayList<Thirdone> core4 = new ArrayList<>();


    ArrayList<ArrayList<Thirdone>> main_data = new ArrayList<>();

    private TextView total;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        viewPager = findViewById(R.id.viewpager);

        pagerTabStrip = findViewById(R.id.strip);

        total= findViewById(R.id.total);
        final ProgressDialog progressDialog=new ProgressDialog(MainActivity.this);
        progressDialog.setTitle("loding ......");
        progressDialog.show();
        progressDialog.setCancelable(false);
        progressDialog.setCanceledOnTouchOutside(false);

        /*

        Thirdone OBJ1 = new Thirdone("orange", "fruit",0);
        Thirdone OBJ2 = new Thirdone("orange", "fruit",0);
        Thirdone OBJ3 = new Thirdone("orange", "fruit",0);
        Thirdone OBJ4 = new Thirdone("orange", "fruit",0);
        Thirdone OBJ5 = new Thirdone("orange", "fruit",0);
        Thirdone OBJ6 = new Thirdone("orange", "fruit",0);
        Thirdone OBJ7 = new Thirdone("orange", "fruit",0);
        Thirdone OBJ8 = new Thirdone("orange", "fruit",0);
        Thirdone OBJ9 = new Thirdone("orange", "fruit",0);
        Thirdone OBJ10 = new Thirdone("orange", "fruit",0);
        Thirdone OBJ11 = new Thirdone("orange", "fruit",0);
        Thirdone OBJ12= new Thirdone("orange", "fruit",0);
        Thirdone OBJ13= new Thirdone("orange", "fruit",0);
        Thirdone OBJ14= new Thirdone("orange", "fruit",0);

        core1.add(OBJ1);
        core1.add(OBJ2);
        core1.add(OBJ3);
        core1.add(OBJ4);
        core1.add(OBJ5);
        core1.add(OBJ6);
        core1.add(OBJ7);
        core1.add(OBJ8);
        core1.add(OBJ9);
        core1.add(OBJ10);
        core1.add(OBJ11);
        core1.add(OBJ12);
        core1.add(OBJ13);
        core1.add(OBJ14);


        Thirdone OBJ15 = new Thirdone("name1", "des3rhhfh3ihfe3",0);
        Thirdone OBJ16= new Thirdone("name1", "des3rhhfh3ihfe3",0);
        Thirdone OBJ117 = new Thirdone("name1", "des3rhhfh3ihfe3",0);

        core2.add(OBJ8);
        core2.add(OBJ9);
        core2.add(OBJ10);

        Thirdone O1 = new Thirdone("orange", "fruit",0);
        Thirdone O2 = new Thirdone("orange", "fruit",0);
        Thirdone O3 = new Thirdone("orange", "fruit",0);
        Thirdone O4 = new Thirdone("orange", "fruit",0);
        Thirdone O5 = new Thirdone("orange", "fruit",0);
        Thirdone O6 = new Thirdone("orange", "fruit",0);
        Thirdone O7 = new Thirdone("orange", "fruit",0);
        Thirdone O8 = new Thirdone("orange", "fruit",0);
        Thirdone O9 = new Thirdone("orange", "fruit",0);
        Thirdone O10 = new Thirdone("orange", "fruit",0);
        Thirdone O11 = new Thirdone("orange", "fruit",0);

        core3.add(O1);
        core3.add(O2);
        core3.add(O3);
        core3.add(O4);
        core3.add(O5);
        core3.add(O6);
        core3.add(O7);
        core3.add(O8);
        core3.add(O9);
        core3.add(O10);
        core3.add(O11);



        Thirdone B1 = new Thirdone("orange", "fruit",0);
        Thirdone B2 = new Thirdone("orange", "fruit",0);
        Thirdone B3 = new Thirdone("orange", "fruit",0);
        Thirdone B4 = new Thirdone("orange", "fruit",0);
        Thirdone B5 = new Thirdone("orange", "fruit",0);
        Thirdone B6 = new Thirdone("orange", "fruit",0);
        Thirdone B7 = new Thirdone("orange", "fruit",0);
        Thirdone B8 = new Thirdone("orange", "fruit",0);
        Thirdone B9 = new Thirdone("orange", "fruit",0);
        Thirdone B10 = new Thirdone("orange", "fruit",0);
        Thirdone B11 = new Thirdone("orange", "fruit",0);

        core4.add(B1);
        core4.add(B2);
        core4.add(B3);
        core4.add(B4);
        core4.add(B5);
        core4.add(B6);
        core4.add(B7);
        core4.add(B8);
        core4.add(B9);
        core4.add(B10);
        core4.add(B11);



        main_data.add(core1);
        main_data.add(core2);
        main_data.add(core3);
        main_data.add(core4);

        Log.d("" + TAG, "size of main array list " + main_data.size());
        Log.d("" + TAG, "size of first item of main array list " + main_data.get(0).size());
        Log.d("" + TAG, "size of second item of main array list " + main_data.get(1).size());
        Log.d(""+TAG,"size of third core"+ main_data.get(2).size());
        Log.d(""+TAG,"size of four core"+main_data.get(3).size());



viewPager.setAdapter(new PagerAdapter(this,getSupportFragmentManager(), main_data));



        }


    @Override
    public void onPlusBtnClicked() {
        total.setText(""+(Integer.parseInt(total.getText().toString().trim())+1));

    }

    @Override
    public void onMinusBtnClicked() {
        total.setText(""+(Integer.parseInt(total.getText().toString().trim()) - 1));

    }

    @Override
    public void clearData() {
        total.setText("0");
    }

    @Override
    public void setTotalQuantity(String s) {
        total.setText(s);
    }
    */

        AndroidNetworking.initialize(getApplicationContext());

        AndroidNetworking.get("http://demo3755375.mockable.io/image")
                .build()
                .getAsString(new StringRequestListener() {
                    @Override
                    public void onResponse(String response) {
                        Log.d("#########",""+response);
                        json(response);
                        progressDialog.dismiss();
                    }

                    @Override
                    public void onError(ANError anError) {
                    progressDialog.dismiss();
                    }
                });
}

 public class DataModel {

     private String frag_name;
     private ArrayList<ModelFragData> frag_data;
     private int quality;


     public int getQuality() {
         return quality;
     }

     public void setQuality(int quality) {
         this.quality = quality;
     }


     public String getFrag_name() {
         return frag_name;
     }

     public String setFrag_name(String frag_name) {
         this.frag_name = frag_name;
         return frag_name;
     }

     public ArrayList<ModelFragData> getFrag_data() {
         return frag_data;
     }

     public void setFrag_data(ArrayList<ModelFragData> frag_data) {
         this.frag_data = frag_data;
     }



 }

    public class ModelFragData{

        private String image;
        private String description;
        private String text;
        private int quality;

        public int getQuality(){
            return quality;
        }

        public void setQuality(int quality){
            this.quality=quality;
        }
        public String getImage() {
            return image;
        }

        public void setImage(String image) {
            this.image = image;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getText() {
            return text;
        }

        public void setText(String text) {
            this.text = text;
        }
    }

    private void json(String response) {

        try {
            JSONArray jsonArray = new JSONArray(response);
           ArrayList<DataModel> dataModelArrayList = new ArrayList<>();


            for (int j = 0; j < jsonArray.length(); j++) {


                 DataModel dataModel = new DataModel();

                JSONObject jsonObject1 = jsonArray.optJSONObject(j);


                String frag_name =  jsonObject1.optString("frag_name");

                dataModel.setFrag_name(frag_name);
                ArrayList<ModelFragData> arrayList = new ArrayList<>();

                JSONArray jsonArray1= jsonObject1.optJSONArray("frag_dta");

               for(int k=0;k<jsonArray1.length();k++){

                  JSONObject jsonObject =  jsonArray1.optJSONObject(k);
                   String image =  jsonObject.optString("image");
                  String description = jsonObject.optString("description");
                  String text = jsonObject.optString("text");

                   ModelFragData modelFragData = new ModelFragData();
                   modelFragData.setDescription(description);
                   modelFragData.setImage(image);
                   modelFragData.setText(text);

                   arrayList.add(modelFragData);



                   }

                   dataModel.setFrag_data(arrayList);
                   dataModelArrayList.add(dataModel);

            }
            viewPager.setAdapter(new PagerAdapter(this, getSupportFragmentManager(),dataModelArrayList));




//                JSONArray jsonArray = jsonObject.optJSONArray("frag_data");
//
//                for (int j = 0; j < jsonArray.length(); j++) {
//
//                    JSONObject jsonObject1 = jsonArray.optJSONObject(j);
//                    String name = jsonObject1.optString("text");
//                    String desc = jsonObject1.optString("description");
//
//                    String pic = jsonObject1.optString("image");
//
//                    Thirdone thirdone = new Thirdone(name, desc, 0, pic);
//                    core1.add(thirdone);
//                    core2.add(thirdone);
//                    core3.add(thirdone);
//                    core4.add(thirdone);
//
//
//                }
//
//
//                if (core1 != null && core1.size() > 0) {
//                    main_data.add(core1);
//                    main_data.add(core2);
//                    main_data.add(core3);
//                    main_data.add(core4);

//
//                } else {
//                    Toast.makeText(this, "Core 1 List is Empty", Toast.LENGTH_SHORT).show();
//
//            }
            } catch(JSONException e){
                e.printStackTrace();
            }

    }

    @Override
    public void onPlusBtnClicked() {
        total.setText(""+(Integer.parseInt(total.getText().toString().trim())+1));
    }

    @Override
    public void onMinusBtnClicked() {
        total.setText(""+(Integer.parseInt(total.getText().toString().trim()) - 1));
    }

    @Override
    public void clearData() {
        total.setText("0");
    }

    @Override
    public void setTotalQuantity(String s) {
        total.setText(s);
    }
}




