package com.example.administrator.power;

import android.annotation.SuppressLint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListView;
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

import java.util.ArrayList;
import java.util.List;

public class farming extends AppCompatActivity {

    private RequestQueue mQueue;
    List<String> farming_lists = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_farming);

        ListView listView = findViewById(R.id.farming_list);
        mQueue = Volley.newRequestQueue(this);

        getJson(listView);
    }

    public void getJson(final ListView listView) {

        String url = "http://--------/kai/data/farming.php";

        JsonArrayRequest request = new JsonArrayRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        try {
                            for (int i = 0; i < response.length(); i++) {
                                JSONObject rice = response.getJSONObject(i);

                                String  rice_id = rice.getString("rice_id");
                                String rice_name = rice.getString("rice_name");

                                farming_lists.add(rice_id);
                            }

                            RiceApdapter adapter = new RiceApdapter();
                            listView.setAdapter(adapter);
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

    class RiceApdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return farming_lists.size();
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @SuppressLint("ViewHolder")
        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            convertView = getLayoutInflater().inflate(R.layout.farming_row, null);

            Button name_list = convertView.findViewById(R.id.farming);

            name_list.setText(farming_lists.get(position));
            return convertView;
        }
    }
}
