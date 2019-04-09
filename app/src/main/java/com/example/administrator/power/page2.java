package com.example.administrator.power;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;

import java.time.Instant;

public class page2 extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_page2, container, false);

        Button RiceFarming = (Button) view.findViewById(R.id.buttonRiceFarming);
        RiceFarming.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity() , rice_var.class);
                startActivity(intent);
            }
        });

        Button CareNourish = (Button) view.findViewById(R.id.buttonCareNourish);
        CareNourish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), nourish.class);
                startActivity(intent);
            }
        });
        return view;
    }

    //    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_page2);
//
//        Button RiceFarming = (Button)findViewById(R.id.buttonRiceFarming);
//        RiceFarming.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(page2.this, rice_var.class);
//                startActivity(intent);
//            }
//        });
//
//        Button CareNourish = (Button)findViewById(R.id.buttonCareNourish);
//        CareNourish.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(page2.this,nourish.class);
//                startActivity(intent);
//            }
//        });
//
//        Button Next = (Button)findViewById(R.id.buttonNext);
//        Next.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(page2.this,page3.class);
//                startActivity(intent);
//            }
//        });
//    }
}
