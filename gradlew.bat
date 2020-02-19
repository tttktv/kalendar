package com.example.labasaper;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.app.Activity;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import java.util.Random;

public class ActivityTwo extends Activity implements View.OnClickListener {
  //  Button button;
 //   TextView tw;///////////////
    //public static int rows,columns,mines;
    TableLayout tableLayout;
    TextView textView;
    Button restartbtn;
    Intent intent=getIntent();
   int rows=Integer.parseInt(intent.getStringExtra("rw"));
   int columns=Integer.parseInt(intent.getStringExtra("cl"));
    int mines=Integer.parseInt(intent.getStringExtra("mn"));
    int win=0;
    Button[][] btn = new Button[rows][columns];
    String [][] mas=new String [rows][columns];


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_two);
       // tw=(TextView)findViewById(R.id.textView);//////////////

     //   button=(Button)findViewById(R.id.button);///////////
      //  button.setOnClickListener(this);/////////////
        //Intent intent=getIntent();
       // rows=Integer.parseInt(intent.getStringExtra("rw"));
       // columns=Integer.parseInt(intent.getStringExtra("cl"));
       // mines=Integer.parseInt(intent.getStringExtra("mn"));
        int i = 0,j=0,n=0;
        tableLayout = (TableLayout) findViewById(R.id.tableLayout);
        textView=(TextView) findViewById(R.id.textView);
        restartbtn=(Button) findViewById(R.id.restartbtn);
        restartbtn.setOnClickListener(this);

        gen();


        //Button[][] btn = new Button[rows][columns];
        for (i = 0; i < rows; ++i) {
            TableRow tableRow = new TableRow(this);
            for (j=0;j<columns;++j) {
                btn[i][j] = new Button(this);
                tableRow.setLayoutParams(new TableLayout.LayoutParams(TableLayout.La