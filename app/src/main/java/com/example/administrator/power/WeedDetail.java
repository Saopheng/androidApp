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

public class WeedDetail extends AppCompatActivity {

    private RequestQueue mQueue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.weed_detail);

        TextView weed_name = findViewById(R.id.weed_name);
        TextView weed_feature = findViewById(R.id.weed_feature);
        TextView weed_protect = findViewById(R.id.weed_protect);
        mQueue = Volley.newRequestQueue(this);

        getJson(weed_name, weed_feature, weed_protect, savedInstanceState);

    }

    public void getJson(final TextView weed_name, final TextView weed_feature, final TextView weed_protect, Bundle savedInstanceState) {
        String newString;
        String url = "";
        if (savedInstanceState == null) {
            Bundle extras = getIntent().getExtras();
            if(extras == null) {
                newString= null;
            } else {
                newString= extras.getString("name");
                url = "http://192.168.56.1/kai/data/WeedDetail.php?id="+newString;
            }
        } else {
            newString= (String) savedInstanceState.getSerializable("name");
            url = "http://192.168.56.1/kai/data/WeedDetail.php?id="+newString;
        }


        JsonArrayRequest request = new JsonArrayRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        try {
                            for (int i = 0; i < response.length(); i++) {
                                JSONObject json = response.getJSONObject(i);
                                String name = json.getString("weed_name");
                                String feature = json.getString("feature");
                                String protect = json.getString("protect");

                                weed_name.setText(name);
                                weed_feature.setText(feature);
                                weed_protect.setText(protect);
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