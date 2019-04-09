package com.example.administrator.power;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class InsectDetail extends AppCompatActivity {

    private RequestQueue mQueue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.insect_detail);

        TextView insect_name = findViewById(R.id.insect_name);
        TextView insect_feature = findViewById(R.id.insect_feature);
        TextView insect_outbreak = findViewById(R.id.insect_outbreak);
        TextView insect_protect = findViewById(R.id.insect_protect);
        mQueue = Volley.newRequestQueue(this);

        getJson(insect_name, insect_feature, insect_outbreak, insect_protect, savedInstanceState);

    }

    public void getJson(final TextView insect_name, final TextView insect_feature, final TextView insect_outbreak, final TextView insect_protect, Bundle savedInstanceState) {
        String newString;
        String url = "";
        if (savedInstanceState == null) {
            Bundle extras = getIntent().getExtras();
            if(extras == null) {
                newString= null;
            } else {
                newString= extras.getString("name");
                url = "http://--------/kai/data/InsectDetail.php?id="+newString;
            }
        } else {
            newString= (String) savedInstanceState.getSerializable("name");
            url = "http://--------/kai/data/InsectDetail.php?id="+newString;
        }


        JsonArrayRequest request = new JsonArrayRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        try {
                            for (int i = 0; i < response.length(); i++) {
                                JSONObject json = response.getJSONObject(i);
                                String name = json.getString("inscet_name");
                                String feature = json.getString("feature");
                                String outbreak = json.getString("outbreak");
                                String protect = json.getString("protect");

                                insect_name.setText(name);
                                insect_feature.setText(feature);
                                insect_outbreak.setText(outbreak);
                                insect_protect.setText(protect);
                            }

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        });

        mQueue.add(request);
    }

}