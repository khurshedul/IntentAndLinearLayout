package com.aiub.sayem.buttonevent;

import android.content.Intent;
import android.net.Uri;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import java.io.File;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
     int counter=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
    }

    @Override
    protected void onResume() {
        super.onResume();
        counter++;

    }
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("counter", counter);
        Log.d("sayem","saved");

    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
       counter= savedInstanceState.getInt("counter");
        Log.d("sayem","restored");
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }
   public void Dosomething(View v){

       Log.d("sayem","button clicked");
      // Intent i=new Intent(this,activityB.class);
       Intent i=new Intent();
       i.setClassName("com.aiub.sayem.buttonevent", "com.aiub.sayem.buttonevent.activityB");
       startActivity(i);
    }
    public void process(View v){
        Intent i=null,chooser=null;
        if(v.getId()==R.id.geo){
        i=new Intent(android.content.Intent.ACTION_VIEW);
            i.setData(Uri.parse("geo:19.076,72.8777"));
            chooser=Intent.createChooser(i,"Lounch map");
            //startActivity(i);
            startActivity(chooser);
        }
        if(v.getId()==R.id.mar){
            i=new Intent(android.content.Intent.ACTION_VIEW);
            i.setData(Uri.parse("market://details?id=dolphin.developers.com"));
            chooser=Intent.createChooser(i,"Lounch market");
            //startActivity(i);
            startActivity(chooser);
        }
        if(v.getId()==R.id.mail){
            i=new Intent(Intent.ACTION_SEND);
            i.setData(Uri.parse("mailto:"));
            String[]people={"khurshedul@hotmail.com","sumaiyatazzoha@gmail.com"};
            i.putExtra(i.EXTRA_EMAIL,people);
            i.putExtra(i.EXTRA_SUBJECT,"this message is from my app and auto generated");
            i.putExtra(i.EXTRA_TEXT,"Whats up i was testing my app nothing else . have a good day ");
            i.setType("message/rfc822");
            chooser=Intent.createChooser(i,"Send mail");
            startActivity(chooser);

        }
        if(v.getId()==R.id.img){
            i=new Intent(Intent.ACTION_SEND);
            Uri imageUri=Uri.parse("android.resource://com.aiub.sayem.buttonevent/drawable/"+R.drawable.f);
            i.setType("image/*");
            i.putExtra(i.EXTRA_STREAM,imageUri);
            i.putExtra(i.EXTRA_TEXT, "HEY I AM ATTACHING THIS IMAGE");
            chooser=i.createChooser(i,"Send image");
            startActivity(chooser);
        }
        if(v.getId()==R.id.im){
            File pictures= Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES);
            String[] listofpictures=pictures.list();
            Uri uri=null;
            ArrayList<Uri>arrayList=new ArrayList<Uri>();
            for(String picture:listofpictures){
                uri=Uri.parse("file://"+pictures.toString()+"/"+picture);
                arrayList.add(uri);
            }
            i=new Intent(i.ACTION_SEND_MULTIPLE);
            i.setType("image/*");
            i.putExtra(Intent.EXTRA_STREAM,arrayList);
            chooser=i.createChooser(i,"Send multiple");
            startActivity(chooser);
        }
        if(v.getId()==R.id.cal){
            Intent intent=new Intent(this,calculator.class);
            startActivity(intent);
        }
    }
}
