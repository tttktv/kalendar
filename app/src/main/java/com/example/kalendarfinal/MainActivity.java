package com.example.kalendarfinal;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Calendar;

import static android.graphics.Color.GRAY;
import static android.graphics.Color.GREEN;
import static android.graphics.Color.RED;

public class MainActivity extends Activity implements View.OnClickListener {
    int kolvodel[][]=new int[32][12];
    String [] mas=new String [5];
    String [][][] delo=new String [32][12][5];
    int[][][]ss=new int[32][12][5];

    Button [] btn=new Button[12];
    Button btnjan,btnfeb,btnmar,btnapr,btnmay,btnjun,btnjul,btnaug,btnsep,btnoct,btnnov,btndec;

    int Month;
    TextView tw;
    String mnt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Calendar calendar = Calendar.getInstance();
        Month = calendar.get(Calendar.MONTH);
        tw=findViewById(R.id.textView);

        btnjan=(Button) findViewById(R.id.january);
        btnfeb=(Button) findViewById(R.id.february);
        btnmar=(Button) findViewById(R.id.march);
        btnapr=(Button) findViewById(R.id.april);
        btnmay=(Button) findViewById(R.id.may);
        btnjun=(Button) findViewById(R.id.june);
        btnjul=(Button) findViewById(R.id.july);
        btnaug=(Button) findViewById(R.id.august);
        btnsep=(Button) findViewById(R.id.september);
        btnoct=(Button) findViewById(R.id.october);
        btnnov=(Button) findViewById(R.id.november);
        btndec=(Button) findViewById(R.id.december);

        btnjan.setOnClickListener(this);
        btnfeb.setOnClickListener(this);
        btnmar.setOnClickListener(this);
        btnapr.setOnClickListener(this);
        btnmay.setOnClickListener(this);
        btnjun.setOnClickListener(this);
        btnjul.setOnClickListener(this);
        btnaug.setOnClickListener(this);
        btnsep.setOnClickListener(this);
        btnoct.setOnClickListener(this);
        btnnov.setOnClickListener(this);
        btndec.setOnClickListener(this);

        btn[0]=btnjan;
        btn[1]=btnfeb;
        btn[2]=btnmar;
        btn[3]=btnapr;
        btn[4]=btnmay;
        btn[5]=btnjun;
        btn[6]=btnjul;
        btn[7]=btnaug;
        btn[8]=btnsep;
        btn[9]=btnoct;
        btn[10]=btnnov;
        btn[11]=btndec;


        //tw.setText(Integer.toString(btnjan.getId())+"|"+Integer.toString(btnfeb.getId())+"|"+Integer.toString(btnmar.getId())+"|");
        tw.setText("");

        for (int i=0;i<Month;i++){
            btn[i].setBackgroundColor(Color.LTGRAY);
        }
        for (int j=Month;j<12;j++){
            btn[j].setBackgroundColor(GREEN);
        }
    }


    @Override
    public void onActivityResult(int requestCode,int ResultCode,Intent data){
        if (data==null){return;}
        int defv=0;
        Bundle bundle=new Bundle();
        delo=(String[][][])data.getSerializableExtra("del");
        ss=(int[][][])data.getSerializableExtra("ss");
        //delo=(String[][][])bundle.getSerializable("del");
        int mo=data.getIntExtra("mnn",defv);
        for(int l=0;l<32;l++){
            kolvodel[l][mo]=data.getIntArrayExtra("mt")[l];
        }
    }


    @Override
    public  void onClick(View v){
        Intent intent=new Intent(this,ActivityTwo.class);
        Bundle mBundle=new Bundle();
        switch (v.getId()){
            case R.id.january:
                mnt="0";
                int[] jan=new int[32];
                for(int l=0;l<32;l++){
                    jan[l]=kolvodel[l][0];
                }
                mBundle.putSerializable("delo",delo);
                mBundle.putSerializable("sss",ss);

                intent.putExtra("mnt",mnt);
                intent.putExtra("jan",jan);

                intent.putExtras(mBundle);
                startActivityForResult(intent,1);
                // startActivity(intent);
                break;
            case R.id.february:
                mnt="1";
                int[] feb=new int[32];
                for(int l=0;l<32;l++){
                    feb[l]=kolvodel[l][1];
                }
                mBundle.putSerializable("delo",delo);
                mBundle.putSerializable("sss",ss);

                intent.putExtra("mnt",mnt);
                intent.putExtra("feb",feb);

                intent.putExtras(mBundle);
                startActivityForResult(intent,1);
                break;
            case R.id.march:
                mnt="2";
                int[] mar=new int[32];
                for(int l=0;l<32;l++){
                    mar[l]=kolvodel[l][2];
                }
                mBundle.putSerializable("delo",delo);
                mBundle.putSerializable("sss",ss);

                intent.putExtra("mnt",mnt);
                intent.putExtra("mar",mar);

                intent.putExtras(mBundle);
                startActivityForResult(intent,1);
                //startActivity(intent);
                break;
            case R.id.april:
                int[] apr=new int[32];
                mnt="3";
                for(int l=0;l<32;l++){
                    apr[l]=kolvodel[l][3];
                }
                mBundle.putSerializable("delo",delo);
                mBundle.putSerializable("sss",ss);

                intent.putExtra("mnt",mnt);
                intent.putExtra("apr",apr);

                intent.putExtras(mBundle);
                startActivityForResult(intent,1);
                //startActivity(intent);
                break;
            case R.id.may:
                int[] may=new int[32];
                mnt="4";
                for(int l=0;l<32;l++){
                    may[l]=kolvodel[l][4];
                }
                mBundle.putSerializable("delo",delo);
                mBundle.putSerializable("sss",ss);

                intent.putExtra("mnt",mnt);
                intent.putExtra("may",may);

                intent.putExtras(mBundle);
                //startActivity(intent);
                startActivityForResult(intent,1);
                break;
            case R.id.june:
                int[] june=new int[32];
                mnt="5";
                for(int l=0;l<32;l++){
                    june[l]=kolvodel[l][5];
                }
                mBundle.putSerializable("delo",delo);
                mBundle.putSerializable("sss",ss);

                intent.putExtra("mnt",mnt);
                intent.putExtra("june",june);

                intent.putExtras(mBundle);
                //startActivity(intent);
                startActivityForResult(intent,1);
                break;
            case R.id.july:
                mnt="6";
                int[] july=new int[32];
                for(int l=0;l<32;l++){
                    july[l]=kolvodel[l][6];
                }
                mBundle.putSerializable("delo",delo);
                mBundle.putSerializable("sss",ss);

                intent.putExtra("mnt",mnt);
                intent.putExtra("july",july);

                intent.putExtras(mBundle);
                startActivityForResult(intent,1);
                break;
            case R.id.august:
                mnt="7";
                int[] aug=new int[32];
                for(int l=0;l<32;l++){
                    aug[l]=kolvodel[l][7];
                }
                mBundle.putSerializable("delo",delo);
                mBundle.putSerializable("sss",ss);

                intent.putExtra("mnt",mnt);
                intent.putExtra("aug",aug);

                intent.putExtras(mBundle);
                startActivityForResult(intent,1);
                //startActivity(intent);
                break;
            case R.id.september:
                mnt="8";
                int[] sept=new int[32];
                for(int l=0;l<32;l++){
                    sept[l]=kolvodel[l][8];
                }
                mBundle.putSerializable("delo",delo);
                mBundle.putSerializable("sss",ss);

                intent.putExtra("mnt",mnt);
                intent.putExtra("sept",sept);

                intent.putExtras(mBundle);
                startActivityForResult(intent,1);
                break;
            case R.id.october:
                mnt="9";
                int[] oct=new int[32];
                for(int l=0;l<32;l++){
                    oct[l]=kolvodel[l][9];
                }
                mBundle.putSerializable("delo",delo);
                mBundle.putSerializable("sss",ss);

                intent.putExtra("mnt",mnt);
                intent.putExtra("oct",oct);

                intent.putExtras(mBundle);
                startActivityForResult(intent,1);
                break;
            case R.id.november:
                mnt="10";
                int[] nov=new int[32];
                for(int l=0;l<32;l++){
                    nov[l]=kolvodel[l][10];
                }
                mBundle.putSerializable("delo",delo);
                mBundle.putSerializable("sss",ss);

                intent.putExtra("mnt",mnt);
                intent.putExtra("nov",nov);

                intent.putExtras(mBundle);
                startActivityForResult(intent,1);
                break;
            case R.id.december:
                mnt="11";
                int[] dec=new int[32];
                for(int l=0;l<32;l++){
                    dec[l]=kolvodel[l][11];
                }
                mBundle.putSerializable("delo",delo);
                mBundle.putSerializable("sss",ss);

                intent.putExtra("mnt",mnt);
                intent.putExtra("dec",dec);

                intent.putExtras(mBundle);
                startActivityForResult(intent,1);
                break;
            default:
                break;
        }

    }

}
