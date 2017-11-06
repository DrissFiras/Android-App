package com.example.yasmine.myapp1;

import android.content.ComponentName;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.Resources;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.graphics.drawable.RoundedBitmapDrawable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawableFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;


import android.content.ClipData;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.provider.MediaStore;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.List;


public class Profile extends Activity {
    Button imageUpload;
    ImageView imageView;
    ImageButton sendmail;
    static final int PICTURE = 1;

    ImageView myimg ;


    public Profile() {
        // Empty constructor required for fragment subclasses
    }

    @Override

    public boolean onOptionsItemSelected(MenuItem item) {

        Intent i1 = new Intent(Profile.this, Home.class);

        startActivity(i1);

        return true;


    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
       /* imageView= (ImageView) findViewById(R.id.imgView);
        imageUpload= (Button) findViewById(R.id.buttonLoadPicture);
        imageUpload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_PICK, android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(intent,PICTURE);

            }
        });  */



        myimg = (ImageView) findViewById(R.id.imgView);
        myimg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_PICK, android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(intent,PICTURE);

            }
        });


        sendmail = (ImageButton) findViewById(R.id.imgsend);
        sendmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent myIntent = new Intent(Intent.ACTION_SEND);

                PackageManager pm = getPackageManager();
                Intent tempIntent = new Intent(Intent.ACTION_SEND);
                tempIntent.setType("*/*");
                List<ResolveInfo> resInfo = pm.queryIntentActivities(tempIntent, 0);
                for (int i = 0; i < resInfo.size(); i++) {
                    ResolveInfo ri = resInfo.get(i);
                    if (ri.activityInfo.packageName.contains("android.gm")) {
                        myIntent.setComponent(new ComponentName(ri.activityInfo.packageName, ri.activityInfo.name));
                        myIntent.setAction(Intent.ACTION_SEND);
                        myIntent.putExtra(Intent.EXTRA_EMAIL, new String[]{"exampleto@gmail.com"});
                        myIntent.setType("message/rfc822");
                        myIntent.putExtra(Intent.EXTRA_TEXT, "extra text");
                        myIntent.putExtra(Intent.EXTRA_SUBJECT, "Extra subject");
                        myIntent.putExtra(Intent.EXTRA_STREAM, Uri.parse("uri://your/uri/string"));
                    }
                }
                startActivity(myIntent);

            }
        });


    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode==PICTURE && resultCode==RESULT_OK && null !=data)
        {

            Uri uri = data.getData();
            String[] prjection ={MediaStore.Images.Media.DATA};
            Cursor cursor=getContentResolver().query(uri,prjection,null,null,null);
            cursor.moveToFirst();

            int columnIndex=cursor.getColumnIndex(prjection[0]);
            String path=cursor.getString(columnIndex);
            cursor.close();

            Bitmap selectFile = BitmapFactory.decodeFile(path);



            Resources res = getResources();

            RoundedBitmapDrawable dr =
                    RoundedBitmapDrawableFactory.create(res , selectFile) ;
            dr.setCornerRadius(Math.max(selectFile.getWidth(), selectFile.getHeight()) / 8.0f);
            dr.setCircular(true);
            myimg.setBackground(dr);


            // imageView.setImageBitmap(BitmapFactory.decodeFile(path));
        }


    }

   /* @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode==PICTURE && resultCode==RESULT_OK && null !=data)
        {

            Uri uri = data.getData();
            String[] prjection ={MediaStore.Images.Media.DATA};
            Cursor cursor=getContentResolver().query(uri,prjection,null,null,null);
            cursor.moveToFirst();

            int columnIndex=cursor.getColumnIndex(prjection[0]);
            String path=cursor.getString(columnIndex);
            cursor.close();

            Bitmap selectFile = BitmapFactory.decodeFile(path);


            Drawable d = new BitmapDrawable(selectFile);
            imageView.setBackground(d);


            // imageView.setImageBitmap(BitmapFactory.decodeFile(path));
        }


    } */


}