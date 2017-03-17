package com.example.promahmoud.mehanawytask;

import android.app.Activity;
import android.app.ListActivity;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.SearchView;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ExpandableListView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static android.R.id.list;

public class MainActivity extends Activity {
    private ExpandableListView listView;
    private ExpendableListAdapter expendableListAdapter;
    private List<String> lbheader;
    private HashMap<String , List<String>> listhash;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = (ExpandableListView) findViewById(R.id.exlist);
        initData();
        expendableListAdapter = new ExpendableListAdapter(this , lbheader , listhash);
        listView.setAdapter(expendableListAdapter);
        OnLongClick();
           }
    public void  OnLongClick(){
        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {

                AlertDialog.Builder show_url = new AlertDialog.Builder(MainActivity.this);
                show_url.setMessage("Chooser To go To owner or page github")
                        .setCancelable(false)
                        .setPositiveButton("Owner Link", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                finish();
                            }
                        })
                        .setNegativeButton("Repo Link", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.cancel();
                            }
                        });
                AlertDialog alert = show_url.create();
                alert.setTitle("Go To");
                alert.show();


                // Toast.makeText(MainActivity.this , "Happy" , Toast.LENGTH_LONG).show();
                return true;
            }
        });

    }

    private void initData() {
        lbheader = new ArrayList<>();
        listhash = new HashMap<>();

        lbheader.add("Iam");
        lbheader.add("Hard");
        lbheader.add("Working");
        lbheader.add("Man");
        lbheader.add("Need");
        lbheader.add("Life");

        List<String> first = new ArrayList<>();
        first.add("Memo");

        List<String> sec = new ArrayList<>();
        sec.add("Memo");
        sec.add("Memo");
        sec.add("Memo");

        List<String> third = new ArrayList<>();
        third.add("Memo");
        third.add("Memo");
        third.add("Memo");
        third.add("Memo");


        List<String> forth = new ArrayList<>();
        forth.add("Memo");
        forth.add("Memo");
        forth.add("Memo");
        forth.add("Memo");

        List<String> fifth = new ArrayList<>();
        fifth.add("Memo");
        fifth.add("Memo");
        fifth.add("Memo");
        fifth.add("Memo");

        List<String> six = new ArrayList<>();
        six.add("Memo");
        six.add("Memo");
        six.add("Memo");
        six.add("Memo");


        listhash.put(lbheader.get(0),first);
        listhash.put(lbheader.get(1),sec);
        listhash.put(lbheader.get(2),third);
        listhash.put(lbheader.get(3),forth);
        listhash.put(lbheader.get(4),fifth);
        listhash.put(lbheader.get(5),six);



    }
}