package com.aiub.sayem.buttonevent;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

public class activityB extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_b);
    }
   public void dos(View v){
       Toast t=new Toast(this);
       t.setDuration(t.LENGTH_LONG);
       t.setGravity(Gravity.BOTTOM, 0, 0);
       LayoutInflater inflater=getLayoutInflater();
       View view=inflater.inflate(R.layout.toast,(ViewGroup)findViewById(R.id.root));
       t.setView(view);
       t.show();
   }
}
