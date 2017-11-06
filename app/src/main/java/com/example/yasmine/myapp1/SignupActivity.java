package com.example.yasmine.myapp1;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v4.graphics.drawable.RoundedBitmapDrawable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawableFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.TimePicker;

import java.text.DateFormat;
import java.util.Calendar;

import static android.app.Activity.RESULT_OK;
import static com.example.yasmine.myapp1.R.id.imageView;

public class SignupActivity extends AppCompatActivity {
    public static final int SELECT_IMAGE = 0;
    private static final int SELECT_PICTURE = 1;
    private String selectedImagePath;
    private Button next ;
    static final int PICTURE = 1;
    ImageView myimageview ;



    DateFormat fmtDateAndTime=DateFormat.getDateTimeInstance();
    TextView dateAndTimeLabel;
    Calendar dateAndTime=Calendar.getInstance();
    DatePickerDialog.OnDateSetListener d=new DatePickerDialog.OnDateSetListener() {
        public void onDateSet(DatePicker view, int year, int monthOfYear,
                              int dayOfMonth) {
            dateAndTime.set(Calendar.YEAR, year);
            dateAndTime.set(Calendar.MONTH, monthOfYear);
            dateAndTime.set(Calendar.DAY_OF_MONTH, dayOfMonth);
            updateLabel();
        }
    };


    private void updateLabel() {
        dateAndTimeLabel.setText(fmtDateAndTime.format(dateAndTime.getTime()));
    }


    private Button avatar ;
    private ImageView img;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);


        Button btn = (Button) findViewById(R.id.birth);

        btn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                new DatePickerDialog(SignupActivity.this,
                        d,
                        dateAndTime.get(Calendar.YEAR),
                        dateAndTime.get(Calendar.MONTH),
                        dateAndTime.get(Calendar.DAY_OF_MONTH)).show();
            }
        });
        dateAndTimeLabel = (TextView) findViewById(R.id.dateview);



        next = (Button) findViewById(R.id.next);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent s = new Intent(getApplicationContext(), Next.class);
                startActivity(s);

            }
        });



        updateLabel();

        myimageview = (ImageView) findViewById(R.id.taswira);
        myimageview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_PICK, android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(intent,PICTURE);

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
            myimageview.setBackground(dr);


            // imageView.setImageBitmap(BitmapFactory.decodeFile(path));
        }


    }
}

