package com.example.yasmine.myapp1;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;

public class Detail extends Home {
    public ArrayList<Comment> CommentList = new ArrayList<Comment>();
    public Button showmap ;
    public Publication current ;
    private Integer p=0 ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        Intent intent = getIntent();
        intent.getLongExtra("position",p);

         current =  MyList.get(p);
        showmap=(Button) findViewById(R.id.show);
        showmap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent s = new Intent(getApplicationContext(), MapsActivity.class);
                s.putExtra("lat", current.getLat());
                s.putExtra("lon", current.getLon());
                startActivity(s);

            }});
        CommentList = Pcomments.get(p);
        CommentList.add(new   Comment(current.getPublisher()));
        CommentList.add(new   Comment(current.getPublisher()));
        CommentList.add(new   Comment(current.getPublisher()));
        CommentList.add(new   Comment(current.getPublisher()));
        CommentList.add(new   Comment(current.getPublisher()));
        CommentList.add(new   Comment(current.getPublisher()));

        ArrayAdapter<Comment> Cadapter = new CommentAdapter();
        ListView Clist = (ListView) findViewById(R.id.Cview);
        Clist.setAdapter(Cadapter);

        TextView title = (TextView) findViewById(R.id.title);
        title.setText(current.getTitle());

        TextView publisher = (TextView) findViewById(R.id.publisher);
        publisher.setText(current.getPublisher());

        TextView description = (TextView) findViewById(R.id.description);
        description.setText(current.getDescription());



        TextView type = (TextView) findViewById(R.id.type);
        type.setText(current.getType());

        final EditText comment = (EditText) findViewById(R.id.newc);


        Button btn = (Button) findViewById(R.id.sub);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent s = new Intent(getApplicationContext(), Detail.class);
                CommentList.add(new   Comment(comment.getText().toString()));
                startActivity(s);
            }
        });

    }





    public class CommentAdapter extends ArrayAdapter<Comment> {
        public CommentAdapter(){
            super(Detail.this, R.layout.comment_view, CommentList );}

        @NonNull
        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            View commentview = convertView ;
            if(commentview==null)
            {
                commentview = getLayoutInflater().inflate(R.layout.comment_view, parent,false);

            }


            Comment currentComment = CommentList.get(position);
            TextView comments=(TextView) commentview.findViewById(R.id.comment);
            comments.setText(currentComment.getComment());

            TextView writer=(TextView) commentview.findViewById(R.id.writer);
            writer.setText(currentComment.getComment());



            return commentview;

        }

        

    }



}
