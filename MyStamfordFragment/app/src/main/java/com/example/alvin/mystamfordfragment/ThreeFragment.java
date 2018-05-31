package com.example.alvin.mystamfordfragment;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.media.Image;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.HashMap;
import java.util.Random;


public class ThreeFragment extends Fragment{



    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View root3View = inflater.inflate(R.layout.fragment_three, container, false);



//  Toast.makeText(getActivity().getApplicationContext(), "Test", Toast.LENGTH_SHORT).show();


        final ImageView rndImg = (ImageView) root3View.findViewById(R.id.rndImage);
        Button btnRandom = (Button) root3View.findViewById(R.id.buttonRandom);
        btnRandom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Random rndResult = new Random();
                int rndInt = rndResult.nextInt(3) + 1 ;
                String rndImgString = "pic" + rndInt;

                rndImg.setImageResource(getResources().getIdentifier(rndImgString,"drawable",getActivity().getPackageName()));
            }
        });



        Button btn_close = (Button) root3View.findViewById(R.id.btn_close);
        btn_close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //getFragmentManager().beginTransaction().remove(OneFragment.this).commit();
                getFragmentManager().popBackStack();
            }
        });

        return root3View;



    }
}

