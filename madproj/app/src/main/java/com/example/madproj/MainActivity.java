package com.example.madproj;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.Button;

import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.models.SlideModel;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    Button button1;
    Button button2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button1=findViewById(R.id.button1);
        button2=findViewById(R.id.button2);


        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                launchActivity();
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                launchActivity2();
            }
        });


        //carousel
        ImageSlider imageSlider = findViewById(R.id.slider);
        List<SlideModel> slideModels = new ArrayList<>();
        slideModels.add(new SlideModel("https://d17fnq9dkz9hgj.cloudfront.net/uploads/2020/04/shelter-dog-cropped-1-632x329.jpg","Don't Shop"));
        slideModels.add(new SlideModel("https://images2.minutemediacdn.com/image/upload/c_crop,h_843,w_1500,x_0,y_78/v1555182242/shape/mentalfloss/501389-istock-507640348.jpg?itok=ruUru63_","Opt To Adopt"));
        slideModels.add(new SlideModel("https://www.peta.org.uk/wp-content/uploads/2020/04/black-kitten-sad-cage-shelter-unsplash-scaled.jpg","Adoption Can Change Their Life"));
        slideModels.add(new SlideModel("https://d17fnq9dkz9hgj.cloudfront.net/uploads/2017/10/PF2015_267_Kittens_Shelter-630.jpg","Adopt Today"));
        imageSlider.setImageList(slideModels,true);

    }
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.menu,menu);
        return true;
        }

    private void launchActivity(){
        Intent intent1=new Intent(MainActivity.this,MainActivity2.class);
        startActivity(intent1);

    }
    private void launchActivity2(){
        Intent intent2=new Intent(MainActivity.this,MainActivity6.class);
        startActivity(intent2);

    }

}