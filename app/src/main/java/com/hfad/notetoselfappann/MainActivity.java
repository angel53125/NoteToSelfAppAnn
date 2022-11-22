package com.hfad.notetoselfappann;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView rv = findViewById(R.id.recyclerView);
        //adapter
        MyAdapter adapter = new MyAdapter(this,DataBase.getData());
        rv.setAdapter(adapter);
        //manager
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation((RecyclerView.VERTICAL));
        rv.setLayoutManager(layoutManager);
        FloatingActionButton imgAdd;
        imgAdd = findViewById(R.id.fab);



        imgAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


               NewDialogShowNote newDialog = new NewDialogShowNote();
               newDialog.show(getSupportFragmentManager(),"");



            }
        });

    }


}