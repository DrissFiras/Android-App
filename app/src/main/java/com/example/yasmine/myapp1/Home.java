package com.example.yasmine.myapp1;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.PopupMenu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Home extends AppCompatActivity {
    public ArrayList<Publication> MyList= new ArrayList<Publication>();
    private Button add ;
    public ArrayList <ArrayList<Comment>> Pcomments = new ArrayList<ArrayList<Comment>>()  ;
    Button button1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        //add=(Button) findViewById(R.id.plus);
        /*add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent s = new Intent(getApplicationContext(), NewPublication.class);
                startActivity(s);

            }}); */

        currentPublication();



        ArrayAdapter<Publication> adapter = new MyListAdapter();
        ListView list = (ListView) findViewById(R.id.listview);
        list.setAdapter(adapter);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {




                Intent i = new Intent(getApplicationContext(), Detail.class);
                i.putExtra("position", position);
                startActivity(i);
            }

        });

        button1 = (Button) findViewById(R.id.plus);
        button1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                //Creating the instance of PopupMenu
                PopupMenu popup = new PopupMenu(Home.this, button1);
                //Inflating the Popup using xml file
                popup.getMenuInflater().inflate(R.menu.popup_menu, popup.getMenu());

                //registering popup with OnMenuItemClickListener
                popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    public boolean onMenuItemClick(MenuItem item) {
                        switch (item.getItemId()) {

                            case R.id.addpost:
                                Intent s = new Intent(getApplicationContext(), NewPublication.class);
                                startActivity(s);
                                return true;
                            case R.id.two:
                                Intent s1 = new Intent(getApplicationContext(), Profile.class);
                                startActivity(s1);
                                return true;
                        }


                        return true;
                    }
                });

                popup.show();//showing popup menu
            }
        });//closing the setOnClickListener method






}


    private void currentPublication() {
        MyList.add(new Publication("Firas","Footing","Sport","Je cherche quelqu'un de motivé pour me partager une seance de footing ! ", "date",10,10));
        Pcomments.add(new ArrayList<Comment>());
        MyList.add(new Publication("Yasmine","Watching Suicide Squad","Cinema","Qui sera interresé pour regarder le nouveau Film Suicide Squad en 3D !", "date", 15,15));
        Pcomments.add(new ArrayList<Comment>());
        MyList.add(new Publication("Ilyes","Discussing a book","Culture","J'ai recemment terminer la lecture du roman X et je voudrais en discuter d'avantage avec quelqu'un!","date",20,20));
        Pcomments.add(new ArrayList<Comment>());
        MyList.add(new Publication("Ilyes","Discussing a book","Culture","J'ai recemment terminer la lecture du roman X et je voudrais en discuter d'avantage avec quelqu'un!","date",20,20));
        Pcomments.add(new ArrayList<Comment>());
        MyList.add(new Publication("Ilyes","Discussing a book","Culture","J'ai recemment terminer la lecture du roman X et je voudrais en discuter d'avantage avec quelqu'un!","date",20,20));
        Pcomments.add(new ArrayList<Comment>());
        MyList.add(new Publication("Ilyes","Discussing a book","Culture","J'ai recemment terminer la lecture du roman X et je voudrais en discuter d'avantage avec quelqu'un!","date",20,20));
        Pcomments.add(new ArrayList<Comment>());
        MyList.add(new Publication("Ilyes","Discussing a book","Culture","J'ai recemment terminer la lecture du roman X et je voudrais en discuter d'avantage avec quelqu'un!","date",20,20));
        Pcomments.add(new ArrayList<Comment>());
        MyList.add(new Publication("Ilyes","Discussing a book","Culture","J'ai recemment terminer la lecture du roman X et je voudrais en discuter d'avantage avec quelqu'un!","date",20,20));
        Pcomments.add(new ArrayList<Comment>());
        MyList.add(new Publication("Ilyes","Discussing a book","Culture","J'ai recemment terminer la lecture du roman X et je voudrais en discuter d'avantage avec quelqu'un!","date",20,20));
        Pcomments.add(new ArrayList<Comment>());
    }


    public class MyListAdapter extends ArrayAdapter<Publication>{
        public MyListAdapter(){
            super(Home.this, R.layout.item_view, MyList);
        }

        @NonNull
        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View itemview = convertView ;
            View secondview ;
            if(itemview==null)
            {
                itemview = getLayoutInflater().inflate(R.layout.item_view, parent,false);

            }


            Publication currentpublication = MyList.get(position);

            TextView title=(TextView) itemview.findViewById(R.id.item_title);
            title.setText(currentpublication.getTitle());
            TextView type=(TextView) itemview.findViewById(R.id.item_type);
            type.setText(currentpublication.getType());
            TextView publisher=(TextView) itemview.findViewById(R.id.item_publisher);
            publisher.setText(currentpublication.getPublisher());







            return itemview;

        }






    }
}


