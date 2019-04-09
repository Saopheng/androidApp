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

public class FertilizerDetail extends AppCompatActivity {

    private RequestQueue mQueue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fertilizer_detail);

        TextView fertilizer_name = findViewById(R.id.fertilizer_name);
        TextView fertilizer_period = findViewById(R.id.fertilizer_period);
        mQueue = Volley.newRequestQueue(this);

        getJson(fertilizer_name, fertilizer_period, savedInstanceState);

    }

    public void getJson(final TextView fertilizer_name, final TextView fertilizer_period, Bundle savedInstanceState) {
        String newString;
        String url = "";
        if (savedInstanceState == null) {
            Bundle extras = getIntent().getExtras();
            if(extras == null) {
                newString= null;
            } else {
                newString= extras.getString("name");
                url = "http://--------/kai/data/FertilizerDetail.php?id="+newString;
            }
        } else {
            newString= (String) savedInstanceState.getSerializable("name");
            url = "http://--------/kai/data/FertilizerDetail.php?id="+newString;
        }


        JsonArrayRequest request = new JsonArrayRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        try {
                            for (int i = 0; i < response.length(); i++) {
                                JSONObject json = response.getJSONObject(i);
                                String name = json.getString("fertilizer_name");
                                String period = json.getString("period");

                                fertilizer_name.setText(name);
                                fertilizer_period.setText(period);
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