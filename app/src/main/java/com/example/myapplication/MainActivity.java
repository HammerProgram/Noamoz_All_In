package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.content.Intent;
import android.os.Bundle;
import android.sax.StartElementListener;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.security.PublicKey;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity
{
    public static String[] Arr = new String[100];
    public static int a = 0;
    public static int St = 0, So = 0, P = 0, C = 0;
    public static ArrayList<String> PeopleSofi;
    RadioButton[] rbts = new RadioButton[4];
    ArrayList<String> People;
    ArrayAdapter<String> Adap;
    String[] StArr = {"Rehovot", "Ekron", "Be'er Sheva", "Shikun Sela", "Afula", "Tel Aviv"};
    String Temp, Add = "", Rb;
    ListView Lv;
    EditText Et1;
    Intent Go;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Et1 = findViewById(R.id.Et1);
        Go = new Intent(this, Show.class);
        Lv = findViewById(R.id.Lv);
        People = new ArrayList<>();
        PeopleSofi = new ArrayList<>();
        People.add(StArr[0]);
        People.add(StArr[1]);
        People.add(StArr[2]);
        People.add(StArr[3]);
        People.add(StArr[4]);
        People.add(StArr[5]);
        rbts[0]= findViewById(R.id.radioButton);
        rbts[3]= findViewById(R.id.radioButton4);
        rbts[2]= findViewById(R.id.radioButton3);
        rbts[1]= findViewById(R.id.radioButton2);
        Adap = new ArrayAdapter(MainActivity.this, android.R.layout.simple_list_item_1, People);
        Lv.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id)
            {
                Add = Add + StArr[position];
                }
        });
        Lv.setAdapter(Adap);
    }

    public void Continue(View view)
    {
        startActivity(Go);
    }

    public void Next(View view)
    {
        if (Et1.getText().toString().equals(""))
            Toast.makeText(this, "Erorr", Toast.LENGTH_SHORT).show();
        else
            {
            if (rbts[0].isChecked())
            {
                Rb = "1";
                Add = Add + " , " + "Standart, ";
                St++;
            }
            if (rbts[1].isChecked())
            {
                Rb = "2";
                Add = Add + " , " + "Soldier, ";
                So++;

            }
            if (rbts[2].isChecked())
            {
                Rb = "3";
                Add = Add + " , " + "Pensioner, ";
                P++;
            }
            if (rbts[3].isChecked())
            {
                Rb = "4";
                Add = Add + ", " + "Child, ";
                C++;
            }
            Add = Add + Et1.getText().toString(); //קליטת השעה
            Arr[a] = Et1.getText().toString(); //הכנסה למערך כדי שאחרי זה נדע כמה אנשים היו בשעה מסויימת
            a++; //קידום המערך
            PeopleSofi.add(Add); //הוספה למערך הסופי
            Add = "";
            Et1.setText("");
        }
    }

}
