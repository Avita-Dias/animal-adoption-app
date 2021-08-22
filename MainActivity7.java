package com.example.madproj;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity7 extends AppCompatActivity {

    DatabaseReference reference;

    Button button3;
    TextView textd;
    Button submit;
    EditText etname,etphone,etemail,etaddress,etres;
    CheckBox cb1,cb2;
    String ch;
    boolean flag=false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main7);

        etname=findViewById(R.id.etname);
        etphone=findViewById(R.id.etphone);
        etemail=findViewById(R.id.etemail);
        etaddress=findViewById(R.id.etaddress);
        etres=findViewById(R.id.etres);
        submit=findViewById(R.id.submit);
        cb1=findViewById(R.id.cb1);
        cb2=findViewById(R.id.cb2);
        reference= FirebaseDatabase.getInstance().getReference().child("adopterDetails");
        cb1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(cb1.isChecked()){
                    ch="home delivery";
                }
            }
        });
        cb2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(cb2.isChecked()){
                    ch="Self pickup";
                }
            }
        });


        button3=findViewById(R.id.button3);
        textd=findViewById(R.id.textd);
        Intent intent=getIntent();
        String s = intent.getStringExtra("key");
        textd.setText(s);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                flag=true;
                insertData();
                Toast.makeText(MainActivity7.this, "Details submitted", Toast.LENGTH_LONG).show();

            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(flag) {
                    final AlertDialog dialog = new AlertDialog.Builder(MainActivity7.this)
                            .setTitle("Confirm Adoption")
                            .setMessage("Are you sure you want to adopt this cat?")
                            .setPositiveButton("Yes", null)
                            .setNegativeButton("No", null)
                            .show();

                    Button positiveButton = dialog.getButton(AlertDialog.BUTTON_POSITIVE);
                    positiveButton.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            String catname = textd.getText().toString();
                            deleteData(catname);
                            launch2();
                            dialog.dismiss();
                        }
                    });
                }
                else{
                    Toast.makeText(MainActivity7.this,"Can't adopt without submitting the details",Toast.LENGTH_LONG).show();
                }

            }
        });

    }

    private void deleteData(String name){
        reference= FirebaseDatabase.getInstance().getReference("Catdb");
        reference.child(name).removeValue().addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if(task.isSuccessful()){
                }
                else{
                }
            }
        });
    }
    public void launch2(){
        Intent i=new Intent(MainActivity7.this,MainActivity5.class);
        startActivity(i);
    }
    private void insertData(){
        String name = etname.getText().toString();
        String phone = etphone.getText().toString();
        String email = etemail.getText().toString();
        String address = etaddress.getText().toString();
        String response = etres.getText().toString();
        String mode=ch;


        adoptermodel ado=new adoptermodel(name,phone,email,address,response,mode);

        reference.push().setValue(ado);

    }
}
