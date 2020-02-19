package com.example.kalendarfinal;

import android.app.Activity;
import android.content.Intent;
import android.support.v4.content.res.TypedArrayUtils;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.Arrays;

public class ActivityThree extends Activity implements View.OnClickListener {
    Spinner spinner;
    String [] spin={"0:00","1:00","2:00","3:00","4:00","5:00","6:00","7:00","8:00","9:00","10:00","11:00","12:00","13:00","14:00",
            "15:00","16:00","17:00","18:00","19:00","20:00","21:00","22:00","23:00"};
    int[][][]ss=new int[32][12][5];

    TableLayout tb;
    int kolvodel[][]=new int[32][12];
    EditText et;
    Button btnAdd;
    String [][][] delo=new String [32][12][5];
    String [] mas=new String [5];
    Button [] btt= new Button[5];
    // TableRow tableRow;
    TableRow [] tableRow=new TableRow[5];
    int i=0,n=0,ii=0;
    int den;
    int mes;
    int btid;
    // int den=1;
    // int mes=7;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_three);
        int defval=0;

        ArrayAdapter<String>adapter=new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,spin);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner=(Spinner)findViewById(R.id.spinner);
        spinner.setAdapter(adapter);
        spinner.setPrompt("Time");
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                //ss[i]=(String)parent.getItemAtPosition(position);
                spinner.setSelection(position);

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        Intent intent2=getIntent();
        ss=(int[][][])intent2.getSerializableExtra("ss");
        den=Integer.parseInt(intent2.getStringExtra("day"));
        mes=Integer.parseInt(intent2.getStringExtra("month"));
        int kolvo=intent2.getIntExtra("kolvdel",defval);
        btid=intent2.getIntExtra("butId",defval);
        String [] masiv=new String [5];
        masiv=intent2.getStringArrayExtra("mass");
        kolvodel[den][mes]=kolvo;

        System.arraycopy(masiv,0,delo[den][mes],0,masiv.length);
        //delo[den][mes]=masiv;

        // Bundle bundle=new Bundle();
        // delo=(String[][][])bundle.getSerializable("deloo");
        /*получаем день и месяц*/
        tb=(TableLayout) findViewById(R.id.tbb);
        btnAdd=(Button) findViewById(R.id.buttonAdd);
        et=(EditText) findViewById(R.id.editText2);
        btnAdd.setOnClickListener(this);
        vivod(den,mes);


    }

    public void vivod(int day,int month){
        sort(ss);
        System.arraycopy(delo[day][month],0,mas,0,delo[day][month].length);
       // mas=delo[day][month];
        if (kolvodel[day][month]>0){
            for(i=0;i<kolvodel[day][month];i++){
                tableRow[i] = new TableRow(this);
                bttcreate();
                TextView tww = new TextView(this);
                tww.setText(mas[i]);
                tableRow[i].addView(tww);
                tableRow[i].addView(btt[i]);
                tb.addView(tableRow[i]);
            }
        }
    }

    public void bttcreate(){
        btt[i] = new Button(this);
        btt[i].setOnClickListener(this);
        btt[i].setId(n++);
        //btt[i].setId(i);
        btt[i].setText("del");
    }

    @Override
    public void onBackPressed(){
        //sort(ss);
        Intent in=new Intent();
        Bundle mBundle=new Bundle();
        mBundle.putSerializable("ss",ss);
        in.putExtras(mBundle);
        // Bundle bundle=new Bundle();
        // bundle.putSerializable("delo",delo);
        // in.putExtras(bundle);
      /*  in.putExtra("mess",Integer.toString(mes));
        setResult(RESULT_OK,in);
             finish();*/


        in.putExtra("dayy",den);
        in.putExtra("mes",mes);
        in.putExtra("kolvodel",kolvodel[den][mes]);
        in.putExtra("mas",mas);
        in.putExtra("btid",btid);
        setResult(RESULT_OK,in);
        finish();
    }



    public void sort(int[][][] m){
        int sw=0;
        String swp;
        TableRow tR;
        /*for(int e=kolvodel[den][mes]-1;e>0;e--) {
            for (int r = 0; r < e; r++) {
                if (m[den][mes][r] > m[den][mes][r + 1]) {
                    sw = m[den][mes][r];
                    m[den][mes][r] = m[den][mes][r + 1];
                    m[den][mes][r + 1] = sw;
                    swp = mas[r];
                    mas[r] = mas[r + 1];
                    mas[r + 1] = swp;

                }
            }


        }*/
        for(int e=0;e<kolvodel[den][mes];e++) {
            for (int r = 0; r < kolvodel[den][mes]-1; r++) {
                if (m[den][mes][r] > m[den][mes][r + 1]) {
                    sw = m[den][mes][r];
                    m[den][mes][r] = m[den][mes][r + 1];
                    m[den][mes][r + 1] = sw;

                    swp = mas[r];
                    mas[r] = mas[r + 1];
                    mas[r + 1] = swp;

                    swp = delo[den][mes][r];
                    delo[den][mes][r] = delo[den][mes][r + 1];
                    delo[den][mes][r + 1] = swp;

                }

                }
            }

       // delo[den][mes]=mas;

    }


    @Override
    public void onClick(View v){
        int idd=v.getId();
        if (idd==R.id.buttonAdd) {
            //sort(ss);
            if (i < 5){
                kolvodel[den][mes]++;
            tableRow[i] = new TableRow(this);
            bttcreate();
            String p = et.getText().toString();
            ss[den][mes][i] = spinner.getSelectedItemPosition();
            mas[i] = spinner.getSelectedItem().toString() + "  " + et.getText().toString();
            delo[den][mes][i] = spinner.getSelectedItem().toString() + "  " + et.getText().toString();
            //sort(ss);
            TextView tww = new TextView(this);
            //tww.setText(mas[i]+" "+Integer.toString(kolvodel[den][mes])+" "+Integer.toString(i)+" "+Arrays.toString(delo[den][mes]));
            tww.setText(spinner.getSelectedItem().toString() + " " + p + " " + Arrays.toString(ss[den][mes]));
            //tww.setText(spinner.getSelectedItem().toString()+" "+p);
            tableRow[i].addView(tww);
            tableRow[i].addView(btt[i]);
            tb.addView(tableRow[i]);
            //sort(ss);

            i++;
        }
        }

        for(int y=0;y<kolvodel[den][mes];y++) {
            if (idd == btt[y].getId()){
                tb.removeView(tableRow[y]);
                kolvodel[den][mes]--;
                System.arraycopy(mas,y+1,mas,y,mas.length-1-y);
                System.arraycopy(btt,y+1,btt,y,btt.length-1-y);
                System.arraycopy(tableRow,y+1,tableRow,y,tableRow.length-1-y);
                System.arraycopy(ss[den][mes],y+1,ss[den][mes],y,ss[den][mes].length-1-y);
                //delo[den][mes]=mas;
                System.arraycopy(mas,0,delo[den][mes],0,mas.length);
                i--;
                y=0;

            }
        }


    }

}
