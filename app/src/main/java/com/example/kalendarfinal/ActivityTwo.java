package com.example.kalendarfinal;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class ActivityTwo extends Activity implements View.OnClickListener {
    int kolvodel[][]=new int[32][12];
    String [] mas=new String [5];
    String [][][] delo=new String [32][12][5];
    int[][][]ss=new int[32][12][5];


    String[] days = {  "","Пн", "Вт", "Ср", "Чт", "Пт", "Сб", "Вс" };

    String [] nomerned=new String[6];
    String[] nomerjan={"1","2","3","4","5",""};
    String[] nomerfeb={"6","7","8","9","10",""};
    String[] nomermar={"11","12","13","14","15","16"};
    String[] nomerapr={"17","18","19","20","21",""};
    String[] nomermay={"22","23","24","25","26",""};
    String[] nomerjun={"27","28","29","30","31",""};
    String[] nomerjul={"32","33","34","35","36",""};
    String[] nomeraug={"37","38","39","40","41","42"};
    String[] nomersep={"43","44","45","46","47",""};
    String[] nomeroct={"48","49","50","51","52",""};
    String[] nomernov={"53","54","55","56","57","58"};
    String[] nomerdec={"59","60","61","62","63",""};


    Button [][] cl =new Button[6][7];
    String[] month=new String[42];
    TextView textView;
    TableLayout tableLayout;
    int mnn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_two);

        Intent intent=getIntent();
        Bundle bundle=new Bundle();
        ss=(int[][][])intent.getSerializableExtra("sss");
        mnn=Integer.parseInt(intent.getStringExtra("mnt"));

        if (mnn==0) {
            for (int l = 0; l < 32; l++) {
                kolvodel[l][mnn] = intent.getIntArrayExtra("jan")[l];
                nomerned=nomerjan;
            }
        }
        if (mnn==1) {
            for (int l = 0; l < 32; l++) {
                kolvodel[l][mnn] = intent.getIntArrayExtra("feb")[l];
                nomerned=nomerfeb;
            }
        }
        if (mnn==2) {
            for (int l = 0; l < 32; l++) {
                kolvodel[l][mnn] = intent.getIntArrayExtra("mar")[l];
                nomerned=nomermar;
            }
        }
        if (mnn==3) {
            for (int l = 0; l < 32; l++) {
                kolvodel[l][mnn] = intent.getIntArrayExtra("apr")[l];
                nomerned=nomerapr;
            }
        }
        if (mnn==4) {
            for (int l = 0; l < 32; l++) {
                kolvodel[l][mnn] = intent.getIntArrayExtra("may")[l];
                nomerned=nomermay;
            }
        }
        if (mnn==5) {
            for (int l = 0; l < 32; l++) {
                kolvodel[l][mnn] = intent.getIntArrayExtra("june")[l];
                nomerned=nomerjun;
            }
        }
        if (mnn==6) {
            for (int l = 0; l < 32; l++) {
                kolvodel[l][mnn] = intent.getIntArrayExtra("july")[l];
                nomerned=nomerjul;
            }
        }
        if (mnn==7) {
            for (int l = 0; l < 32; l++) {
                kolvodel[l][mnn] = intent.getIntArrayExtra("aug")[l];
                nomerned=nomeraug;
            }
        }
        if (mnn==8) {
            for (int l = 0; l < 32; l++) {
                kolvodel[l][mnn] = intent.getIntArrayExtra("sept")[l];
                nomerned=nomersep;
            }
        }
        if (mnn==9) {
            for (int l = 0; l < 32; l++) {
                kolvodel[l][mnn] = intent.getIntArrayExtra("oct")[l];
                nomerned=nomeroct;
            }
        }
        if (mnn==10) {
            for (int l = 0; l < 32; l++) {
                kolvodel[l][mnn] = intent.getIntArrayExtra("nov")[l];
                nomerned=nomernov;
            }
        }
        if (mnn==11) {
            for (int l = 0; l < 32; l++) {
                kolvodel[l][mnn] = intent.getIntArrayExtra("dec")[l];
                nomerned=nomerdec;
            }
        }

        //delo=(String[][][])bundle.getSerializable("delo");
        delo=(String[][][])intent.getSerializableExtra("delo");


        tableLayout = (TableLayout) findViewById(R.id.tableLayout);
        textView=(TextView) findViewById(R.id.textView);

        TableRow tableRow = new TableRow(this);
        tableRow.setLayoutParams(new TableLayout.LayoutParams(TableLayout.LayoutParams.MATCH_PARENT,TableLayout.LayoutParams.MATCH_PARENT,1));
        if (mnn==0) { create(0); }
        if (mnn==1) { create(1); }
        if (mnn==2) { create(2); }
        if (mnn==3) { create(3); }
        if (mnn==4) { create(4); }
        if (mnn==5) { create(5); }
        if (mnn==6) { create(6); }
        if (mnn==7) { create(7); }
        if (mnn==8) { create(8); }
        if (mnn==9) { create(9); }
        if (mnn==10) { create(10); }
        if (mnn==11) { create(11); }


        for(int i=0;i<8;i++){
            TextView tw=new TextView(this);
            tw.setText(" "+days[i]);
            tw.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.MATCH_PARENT,TableRow.LayoutParams.MATCH_PARENT,1));
            tableRow.addView(tw);
        }
        tableLayout.addView(tableRow);
        int n=0,t=0;

        for(int j=0;j<6;j++){
             tableRow = new TableRow(this);
          //  tableRow.setLayoutParams(new TableLayout.LayoutParams(TableLayout.LayoutParams.MATCH_PARENT,TableLayout.LayoutParams.MATCH_PARENT,1));
             Button bt=new Button(this);
             bt.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.MATCH_PARENT,TableRow.LayoutParams.MATCH_PARENT,1));
            bt.setText(nomerned[j]);
            bt.setTextColor(Color.GRAY);
            bt.setClickable(false);
            bt.setBackgroundColor(Color.TRANSPARENT);
            tableRow.addView(bt);
             //TextView tww=new TextView(this);
             //tww.setText(nomerned[j]);
            // tww.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.MATCH_PARENT,TableRow.LayoutParams.MATCH_PARENT,1));
            // tableRow.addView(tww);
            for(int k=0;k<7;k++){
                cl[j][k]=new Button(this);
                tableRow.setLayoutParams(new TableLayout.LayoutParams(TableLayout.LayoutParams.MATCH_PARENT,TableLayout.LayoutParams.MATCH_PARENT,1));
                cl[j][k].setText(month[t]);
                cl[j][k].setId(n++);
                cl[j][k].setOnClickListener(this);
                cl[j][k].setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.MATCH_PARENT,TableRow.LayoutParams.MATCH_PARENT,1));
                if(month[t]==""){
                    // cl[j][k].setBackgroundColor(Color.WHITE);
                    cl[j][k].setVisibility(View.INVISIBLE);
                }

                if (month[t]!=""&&kolvodel[Integer.parseInt(month[t])][mnn]==0){
                    cl[j][k].setBackgroundColor(Color.LTGRAY);
                }
                if (month[t]!=""&&kolvodel[Integer.parseInt(month[t])][mnn]>0&&kolvodel[Integer.parseInt(month[t])][mnn]<=2){
                    cl[j][k].setBackgroundColor(Color.YELLOW);
                }
                if (month[t]!=""&&kolvodel[Integer.parseInt(month[t])][mnn]>2){
                    cl[j][k].setBackgroundColor(Color.RED);
                }

                t++;

                tableRow.addView(cl[j][k]);
            }
            tableLayout.addView(tableRow);
        }


    }

    public void create(int num){
        Calendar c = Calendar.getInstance();
        int d=1;
        int dOw=0;
        c.set(1998,num,1);
        int dayOfWeek = c.get(Calendar.DAY_OF_WEEK);
        int daysinMonth = c.getActualMaximum(Calendar.DAY_OF_MONTH);
        if (dayOfWeek==1){dOw=6;}
        if (dayOfWeek==2){dOw=0;}
        if (dayOfWeek==3){dOw=1;}
        if (dayOfWeek==4){dOw=2;}
        if (dayOfWeek==5){dOw=3;}
        if (dayOfWeek==6){dOw=4;}
        if (dayOfWeek==7){dOw=5;}
        for(int i=0;i<dOw;i++){
            month[i]="";
        }
        for(int j=dOw;j<daysinMonth+dOw;j++){
            month[j]=Integer.toString(d);
            d++;
        }
        for(int k=daysinMonth+dOw;k<42;k++){
            month[k]="";
        }

        //for(int y=0;y<42;y++) {
         textView.setText(c.getTime().toString());
        //  }
    }

    @Override
    public void onBackPressed(){
        int[] mt=new int[32];
        Intent i=new Intent();
        for(int l=0;l<32;l++){
            mt[l]=kolvodel[l][mnn];
        }
        Bundle mBundle=new Bundle();
        mBundle.putSerializable("del",delo);
        i.putExtras(mBundle);
        Bundle mBundl=new Bundle();
        mBundl.putSerializable("ss",ss);
        i.putExtras(mBundl);
        i.putExtra("mnn",mnn);
        i.putExtra("mt",mt);
        setResult(RESULT_OK,i);
        finish();
    }




    @Override
    public void onActivityResult(int requestCode,int ResultCode,Intent data){
        if (data==null){return;}
        int defval=0;
        // Bundle bundle=new Bundle();
        // delo=(String[][][])bundle.getSerializable("delo");
        ss=(int[][][])data.getSerializableExtra("ss");
        int dd=data.getIntExtra("dayy",defval);
        mnn=data.getIntExtra("mes",defval);
        int kolvo=data.getIntExtra("kolvodel",defval);
        String [] massiv=new String [5];
        massiv=data.getStringArrayExtra("mas");
        int bId=data.getIntExtra("btid",defval);
        kolvodel[dd][mnn]=kolvo;

        System.arraycopy(massiv,0,delo[dd][mnn],0,massiv.length);
        //delo[dd][mnn]=massiv;

        if(kolvo>0&&kolvo<=2){
            for(int f=0;f<6;f++){
                for(int u=0;u<7;u++){
                    if(bId == cl[f][u].getId()){
                        cl[f][u].setBackgroundColor(Color.YELLOW);
                    }
                }
            }
        }
        if(kolvo==0){
            for(int f=0;f<6;f++){
                for(int u=0;u<7;u++){
                    if(bId == cl[f][u].getId()){
                        cl[f][u].setBackgroundColor(Color.LTGRAY);
                    }
                }
            }
        }
        if(kolvo>2){
            for(int f=0;f<6;f++){
                for(int u=0;u<7;u++){
                    if(bId == cl[f][u].getId()){
                        cl[f][u].setBackgroundColor(Color.RED);
                    }
                }
            }
        }

       /* int dd=Integer.parseInt(data.getStringExtra("day"));
        mas=data.getStringArrayExtra("mas");
        delo[dd][mnn]=mas;*/
    }

    @Override
    public  void onClick(View v){
        String buttonText;
        int d=v.getId();
        for(int k=0;k<6;k++){
            for(int p=0;p<7;p++){
                if(d == cl[k][p].getId()){
                    buttonText=cl[k][p].getText().toString();
                    Intent intent2=new Intent(this,ActivityThree.class);
                    Bundle mBundle=new Bundle();
                    mBundle.putSerializable("ss",ss);
                    intent2.putExtras(mBundle);
                    intent2.putExtra("day",buttonText);
                    intent2.putExtra("month",Integer.toString(mnn));
                    intent2.putExtra("kolvdel",kolvodel[Integer.parseInt(buttonText)][mnn]);
                    intent2.putExtra("mass",delo[Integer.parseInt(buttonText)][mnn]);
                    intent2.putExtra("butId",cl[k][p].getId());
                    // startActivity(intent2);
                    // Intent intent2=new Intent(this,ActivityThree.class);
                    // intent2.putExtra("day",month[k*p]);
                    // intent2.putExtra("month",Integer.toString(mnn));
                   /* Bundle bundle=new Bundle();
                    bundle.putSerializable("deloo",delo);
                    intent2.putExtras(bundle);*/
                    startActivityForResult(intent2,1);
                }
            }
        }

    }


}
