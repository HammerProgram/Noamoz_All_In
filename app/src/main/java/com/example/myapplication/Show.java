package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.opengl.ETC1Util;
import android.os.Bundle;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class Show extends AppCompatActivity
{
    int HowMuch = 0;
    TextView TvTime, TvType;
    String Type, Time;
    EditText EtType, EtTime;
    ListView Lv;
    ArrayAdapter Adap;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show);
        TvTime = findViewById(R.id.TvTime);
        TvType = findViewById(R.id.TvType);
        EtTime = findViewById(R.id.EtTime);
        EtType = findViewById(R.id.EtType);
        Lv =findViewById(R.id.Lv);
        Adap = new ArrayAdapter(this, android.R.layout.simple_list_item_1, MainActivity.PeopleSofi);
        Lv.setAdapter(Adap);

    }
    public void Check(View view)
    {
        if (!EtType.getText().toString().equals(""))
        {
            Type = EtType.getText().toString(); //Pensioner
            if ("p".equals(Type.toLowerCase().substring(0, 1)))
            {
                TvType.setText("" + MainActivity.P);
            }
            Type = EtType.getText().toString(); //Standart
            if ("st".equals(Type.toLowerCase().substring(0, 2)))
            {
                TvType.setText("" + MainActivity.St);
            }
            Type = EtType.getText().toString(); //Child
            if ("c".equals(Type.toLowerCase().substring(0, 1)))
            {
                TvType.setText("" + MainActivity.C);
            }
            Type = EtType.getText().toString(); //Soldier
            if ("so".equals(Type.toLowerCase().substring(0, 2)))
            {
                TvType.setText("" + MainActivity.So);
            }
        }
        if (!EtTime.getText().toString().equals(""))
        {
            Time = EtTime.getText().toString();
            for (int i = 0; i < MainActivity.a; i++)
            {
                if (MainActivity.Arr[i].equals(Time))
                    HowMuch++;
            }
            TvTime.setText("" + HowMuch);
            HowMuch = 0;
        }
    }
}
