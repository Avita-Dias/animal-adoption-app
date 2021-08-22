package com.example.madproj;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class detfragment extends Fragment {

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;
    String Aaname, Age,Details,Dtype,Purl;
    public detfragment() {

    }
    public detfragment(String Aaname, String Age,String Details,String Dtype,String Purl ) {
        this.Aaname=Aaname;
        this.Age=Age;
        this.Details=Details;
        this.Dtype=Dtype;
        this.Purl=Purl;
    }

    public static detfragment newInstance(String param1, String param2) {
        detfragment fragment = new detfragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_detfragment, container, false);
        ImageView imageholder1=view.findViewById(R.id.imageholder1);
        TextView nameholder=view.findViewById(R.id.nameholder);
        TextView ageholder=view.findViewById(R.id.ageholder);
        TextView typeholder=view.findViewById(R.id.typeholder);
        TextView detailholder=view.findViewById(R.id.detailholder);
        Button button=(Button)view.findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent in=new Intent(getActivity(),MainActivity3.class);
                in.putExtra("key",nameholder.getText().toString());
                startActivity(in);
            }
        });

        nameholder.setText(Aaname);
        ageholder.setText(Age);
        detailholder.setText(Details);
        typeholder.setText(Dtype);
        Glide.with(getContext()).load(Purl).into(imageholder1);

        return view;
    }


    public void onBackPressed()
    {
        AppCompatActivity activity=(AppCompatActivity)getContext();
        activity.getSupportFragmentManager().beginTransaction().replace(R.id.wrapper,new recfragment()).addToBackStack(null).commit();
    }
}