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

public class page3 extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_page3, container, false);

        Button CultivationArea = (Button) view.findViewById(R.id.buttonCultivationArea);
        CultivationArea.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity() , area.class);
                startActivity(intent);
            }
        });

        Button Date = (Button) view.findViewById(R.id.buttonDate);
        Date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), farming.class);
                startActivity(intent);
            }
        });
        return view;
    }

    //    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_page3);
//
//        Button CultivationArea = (Button)findViewById(R.id.buttonCultivationArea);
//        CultivationArea.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(page3.this,area.class);
//                startActivity(intent);
//            }
//        });
//
////        Button Date = (Button)findViewById(R.id.buttonDate);
////        Date.setOnClickListener(new View.OnClickListener() {
////            @Override
////            public void onClick(View v) {
////                Intent intent = new Intent();
////                startActivity(intent);
////            }
////        });
//
//        Button Black = (Button)findViewById(R.id.buttonBlack);
//        Black.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent();
//                startActivity(intent);
//            }
//        });
//    }
}
